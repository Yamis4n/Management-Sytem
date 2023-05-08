package com.evertonvsf.managementsystem.models.money;


import java.io.Serializable;

public class Invoice implements Serializable {
    private int id, ServiceOrderId;
    private double totalValue, paidValue;

    public Invoice(int serviceOrderId, double totalValue) {
        this.ServiceOrderId = serviceOrderId;
        this.totalValue = totalValue;
        this.paidValue = 0;
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

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", ServiceOrderId=" + ServiceOrderId +
                ", totalValue=" + totalValue +
                ", paidValue=" + paidValue +
                '}';
    }
}
