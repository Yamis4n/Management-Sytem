package com.evertonvsf.managementsystem.dao.crud.task.serviceorder;

import com.evertonvsf.managementsystem.dao.persistence.task.serviceorder.ServiceOrderPersistence;
import com.evertonvsf.managementsystem.models.money.Payment;
import com.evertonvsf.managementsystem.models.task.ServiceOrder;
import com.evertonvsf.managementsystem.models.task.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ServiceOrderListImpl implements ServiceOrderCRUD{
    private static final ServiceOrderPersistence persistence = new ServiceOrderPersistence();
    private List<ServiceOrder> serviceOrders;
    private int newId;

    public ServiceOrderListImpl() {
        this.loadPersistence();
    }
    @Override
    public void writePersistence(){
        persistence.writeFiles(this.serviceOrders, persistence.fileName);
    }

    @Override
    public void loadPersistence (){
        this.serviceOrders = persistence.loadFiles(persistence.fileName);
        int newId = -1;
        for (ServiceOrder serviceOrder : serviceOrders){
            if (serviceOrder.getId() > newId){
                newId = serviceOrder.getId();
            }
        }
        this.newId = newId +1;
    }
    @Override
    public ServiceOrder create(ServiceOrder serviceOrder) {
        serviceOrder.setId(newId);
        newId++;
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
                this.serviceOrders.remove(index);
                this.serviceOrders.add(serviceOrder);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteMany() {
        newId = 0;
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
    public List<ServiceOrder> findByClient(String clientCPF) {
        List<ServiceOrder> sameClientServiceOrders = new ArrayList<ServiceOrder>();
        for (ServiceOrder serviceOrder : this.serviceOrders){
            if (serviceOrder.getClientCPF() == clientCPF){
                sameClientServiceOrders.add(serviceOrder);
            }
        }
        return sameClientServiceOrders;
    }

    @Override
    public List<ServiceOrder> findByTechnician(String techUsername) {
        List<ServiceOrder> sameTechnicianServiceOrders = new ArrayList<ServiceOrder>();
        for (ServiceOrder serviceOrder : this.serviceOrders){
            if (Objects.equals(serviceOrder.getTechnicianUsername(), techUsername)){
                sameTechnicianServiceOrders.add(serviceOrder);
            }
        }
        return sameTechnicianServiceOrders;
    }


    @Override
    public List<ServiceOrder> findByStatus(Status orderStatus) {
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
    @Override
    public Integer getNewID(){
        return this.newId;
    }
}
