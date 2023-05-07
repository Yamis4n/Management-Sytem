package com.evertonvsf.managementsystem.models.task;

public enum ServiceCategory {
    MOUNTING_RAM("MOUNTING_RAM", 20, 1),
    MOUNTING_HD_SSD("MOUNTING HD/SSD", 30, 2),
    MOUNTING_MOTHERBOARD("MOUNTING MOTHERBOARD", 100, 3),
    MOUNTING_POWER_SUPPLY("MOUNTING POWER SUPPLY", 30, 4),
    MOUNTING_VIDEO_CARD("MOUNTING VIDEO CARD", 100, 5),
    FORMATTING_INSTALLATION_PROGRAMS("FORMATTING/INSTALLING PROGRAMS", 10, 0),
    FORMATTING_INSTALLATION_OS("FORMATTING/INSTALLING OS", 50, 0),
    CLEANING("CLEANING", 70, 0);
    private final String serviceName;
    private final double price;
    private final int componentId;

    ServiceCategory(String name, double price, int componentId){
        this.serviceName = name;
        this.price = price;
        this.componentId = componentId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public double getPrice() {
        return price;
    }
    public int getComponentId(){
        return componentId;
    }
}
