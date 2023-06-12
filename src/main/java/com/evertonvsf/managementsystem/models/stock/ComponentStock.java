package com.evertonvsf.managementsystem.models.stock;

import java.io.Serializable;

public class ComponentStock implements Serializable {
    private Component component;
    private String description;
    private int quantity;
    private double price;

    public ComponentStock(int quantity, double price, int componentId, String description) {
        this.quantity = quantity;
        this.price = price;
        this.description = description;
        this.setComponent(componentId);
    }

    public Component getComponent(){
        return this.component;
    }

    public void setComponent(int componentId) {
        switch (componentId) {
            case 0 -> this.component = Component.OTHER;
            case 1 -> this.component = Component.RAM;
            case 2 -> this.component = Component.HD_SSD;
            case 3 -> this.component = Component.MOTHERBOARD;
            case 4 -> this.component = Component.POWER_SUPPLY;
            default -> this.component = Component.VIDEO_CARD;
        }

    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ComponentStock{" +
                "component=" + component.getName() +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
