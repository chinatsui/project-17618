package me.chinatsui.flash.migration.jdbc;

import me.chinatsui.flash.migration.OnlineMigration;
import me.chinatsui.flash.migration.OnlineMigrationResult;
import me.chinatsui.flash.util.PSet;

public enum OnlineMigrationDataSource {

    INSTANCE;

    private final PSet<OnlineMigration> data;

    OnlineMigrationDataSource() {
        data = PSet.empty();
    }

    public PSet<OnlineMigration> getCompleted(PSet<OnlineMigration> migrations){
        PSet<OnlineMigration> completed = PSet.empty();
        for (OnlineMigration m : data) {
            if (OnlineMigrationResult.DONE == m.getResult()) {
                completed.plus(m);
            }
        }
        return completed;
    }

}
