package com.evertonvsf.managementsystem.models.stock;

import java.io.Serializable;

public class ComponentStock implements Serializable {
    private int id;
    private Component component;
    private int quantity;
    private double price;

    public ComponentStock(int quantity, double price, Component component) {
        this.quantity = quantity;
        this.price = price;
        this.component = component;
    }

    public Component getComponent(){
        return this.component;
    }

    public void setComponent(Component component) {
        this.component = component;

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
                "component=" + component.getDescription() +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
