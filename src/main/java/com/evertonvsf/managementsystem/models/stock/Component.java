package com.evertonvsf.managementsystem.models.stock;

public class Component {
    ComponentId id;
    int quantity;
    String description;
    double value;

    public Component(int id, int quantity, double value){
        this.setId(id);
        this.quantity = quantity;
        this.value = value;
    }

    public int getId() {
        return id.getId();
    }

    public void setId(int id) {
        switch (id) {
            case 1 -> this.id = ComponentId.RAM;
            case 2 -> this.id = ComponentId.HD_SSD;
            case 3 -> this.id = ComponentId.MOTHERBOARD;
            case 4 -> this.id = ComponentId.POWER_SUPPLY;
            case 5 -> this.id = ComponentId.VIDEO_CARD;
            default -> this.id = ComponentId.OTHER;
        }

    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
