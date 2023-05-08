package com.evertonvsf.managementsystem.models.stock;

import java.io.Serializable;

public class BuyOrder implements Serializable {
    private int id, componentId, quantity;
    private final int technicianId;
    private double unitaryCost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BuyOrder(int technicianId, int componentId, int quantity, double unitaryCost) {
        this.technicianId = technicianId;
        this.componentId = componentId;
        this.quantity = quantity;
        this.unitaryCost = unitaryCost;
    }

    public int getTechnicianId() {
        return technicianId;
    }

    public int getComponentId() {
        return componentId;
    }

    public void setComponentId(int componentId) {
        this.componentId = componentId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitaryCost() {
        return unitaryCost;
    }

    public void setUnitaryCost(double unitaryCost) {
        this.unitaryCost = unitaryCost;
    }

    @Override
    public String toString() {
        return "BuyOrder{" +
                "id=" + id +
                ", componentId=" + componentId +
                ", quantity=" + quantity +
                ", technicianId=" + technicianId +
                ", unitaryCost=" + unitaryCost +
                '}';
    }
}
