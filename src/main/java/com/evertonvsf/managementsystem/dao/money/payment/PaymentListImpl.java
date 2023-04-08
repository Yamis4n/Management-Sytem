package com.evertonvsf.managementsystem.dao.money.payment;

import com.evertonvsf.managementsystem.models.money.Payment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PaymentListImpl implements PaymentCRUD {
    private List<Payment> payments;
    private int newId;

    public PaymentListImpl() {
        this.payments = new ArrayList<Payment>();
        this.newId = 0;
    }

    @Override
    public Payment findById(int id) {
        for (Payment payment : this.payments){
            if (payment.getId() == id){
                return payment;
            }
        }
        return null;
    }

    @Override
    public Payment create(Payment payment) {
        payment.setId(this.newId);
        this.newId++;
        this.payments.add(payment);
        return payment;
    }

    @Override
    public List<Payment> findMany() {
        return new ArrayList<Payment>(this.payments);
    }

    @Override
    public boolean update(Payment payment) {
        for (int index = 0; index < this.payments.size(); index++){
            if (this.payments.get(index).getId() == payment.getId()){
                this.payments.add(index, payment);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteMany() {
        this.newId = 0;
        if (this.payments.size()> 0){
            this.payments = new ArrayList<Payment>();
            return true;
        }
        return false;
    }

    @Override
    public List<Payment> findByInvoice(int invoiceId) {
        List<Payment> sameInvoicePayments = new ArrayList<Payment>();
        for (Payment payment : this.payments){
            if (payment.getInvoiceId() == invoiceId){
                sameInvoicePayments.add(payment);
            }
        }
        return sameInvoicePayments;
    }

    @Override
    public List<Payment> findByPaymentMethod(String paymentMethod) {
        List<Payment> sameMethodPayments = new ArrayList<Payment>();
        for (Payment payment : this.payments){
            if (Objects.equals(payment.getPaymentMethod(), paymentMethod)){
                sameMethodPayments.add(payment);
            }
        }
        return sameMethodPayments;
    }

    @Override
    public List<Payment> findByValue(double value) {
        List<Payment> sameValuePayments = new ArrayList<Payment>();
        for (Payment payment : this.payments){
            if (payment.getValue() == value){
                sameValuePayments.add(payment);
            }
        }
        return sameValuePayments;
    }
}
