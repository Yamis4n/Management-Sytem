package com.evertonvsf.managementsystem.models.stock;

import java.io.Serializable;

public class ComponentStock implements Serializable {
    private int id;
    private Component component;
    private Integer quantity;
    private Double price;

    public ComponentStock(Integer quantity, double price, Component component) {
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
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

    public String getComponentDescription(){
        return  this.component.getDescription();
    }
    public String getComponentType(){
        return this.component.getType().getName();
    }
}
