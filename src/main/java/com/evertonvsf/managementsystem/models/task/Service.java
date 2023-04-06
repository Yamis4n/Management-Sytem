package com.evertonvsf.managementsystem.models.task;

import java.util.Date;

public class Service {
    private int id, rating, necessaryComponentId, invoiceId;
    private String necessaryComponentName; // only used if componentId == 6;
    private String category; // change for an enum;
    private String status; // change for an enum;
    private Date beginning, conclusion;
    private double value;

    public Service(String category, Date beginning, double value) {
        this.category = category;
        this.status = "WAITING";
        this.beginning = beginning;
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
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getBeginning() {
        return beginning;
    }

    public void setBeginning(Date beginning) {
        this.beginning = beginning;
    }

    public Date getConclusion() {
        return conclusion;
    }

    public void setConclusion(Date conclusion) {
        this.conclusion = conclusion;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
