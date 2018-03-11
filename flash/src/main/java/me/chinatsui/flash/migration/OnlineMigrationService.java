package me.chinatsui.flash.migration;

import me.chinatsui.flash.migration.jdbc.OnlineMigrationDataSource;
import me.chinatsui.flash.util.PSet;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class OnlineMigrationService {

    private final OnlineMigrationDataSource dataSource = OnlineMigrationDataSource.INSTANCE;

    private int workerCount;

    private PSet<OnlineMigration> completed;
    private PSet<OnlineMigration> pending;

    public OnlineMigrationService(PSet<OnlineMigration> migrations, int workerCount) {
        for (OnlineMigration m : migrations) {
            verifyNoCircularDependencies(m, PSet.of(m));
        }

        this.workerCount = workerCount;
        completed = dataSource.getCompleted(migrations);
        pending = migrations.minus(completed);
    }

    public void doMigrations() throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(workerCount);
        for (int i = 0; i < workerCount; i++) {
            pool.submit(new OnlineMigrationWorker(this));
        }
        pool.shutdown();
        pool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
    }

    synchronized OnlineMigration getNextExecuteMigration() {
        for (OnlineMigration migration : pending) {
            if (migration.getDependencies().minus(completed).isEmpty()) {
                pending = pending.minus(migration);
                return migration;
            }
        }
        return null;
    }

    synchronized void markAsCompleted(OnlineMigration migration) {
        if (!completed.contains(migration)) {
            completed.plus(migration);
        }
    }

    private void verifyNoCircularDependencies(OnlineMigration m, PSet<OnlineMigration> seen) {
        if (m.getDependencies() == null) {
            return;
        }

        if (m.getDependencies().intersect(seen).size() > 0) {
            throw new RuntimeException("Circular migration dependency involves in "
                    + m.getClass() + " through " + seen);
        }

        for (OnlineMigration d : m.getDependencies()) {
            verifyNoCircularDependencies(d, PSet.of(seen).plus(d));
        }
    }

}
