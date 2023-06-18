package com.evertonvsf.managementsystem.models.task;

public enum ServiceCategory {
    MOUNTING_RAM("MOUNTING_RAM", 20),
    MOUNTING_OTHER("MOUNTING_OTHER", 20),
    MOUNTING_HD_SSD("MOUNTING HD/SSD", 30),
    MOUNTING_MOTHERBOARD("MOUNTING MOTHERBOARD", 100),
    MOUNTING_POWER_SUPPLY("MOUNTING POWER SUPPLY", 30),
    MOUNTING_VIDEO_CARD("MOUNTING VIDEO CARD", 100),
    FORMATTING_INSTALLATION_PROGRAMS("FORMATTING/INSTALLING PROGRAMS", 10),
    FORMATTING_INSTALLATION_OS("FORMATTING/INSTALLING OS", 50),
    CLEANING("CLEANING", 70);
    private final String serviceName;
    private final double price;

    ServiceCategory(String name, double price){
        this.serviceName = name;
        this.price = price;
    }

    public String getServiceName() {
        return serviceName;
    }

    public double getPrice() {
        return price;
    }
}
