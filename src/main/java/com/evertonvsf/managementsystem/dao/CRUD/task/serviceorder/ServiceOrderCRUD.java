package com.evertonvsf.managementsystem.dao.CRUD.task.serviceorder;

import com.evertonvsf.managementsystem.dao.CRUD.CRUD;
import com.evertonvsf.managementsystem.models.task.ServiceOrder;

import java.util.List;

public interface ServiceOrderCRUD extends CRUD<ServiceOrder> {
    public ServiceOrder findByInvoice(int invoiceId);
    public List<ServiceOrder> findByClient(int clientId);
    public List<ServiceOrder> findByTechnician(int technicianId);
    public List<ServiceOrder> findByStatus(String orderStatus);
    public boolean deleteById(int id);

}

