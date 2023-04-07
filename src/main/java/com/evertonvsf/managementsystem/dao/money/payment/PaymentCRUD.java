package com.evertonvsf.managementsystem.dao.money.payment;

import com.evertonvsf.managementsystem.dao.CRUD;
import com.evertonvsf.managementsystem.models.money.Payment;

import java.util.List;

public interface PaymentCRUD extends CRUD<Payment> {
    public List<Payment> findByInvoice(int invoiceId);
    public List<Payment> findByPaymentMethod(String paymentMethod);
    public List<Payment> findByValue(double value);
}   
