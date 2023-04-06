package com.evertonvsf.managementsystem.models.task;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ServiceOrder {
    private int id, clientId, technicianId, invoiceId;
    private Date beginningTime, conclusionTime;
    private String status; // change for enum;

    public ServiceOrder(int clientId, int technicianId) {
        this.clientId = clientId;
        this.technicianId = technicianId;
        this.beginningTime = new Date();
        this.status = "WAITING";
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

    public Date getConclusionTime() {
        return conclusionTime;
    }

    public void setConclusionTime() {
        this.conclusionTime = new Date();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
