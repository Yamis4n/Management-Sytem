package com.evertonvsf.managementsystem.dao.task.serviceorder;

import com.evertonvsf.managementsystem.dao.CRUD;
import com.evertonvsf.managementsystem.models.task.ServiceOrder;

import java.util.List;

public interface ServiceOrderCRUD extends CRUD<ServiceOrder> {
    public ServiceOrder findById(int id);
    public ServiceOrder findByInvoice(int invoiceId);
    public List<ServiceOrder> findByClient(int clientId);
    public List<ServiceOrder> findByTechnician(int technicianId);
    public List<ServiceOrder> findByStatus(String orderStatus);
    public boolean deleteById(int id);
    public boolean deleteByInvoice(int invoiceId);
    public boolean deleteByClient(int clientId);
    public boolean deleteByTechnician(int technicianId);
    public boolean deleteByStatus(String orderStatus);


}

