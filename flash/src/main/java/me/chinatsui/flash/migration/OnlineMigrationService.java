package me.chinatsui.flash.migration;

import me.chinatsui.flash.util.PSet;

public class OnlineMigrationService {

    private PSet<OnlineMigration> all;
    private PSet<OnlineMigration> pending;

    public OnlineMigrationService() {

    }

    public void start() {
        PSet<OnlineMigration> completed = getCompletedFromDB();
        pending = all.minus(completed);

        for (OnlineMigration migration : pending) {

        }

    }

    synchronized OnlineMigration getNextPendingMigration() {
        return null;
    }

    PSet<OnlineMigration> getCompletedFromDB() {
        return null;
    }

    void loadToDB(OnlineMigration onlineMigration) {

    }

    private void verifyNoCycleDependencies(OnlineMigration onlineMigration) {

    }

}
