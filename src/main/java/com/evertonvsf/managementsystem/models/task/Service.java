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
    private int id, rating, invoiceId;
    private ServiceCategory category;
    private Integer componentId;
    private Status status;
    private Date beginningTime;
    long timeToConclude;
    private Double price;

    /**
     * Construtor da classe <code>Service</code>
     *
     */
    public Service(ServiceCategory serviceCategory) {
        this.category = serviceCategory;
        this.status = Status.WAITING;
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
 */
    public void setCategory(ServiceCategory serviceCategory) {
        this.category = serviceCategory;

    }

    public String getStatus() {
        return status.getStatusName();
    }
/**
 * Define o status do <code>Service</code> com base na enumeração presente em <code>Status</code>.
 *
 */
    public void setStatus(Status status) {
        this.status = status;
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

    public Double getPrice() {
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
                ", invoiceId=" + invoiceId +
                ", category=" + category.getServiceName() +
                ", status=" + status.getStatusName() +
                ", beginningTime=" + beginningTime.toString() +
                ", timeToConclude=" + timeToConclude +
                ", price=" + price +
                '}';
    }

    public Integer getComponentId() {
        return componentId;
    }

    public void setComponentId(Integer componentId) {
        this.componentId = componentId;
    }
}
