package com.evertonvsf.managementsystem.models.stock;

public enum ComponentId {
    RAM(1, "RAM", 20),
    HD_SSD(2, "HD/SSD", 30),
    MOTHERBOARD(3, "MOTHERBOARD", 100),
    POWER_SUPPLY (4, "POWER SUPPLY", 30),
    VIDEO_CARD (5, "VIDEO CARD", 100);

    private final int id;
    private final String name;
    private final double servicePrice;
    ComponentId(int id, String name, double servicePrice){
        this.id = id;
        this.name = name;
        this.servicePrice = servicePrice;
    };

    public double getServicePrice() {
        return servicePrice;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
