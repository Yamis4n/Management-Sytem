package com.evertonvsf.managementsystem.models.stock;

import java.io.Serializable;

public class Component implements Serializable {
    private int id;
    private ComponentType type;
    private Integer quantity;
    private Double buyPrice;
    private String description;

    public Component(Integer quantity, double price, String description, ComponentType type) {
        this.quantity = quantity;
        this.buyPrice = price;
        this.type = type;
        this.description = description;
    }


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Double buyPrice) {
        this.buyPrice = buyPrice;
    }

    @Override
    public String toString() {
        return "ComponentStock{" +
                "component=" + description +
                ", quantity=" + quantity +
                ", price=" + buyPrice +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ComponentType getType() {
        return type;
    }

    public void setType(ComponentType type) {
        this.type = type;
    }
}
