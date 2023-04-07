package com.evertonvsf.managementsystem.models.stock;

public class Component {
    private ComponentId id;
    private int quantity;
    private double value;

    public Component(int quantity, double value){
        this.quantity = quantity;
        this.value = value;
    }

    public int getId() {
        return id.getId();
    }

    public void setId(int id) {
        switch (id) {
            case 0 -> this.id = ComponentId.RAM;
            case 1 -> this.id = ComponentId.HD_SSD;
            case 2 -> this.id = ComponentId.MOTHERBOARD;
            case 3 -> this.id = ComponentId.POWER_SUPPLY;
            default -> this.id = ComponentId.VIDEO_CARD;
        }

    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
