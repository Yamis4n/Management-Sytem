package com.evertonvsf.managementsystem.models.task;

import java.util.Date;

public class Service {
    private int id, rating, necessaryComponentId, invoiceId;
    private String necessaryComponentName; // only used if componentId == 6;
    private ServiceCategory category;
    private ServiceStatus status;
    private Date beginningTime;
    long timeToConclude;
    private double value;

    public Service(int category, double value) {
        this.setCategory(category);
        this.setStatus(0);
        this.beginningTime = new Date();
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getNecessaryComponentId() {
        return necessaryComponentId;
    }

    public void setNecessaryComponentId(int necessaryComponentId) {
        this.necessaryComponentId = necessaryComponentId;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getNecessaryComponentName() {
        return necessaryComponentName;
    }

    public void setNecessaryComponentName(String necessaryComponentName) {
        this.necessaryComponentName = necessaryComponentName;
    }

    public String getCategory() {
        return category.getServiceName();
    }

    public void setCategory(int category) {
        switch (category){
            case 0 -> this.category = ServiceCategory.MOUNTING;
            case 1 -> this.category = ServiceCategory.FORMATTING_INSTALLATION;
            default -> this.category = ServiceCategory.CLEANING;
        }
    }

    public String getStatus() {
        return status.getStatus();
    }

    public void setStatus(int status) {
        if (status == 0) {
            this.status = ServiceStatus.INITIALIZED;
        } else {
            this.status = ServiceStatus.FINISHED;
        }
    }

    public Date getBeginning() {
        return beginningTime;
    }

    public void setBeginning(Date beginning) {
        this.beginningTime = beginning;
    }

    public long getTimeToConclude() {
        return timeToConclude;
    }

    public void setTimeToConcludeConclusion() {
        Date finished = new Date();
        this.timeToConclude = (finished.getTime() - this.beginningTime.getTime()) / 60000;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
