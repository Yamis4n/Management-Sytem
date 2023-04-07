package com.evertonvsf.managementsystem.models.money;

public class Payment {

    private int id;
    private int invoiceId;
    private String paymentMethod;
    private double value;

    public Payment(int invoiceId, String paymentMethod, double value) {
        this.invoiceId = invoiceId;
        this.paymentMethod = paymentMethod;
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

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
