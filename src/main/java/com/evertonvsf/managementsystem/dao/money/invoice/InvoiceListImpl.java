package com.evertonvsf.managementsystem.dao.money.invoice;

import com.evertonvsf.managementsystem.models.money.Invoice;

import java.util.ArrayList;
import java.util.List;

public class InvoiceListImpl implements InvoiceCRUD{
    private int newId;
    private List<Invoice> invoices;

    public InvoiceListImpl() {
        this.newId = 0;
        this.invoices = new ArrayList<Invoice>();
    }

    @Override
    public Invoice create(Invoice invoice) {
        invoice.setId(this.newId);
        this.newId++;
        this.invoices.add(invoice);
        return invoice;
    }

    @Override
    public List<Invoice> findMany() {
        return new ArrayList<Invoice>(this.invoices);
    }

    @Override
    public boolean update(Invoice invoice) {
        for (int index = 0; index < this.invoices.size(); index++){
            if (this.invoices.get(index).getId() == invoice.getId()){
                this.invoices.add(index, invoice);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteMany() {
        if (this.invoices.size() > 0){
            this.invoices = new ArrayList<Invoice>();
            this.newId = 0;
            return true;
        }
        return false;
    }

    @Override
    public Invoice findById(int id) {
        for (Invoice invoice : this.invoices){
            if (invoice.getId() == id){
                return invoice;
            }
        }
        return null;
    }

    @Override
    public Invoice findByOrder(int orderId) {
        for (Invoice invoice : this.invoices){
            if (invoice.getServiceOrderId() == orderId){
                return invoice;
            }
        }
        return null;
    }

    @Override
    public List<Invoice> findByValue(double value) {
        List<Invoice> sameValueInvoices = new ArrayList<Invoice>();
        for (Invoice invoice : this.invoices){
            if (invoice.getTotalValue() == value){
                sameValueInvoices.add(invoice);
            }
        }
        return sameValueInvoices;
    }

    @Override
    public boolean deleteById(int id) {
        for (int index = 0; index < this.invoices.size(); index++){
            if (this.invoices.get(index).getId() == id){
                this.invoices.remove(index);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteByOrder(int orderId) {
        for (int index = 0; index < this.invoices.size(); index++){
            if (this.invoices.get(index).getId() == orderId){
                this.invoices.remove(index);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteByValue(double value) {
        List<Invoice> sameValueInvoices = this.findByValue(value);
        if (sameValueInvoices.size() > 0){
            this.invoices.removeAll(sameValueInvoices);
            return true;
        }
        return false;
    }
}
