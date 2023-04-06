package com.evertonvsf.managementsystem.models.money;

public class Payment {

    private int id;
    private int invoiceId;
    private String paymentWay;
    private double value;

    public Payment(int invoiceId, String paymentWay, double value) {
        this.invoiceId = invoiceId;
        this.paymentWay = paymentWay;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getPaymentWay() {
        return paymentWay;
    }

    public void setPaymentWay(String paymentWay) {
        this.paymentWay = paymentWay;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
