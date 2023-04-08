package com.evertonvsf.managementsystem.models.task;

import java.util.Date;

public class ServiceOrder {
    private int id, clientId, technicianId, invoiceId;
    private Date beginningTime;
    long timeToConclude;
    private ServiceOrderStatus status;

    public ServiceOrder(int clientId, int technicianId) {
        this.clientId = clientId;
        this.technicianId = technicianId;
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
            case 0 -> this.status = ServiceOrderStatus.WAITING;
            case 1 -> this.status = ServiceOrderStatus.INITIALIZED;
            case 2 -> this.status = ServiceOrderStatus.FINISHED;
            case 3 -> this.status = ServiceOrderStatus.CANCELED;
            default -> this.status = ServiceOrderStatus.PAID;
        }
    }
}
