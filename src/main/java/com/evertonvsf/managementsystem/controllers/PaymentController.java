package com.evertonvsf.managementsystem.controllers;

import com.evertonvsf.managementsystem.dao.DAO;
import com.evertonvsf.managementsystem.models.money.Payment;

import java.util.List;

public class PaymentController {
    public static Payment createPayment(int invoiceId, int paymentMethod, double value){
        if (invoiceId >= 0 && value > 0 && paymentMethod >= 0 && paymentMethod <= 4) {
            return DAO.getPaymentDAO().create(new Payment(invoiceId, paymentMethod, value));
        }
        return null;
    }

    public static boolean updatePayment(int id, int invoiceId, int paymentMethod, double value) {
        if (id >= 0 && invoiceId >= 0 && value > 0 && paymentMethod >= 0 && paymentMethod <= 4) {
            Payment updatedPayment = new Payment(invoiceId, paymentMethod, value);
            updatedPayment.setId(id);
            return DAO.getPaymentDAO().update(updatedPayment);
        }
        return false;
    }

    public static Payment getPaymentById(int id){
        if (id >= 0){
            return DAO.getPaymentDAO().findById(id);
        }
        return null;
    }

    public static List<Payment> getAllPayments(){
        return DAO.getPaymentDAO().findMany();
    }

    /*public static boolean deletePaymentById(int id){
        if (id >=0){
            return DAO.getPaymentDAO()
        }
    }*/




















}
