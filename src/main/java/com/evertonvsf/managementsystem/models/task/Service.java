package com.evertonvsf.managementsystem.models.task;

import java.io.Serializable;
import java.util.Date;

/**
 * Representa um serviço da assistência técnica
 * ele possui uma categoria representada pela classe <code>ServiceCategory</code>
 * e um status representado pela classe <code>Status</code>.
 * 
 * @author Everton Vinícius da Silva Ferreira
 * @version 2.5
 *
 * @see <code>ServiceCategory</code>
 * @see <code>Status</code>
 */
public class Service implements Serializable {
    private int id, rating, necessaryComponentId, invoiceId;
    private ServiceCategory category;
    private Status status;
    private Date beginningTime;
    long timeToConclude;
    private double price;

    /**
     * Construtor da classe <code>Service</code>
     *
     * @param category Numero indicando qual categoria o serviço pertence;
     */
    public Service(int category) {
        this.setCategory(category);
        this.setStatus(0);
        this.beginningTime = new Date();
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

    public void setNecessaryComponentId() {
        this.necessaryComponentId = this.category.getComponentId();
    }
    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getCategory() {
        return category.getServiceName();
    }
/**
 * Define a categoria do <code>Servce</code> com base na enumeração presente em <code>ServiceCategory</code>.
 *
 * @param category Número indicando qual categoria o <code>Service</code> pertence;
 */
    public void setCategory(int category) {
        switch (category){
            case 0 -> this.category = ServiceCategory.MOUNTING_RAM;
            case 1 -> this.category = ServiceCategory.MOUNTING_MOTHERBOARD;
            case 2 -> this.category = ServiceCategory.MOUNTING_POWER_SUPPLY;
            case 3 -> this.category = ServiceCategory.MOUNTING_VIDEO_CARD;
            case 4 -> this.category = ServiceCategory.MOUNTING_HD_SSD;
            case 5 -> this.category = ServiceCategory.FORMATTING_INSTALLATION_PROGRAMS;
            case 6 -> this.category = ServiceCategory.FORMATTING_INSTALLATION_OS;
            default -> this.category = ServiceCategory.CLEANING;
        }
    }

    public String getStatus() {
        return status.getStatusName();
    }
/**
 * Define o status do <code>Service</code> com base na enumeração presente em <code>Status</code>.
 *
 * @param statusId Número indicando qual o <code>Status</code> do <code>Service</code>.
 */
    public void setStatus(int statusId) {
        switch (statusId){
            case 0 -> this.status = Status.WAITING;
            case 1 -> this.status = Status.INITIALIZED;
            case 2 -> this.status = Status.FINISHED;
            case 3 -> this.status = Status.CANCELED;
            default -> this.status = Status.PAID;
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

    public double getPrice() {
        return price;
    }

    public void setPrice() {
        this.price = this.category.getPrice();
    }
/**
 * Gera uma <code>String</code> contendo as informações do <code>Service</code>.
 *
 * @return Informações do <code>Service</code>;
 */
    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", rating=" + rating +
                ", necessaryComponentId=" + necessaryComponentId +
                ", invoiceId=" + invoiceId +
                ", category=" + category.getServiceName() +
                ", status=" + status.getStatusName() +
                ", beginningTime=" + beginningTime.toString() +
                ", timeToConclude=" + timeToConclude +
                ", price=" + price +
                '}';
    }
}
