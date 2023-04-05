package com.evertonvsf.managementsystem.models.money;

public class Invoice {
    int id;
    int ServiceOrderId;
    double totalValue;
    double paidValue;

    public Invoice(int serviceOrderId, double totalValue) {
        ServiceOrderId = serviceOrderId;
        this.totalValue = totalValue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getServiceOrderId() {
        return ServiceOrderId;
    }

    public void setServiceOrderId(int serviceOrderId) {
        ServiceOrderId = serviceOrderId;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public double getPaidValue() {
        return paidValue;
    }

    public void setPaidValue(double paidValue) {
        this.paidValue = paidValue;
    }
}
