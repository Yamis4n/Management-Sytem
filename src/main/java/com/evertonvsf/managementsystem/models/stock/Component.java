package com.evertonvsf.managementsystem.models.stock;

public enum Component {
    NONE(0, "NONE"),
    RAM(1, "RAM"),
    HD_SSD(2, "HD/SSD"),
    MOTHERBOARD(3, "MOTHERBOARD"),
    POWER_SUPPLY (4, "POWER SUPPLY"),
    VIDEO_CARD (5, "VIDEO CARD");

    private final int id;
    private final String name;

    Component(int id, String name){
        this.id = id;
        this.name = name;
    };


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
