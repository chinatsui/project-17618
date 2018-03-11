package me.chinatsui.flash.migration;

public class OnlineMigrationWorker implements Runnable {

    private OnlineMigrationService service;

    public OnlineMigrationWorker(OnlineMigrationService service) {
        this.service = service;
    }

    @Override
    public void run() {
        OnlineMigration migration = service.getNextExecuteMigration();

        while (migration != null) {
            OnlineMigrationResult result = OnlineMigrationResult.PARTIAL_DONE;
            while (result != OnlineMigrationResult.DONE) {
                result = migration.execute();
            }
            service.markAsCompleted(migration);
            migration = service.getNextExecuteMigration();
        }
    }

}
