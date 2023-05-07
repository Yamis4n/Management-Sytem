package com.evertonvsf.managementsystem.dao.CRUD.money.payment;

import com.evertonvsf.managementsystem.dao.CRUD.CRUD;
import com.evertonvsf.managementsystem.models.money.Payment;

import java.util.List;

public interface PaymentCRUD extends CRUD<Payment> {
    public List<Payment> findByInvoice(int invoiceId);
    public List<Payment> findByPaymentMethod(String paymentMethod);
    public List<Payment> findByValue(double value);
    public boolean deleteByInvoice(int invoiceId);

}
