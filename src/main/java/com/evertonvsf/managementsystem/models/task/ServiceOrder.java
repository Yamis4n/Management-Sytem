package com.evertonvsf.managementsystem.models.task;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.Inflater;

public class ServiceOrder {
    private int id, clientId, technicianId, invoiceId;
    private List<Integer> servicesIds;
    private Date beginningTime;
    private long timeToConclude;
    private Status status;

    public ServiceOrder(int clientId, int technicianId, List<Integer> servicesIds) {
        this.clientId = clientId;
        this.technicianId = technicianId;
        this.servicesIds = servicesIds;
        this.beginningTime = new Date();
        this.setStatus(0);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getTechnicianId() {
        return technicianId;
    }

    public void setTechnicianId(int technicianId) {
        this.technicianId = technicianId;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Date getBeginningTime() {
        return beginningTime;
    }

    public void setBeginningTime() {
        this.beginningTime = new Date();
    }

    public long getTimeToConclude() {
        return timeToConclude;
    }

    public void setTimeToConclude() {
        Date finished = new Date();
        this.timeToConclude = (finished.getTime() - this.beginningTime.getTime()) / 60000;
    }

    public String getStatus() {
        return status.getStatusName();
    }

    public void setStatus(int statusId) {
        switch (statusId){
            case 0 -> this.status = Status.WAITING;
            case 1 -> this.status = Status.INITIALIZED;
            case 2 -> this.status = Status.FINISHED;
            case 3 -> this.status = Status.CANCELED;
            default -> this.status = Status.PAID;
        }
    }

    public List<Integer> getServicesIds() {
        return servicesIds;
    }

    public void setServicesIds(List<Integer> servicesIds) {
        this.servicesIds = servicesIds;
    }

    @Override
    public String toString() {
        return "ServiceOrder{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", technicianId=" + technicianId +
                ", invoiceId=" + invoiceId +
                ", servicesIds=" + servicesIds.toString() +
                ", beginningTime=" + beginningTime.toString() +
                ", timeToConclude=" + timeToConclude +
                ", status=" + status.getStatusName() +
                '}';
    }
}
