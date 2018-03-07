package me.chinatsui.flash.migration;

import me.chinatsui.flash.util.PSet;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OnlineMigrationService {

    private final int workerCount;

    private PSet<OnlineMigration> completed;
    private PSet<OnlineMigration> pending;

    public OnlineMigrationService(PSet<OnlineMigration> migrations, int workerCount) {
        for (OnlineMigration m : migrations) {
            verifyNoCircularDependencies(m, PSet.empty());
        }

        this.workerCount = workerCount;
        completed = getCompletedFromDB();
        pending = migrations.minus(completed);
    }

    public void start() {
        ExecutorService pool = Executors.newFixedThreadPool(workerCount);
        for (int i = 1; i <= workerCount; i++) {
            OnlineMigrationWorker worker = new OnlineMigrationWorker(this);
            pool.submit(worker);
        }
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

    PSet<OnlineMigration> getCompletedFromDB() {
        return PSet.empty();
    }

    void loadToDB(OnlineMigration onlineMigration, OnlineMigrationResult result) {
        String msg = String.format("Loading migration: %s into database...", onlineMigration);
        System.out.println(msg);
    }

    private void verifyNoCircularDependencies(OnlineMigration m, PSet<OnlineMigration> seen) {

        if (seen.contains(m)) {
            throw new RuntimeException("CircularDependencies Error.");
        }

        for (OnlineMigration d : m.getDependencies()) {
            if (d.getDependencies().intersect(seen).size() > 0) {
                throw new RuntimeException("CircularDependencies Error.");
            }
        }

    }

}
