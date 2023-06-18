package com.evertonvsf.managementsystem.models.task;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Representa uma Ordem de serviço da Assistência Técnica
 * Ela possui um status representado pela classe <code>Status</code>
 * @author Everton Vinícius da Silva Ferreira
 * @version 2.5
 *
 * @see <code>Status</code>
 */
public class ServiceOrder implements Serializable {
    private int id;
    private String clientCPF;
    private String technicianUsername;
    private int invoiceId;
    private List<Integer> servicesIds;
    private Date beginningTime;
    private long timeToConclude;
    private Status status;
    private Boolean payed;
    /**
     * Construtor da classe <code>ServiceOrder</code>
     *
     * @param clientCPF indica o id do <code>Client</code>
     * @param servicesIds indica uma lista de id's dos serviços prestados nesta <code>ServiceOrder</code>
     */
    public ServiceOrder(String clientCPF , List<Integer> servicesIds) {
        this.clientCPF = clientCPF;
        this.technicianUsername = "-----";
        this.servicesIds = servicesIds;
        this.beginningTime = new Date();
        this.payed = false;
        this.status = Status.WAITING;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getClientCPF() {
        return clientCPF;
    }

    public void setClientCPF(String clientCPF) {
        this.clientCPF = clientCPF;
    }

    public String getTechnicianUsername() {
        return technicianUsername;
    }

    public void setTechnicianUsername(String technicianUsername) {
        this.technicianUsername = technicianUsername;
    }

    public Status getStatus() {
        return status;
    }
   /**
    * Define o status da <code>ServiceOrder</code> com base na enumeração presente em <code>Status</code>.
    *
    *
    * @see <code>Status</code>
    */ 
    public void setStatus(Status status) {
        this.status = status;

    }

    public List<Integer> getServicesIds() {
        return servicesIds;
    }

    public void setServicesIds(List<Integer> servicesIds) {
        this.servicesIds = servicesIds;
    }

    /**
     * Gera uma <code>String</code> contendo as informações da <code>ServiceOrder</code>.
     *
     * @return Informações da <code>ServiceOrder</code>;
     */
    @Override
    public String toString() {
        return "ServiceOrder{" +
                "id=" + id +
                ", clientId=" + clientCPF +
                ", technicianId=" + technicianUsername +
                ", invoiceId=" + invoiceId +
                ", servicesIds=" + servicesIds.toString() +
                ", beginningTime=" + beginningTime.toString() +
                ", timeToConclude=" + timeToConclude +
                ", status=" + status.getStatusName() +
                '}';
    }

    public Boolean getPayed() {
        return payed;
    }

    public void setPayed(Boolean payed) {
        this.payed = payed;
    }
}
