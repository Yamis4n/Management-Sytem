package com.evertonvsf.managementsystem.models.money;

public class Payment {

    private int id;
    private int invoiceId;
    private PaymentMethod paymentMethod;
    private double value;

    public Payment(int invoiceId, int paymentMethod, double value) {
        this.invoiceId = invoiceId;
        this.setPaymentMethod(paymentMethod);
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
        return paymentMethod.getMethod()    ;
    }

    public void setPaymentMethod(int paymentMethod) {
        switch (paymentMethod){
            case 0 -> this.paymentMethod = PaymentMethod.CASH;
            case 1 -> this.paymentMethod = PaymentMethod.DEBIT_CARD;
            case 2 -> this.paymentMethod = PaymentMethod.CREDIT_CARD;
            case 3 -> this.paymentMethod = PaymentMethod.BANK_TRANSFER;
            case default -> this.paymentMethod = PaymentMethod.PIX;
        }

    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", invoiceId=" + invoiceId +
                ", paymentMethod=" + paymentMethod.getMethod() +
                ", value=" + value +
                '}';
    }
}
