package com.evertonvsf.managementsystem.models.stock;

public class BuyOrder {
    private int id;
    private int technicianId;
    private int componentId;
    private int quantity;
    private double unitaryCost;
    private String componentDescription; // only used if componentID == 6

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

    public void setTechnicianId(int technicianId) {
        this.technicianId = technicianId;
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
