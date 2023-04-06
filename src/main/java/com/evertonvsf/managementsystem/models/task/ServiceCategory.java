package com.evertonvsf.managementsystem.models.task;

public enum ServiceCategory {
    MOUNTING("MOUNTING"),
    CLEANING("CLEANING"),
    FORMATTING_INSTALLATION("FORMATTING");
    private final String serviceName;

    ServiceCategory(String name){
        this.serviceName = name;
    }

    public String getServiceName() {
        return serviceName;
    }
}
