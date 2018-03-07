package me.chinatsui.flash.migration;

public class OnlineMigrationWorker implements Runnable {

    private OnlineMigrationService service;

    public OnlineMigrationWorker(OnlineMigrationService service) {
        this.service = service;
    }

    @Override
    public void run() {
        OnlineMigration migration = service.getNextExecuteMigration();

        if (migration != null) {
            OnlineMigrationResult result = migration.execute();
            while (result != OnlineMigrationResult.DONE) {
                service.loadToDB(migration, result);
                result = migration.execute();
            }
            service.loadToDB(migration, result);
        }
    }

}
