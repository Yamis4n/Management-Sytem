package com.evertonvsf.managementsystem.models.task;

public enum ServiceOrderStatus {
    WAITING("WAITING"),
    INITIALIZED("INITIALIZED"),
    FINISHED("FINISHED"),
    CANCELED("CANCELED"),
    PAID("PAID");
    private final String statusName;

    ServiceOrderStatus(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusName() {
        return statusName;
    }
}
