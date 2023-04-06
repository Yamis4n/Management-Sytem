package com.evertonvsf.managementsystem.models.task;

public enum ServiceStatus {
    FINISHED("FINISHED"),
    INITIALIZED("INITIALIZED"),
    ;
    private final String status;

    ServiceStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
