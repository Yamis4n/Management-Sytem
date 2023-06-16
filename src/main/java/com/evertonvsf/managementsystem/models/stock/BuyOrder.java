package com.evertonvsf.managementsystem.models.stock;

import java.io.Serializable;

public class BuyOrder implements Serializable {
    private int id;
    private final int componentId, quantity;
    private final String technicianUsername;
    private final String componentType;
    private final double unitaryCost;
    private boolean status;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BuyOrder(String technicianUsername, int componentId, int quantity, String componentType, double unitaryCost) {
        this.technicianUsername = technicianUsername;
        this.componentId = componentId;
        this.quantity = quantity;
        this.componentType = componentType;
        this.unitaryCost = unitaryCost;
        this.status = false;
    }

    public String getTechnicianUsername() {
        return technicianUsername;
    }

    public Integer getComponentId() {
        return componentId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getUnitaryCost() {
        return unitaryCost;
    }



    @Override
    public String toString() {
        return "BuyOrder{" +
                "id=" + id +
                ", componentId=" + componentId +
                ", quantity=" + quantity +
                ", technicianId=" + technicianUsername +
                ", unitaryCost=" + unitaryCost +
                '}';
    }


    public Boolean isArrived() {
        return this.status;
    }

    public void setArrived(boolean arrived) {
        this.status = arrived;
    }

    public String getComponentType() {
        return componentType;
    }
}
