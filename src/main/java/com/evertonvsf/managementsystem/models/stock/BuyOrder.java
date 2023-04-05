package com.evertonvsf.managementsystem.models.stock;

public class BuyOrder {
    int componentId;
    int quantity;
    double unitaryCost;
    String componentDescription; // only used if componentID == 6

    public BuyOrder(int componentId, int quantity, double unitaryCost) {
        this.componentId = componentId;
        this.quantity = quantity;
        this.unitaryCost = unitaryCost;
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

    public String getComponentDescription() {
        return componentDescription;
    }

    public void setComponentDescription(String componentDescription) {
        this.componentDescription = componentDescription;
    }
}
