package com.evertonvsf.managementsystem.models.task;

public enum Status {
    WAITING("WAITING"),
    INITIALIZED("INITIALIZED"),
    FINISHED("FINISHED"),
    CANCELED("CANCELED");
    private final String statusName;

    Status(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusName() {
        return statusName;
    }
}
