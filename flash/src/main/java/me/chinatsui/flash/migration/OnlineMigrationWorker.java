package me.chinatsui.flash.migration;

public class OnlineMigrationWorker implements Runnable {

    private OnlineMigrationService onlineMigrationService;

    public OnlineMigrationWorker(OnlineMigrationService onlineMigrationService) {
        this.onlineMigrationService = onlineMigrationService;
    }

    @Override
    public void run() {

    }

}
