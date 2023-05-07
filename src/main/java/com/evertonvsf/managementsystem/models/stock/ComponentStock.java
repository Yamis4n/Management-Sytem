package com.evertonvsf.managementsystem.models.stock;

public class ComponentStock {
    private Component component;
    private int quantity;
    private double price;

    public ComponentStock(int quantity, double price, int componentId) {
        this.quantity = quantity;
        this.price = price;
        this.setComponent(componentId);
    }

    public Component getComponent(){
        return this.component;
    }

    public void setComponent(int componentId) {
        switch (componentId) {
            case 0 -> this.component = Component.NONE;
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
}
