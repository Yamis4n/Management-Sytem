package com.evertonvsf.managementsystem.models.stock;

public enum ComponentType {
    OTHER("OTHER"),
    RAM("RAM"),
    HD_SSD("HD/SSD"),
    MOTHERBOARD("MOTHERBOARD"),
    POWER_SUPPLY ("POWER SUPPLY"),
    VIDEO_CARD ("VIDEO CARD");

    private final String name;

    ComponentType( String name ){
        this.name = name;
    };


    public String getName() {
        return name;
    }
}
