package com.evertonvsf.managementsystem.dao.CRUD.task.serviceorder;

import com.evertonvsf.managementsystem.models.task.ServiceOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ServiceOrderListImpl implements ServiceOrderCRUD{
    private List<ServiceOrder> serviceOrders;
    private int newId;

    public ServiceOrderListImpl() {
        this.serviceOrders = new ArrayList<ServiceOrder>();
        this.newId = 0;
    }

    @Override
    public ServiceOrder create(ServiceOrder serviceOrder) {
        serviceOrder.setId(this.newId);
        this.newId++;
        this.serviceOrders.add(serviceOrder);
        return serviceOrder;
    }

    @Override
    public List<ServiceOrder> findMany() {
        return new ArrayList<ServiceOrder>(this.serviceOrders);
    }

    @Override
    public boolean update(ServiceOrder serviceOrder) {
        for (int index = 0; index<this.serviceOrders.size(); index++){
            if (this.serviceOrders.get(index).getId() == serviceOrder.getId()){
                this.serviceOrders.add(index, serviceOrder);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteMany() {
        this.newId = 0;
        if (this.serviceOrders.size() == 0){
            return false;
        }
        this.serviceOrders = new ArrayList<ServiceOrder>();
        return true;
    }

    @Override
    public ServiceOrder findById(int id) {
        for (ServiceOrder serviceOrder : this.serviceOrders){
            if (serviceOrder.getId() == id){
                return serviceOrder;
            }
        }
        return null;
    }

    @Override
    public ServiceOrder findByInvoice(int invoiceId) {
        for (ServiceOrder serviceOrder : this.serviceOrders){
            if (serviceOrder.getInvoiceId() == invoiceId){
                return serviceOrder;
            }
        }
        return null;
    }

    @Override
    public List<ServiceOrder> findByClient(int clientId) {
        List<ServiceOrder> sameClientServiceOrders = new ArrayList<ServiceOrder>();
        for (ServiceOrder serviceOrder : this.serviceOrders){
            if (serviceOrder.getClientId() == clientId){
                sameClientServiceOrders.add(serviceOrder);
            }
        }
        return sameClientServiceOrders;
    }

    @Override
    public List<ServiceOrder> findByTechnician(int technicianId) {
        List<ServiceOrder> sameTechnicianServiceOrders = new ArrayList<ServiceOrder>();
        for (ServiceOrder serviceOrder : this.serviceOrders){
            if (serviceOrder.getTechnicianId() == technicianId){
                sameTechnicianServiceOrders.add(serviceOrder);
            }
        }
        return sameTechnicianServiceOrders;
    }


    @Override
    public List<ServiceOrder> findByStatus(String orderStatus) {
        List<ServiceOrder> sameStatusServiceOrders = new ArrayList<ServiceOrder>();
        for (ServiceOrder serviceOrder : this.serviceOrders){
            if (Objects.equals(serviceOrder.getStatus(), orderStatus)){
                sameStatusServiceOrders.add(serviceOrder);
            }
        }
        return sameStatusServiceOrders;
    }


    @Override
    public boolean deleteById(int id) {
        for (int index = 0; index<this.serviceOrders.size(); index++){
            if (this.serviceOrders.get(index).getId() == id){
                this.serviceOrders.remove(index);
                return true;
            }
        }
        return false;
    }

}
