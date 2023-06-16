package com.evertonvsf.managementsystem.models.stock;

import java.io.Serializable;

public class ComponentStock implements Serializable {
    private int id;
    private Component component;
    private Integer quantity;
    private Double buyPrice; // valor de compra
    private Double value; // valor de venda

    public ComponentStock(Integer quantity, double price, Component component, double value) {
        this.quantity = quantity;
        this.buyPrice = price;
        this.component = component;
        this.value = value;
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

    public Double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Double buyPrice) {
        this.buyPrice = buyPrice;
    }

    @Override
    public String toString() {
        return "ComponentStock{" +
                "component=" + component.getDescription() +
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

    public String getComponentDescription(){
        return  this.component.getDescription();
    }
    public String getComponentType(){
        return this.component.getType().getName();
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
