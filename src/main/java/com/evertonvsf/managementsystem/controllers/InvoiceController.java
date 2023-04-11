package com.evertonvsf.managementsystem.controllers;

import com.evertonvsf.managementsystem.dao.DAO;
import com.evertonvsf.managementsystem.models.money.Invoice;

import java.util.List;

public class InvoiceController {
    public static Invoice createInvoice(int serviceOrderId, double totalPrice){
        if (serviceOrderId >= 0 && totalPrice > 0){
            return DAO.getInvoiceDAO().create(new Invoice(serviceOrderId, totalPrice));
        }
        return null;
    }
    public static boolean updateInvoice(int serviceOrderId, double totalPrice, int invoiceId){
        if (serviceOrderId >= 0 && totalPrice > 0 && invoiceId >= 0){
            Invoice updatedInvoice = new Invoice(serviceOrderId, totalPrice);
            updatedInvoice.setId(invoiceId);
            return DAO.getInvoiceDAO().update(updatedInvoice);
        }
        return false;
    }

    public static Invoice getInvoiceById(int id){
        if (id >= 0){
            return DAO.getInvoiceDAO().findById(id);
        }
        return null;
    }
    public static boolean deleteInvoiceById(int id){
        if (id >= 0){
            return DAO.getInvoiceDAO().deleteById(id);
        }
        return false;
    }
    public static Invoice getInvoiceByOrder(int orderId){
        if (orderId >= 0){
            return DAO.getInvoiceDAO().findByOrder(orderId);
        }
        return null;
    }

    public static boolean deleteInvoiceByOrder(int orderId) {
        if (orderId >= 0) {
            return DAO.getInvoiceDAO().deleteByOrder(orderId);
        }
        return false;
    }

    public static List<Invoice> getAllInvoices(){
        return DAO.getInvoiceDAO().findMany();
    }

    public static boolean deleteAllInvoices(){
        return DAO.getInvoiceDAO().deleteMany();
    }
}
