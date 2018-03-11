package me.chinatsui.flash.migration;

import me.chinatsui.flash.util.PSet;

public interface OnlineMigration {

    OnlineMigrationResult execute();

    PSet<OnlineMigration> getDependencies();

    OnlineMigrationResult getResult();

}
