package com.evertonvsf.managementsystem.models.users;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa um Técnico da assistência técnica
 * 
 * @author Everton Vinícius da Silva Ferreira
 * @version 2.5
 * 
 */
public class Technician implements Serializable {
    private int id;
    private String name;
    private String emailAddress;
    private String password;
    private List<Integer> OrdersIds;
    private int actualOrderId;
/**
 * Construtor da classe <code>Technician</code>.
 *
 * @param name Nome do <code>Technician</code>.
 * @param password Senha do <code>Technician</code>.
 * @param emailAddress Email do <code>Technician</code>;
 */
    public Technician(String name, String password, String emailAddress) {
        this.name = name;
        this.password = password;
        this.emailAddress = emailAddress;
        this.actualOrderId = -1;
        this.OrdersIds = new ArrayList<Integer>();
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setOrdersIds(List<Integer> ordersIds) {
        this.OrdersIds = ordersIds;
    }


    public int getActualOrderId() {
        return actualOrderId;
    }

    public void setActualOrderId(int actualOrderId) {
        this.actualOrderId = actualOrderId;
    }

    public List<Integer> getOrdersIds() {
        return OrdersIds;
    }

    public void setOrdersIds(int orderId) {
        if (this.OrdersIds == null){
            this.OrdersIds = new ArrayList<Integer>();
        }
        this.OrdersIds.add(orderId);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * Gera uma <code>String</code> contendo as informações mais importantes do <code>Technician</code>.
     *
     * @return informações do <code>Technician</code>;
     */
    @Override
    public String toString() {
        return "Technician{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", OrdersIds=" + OrdersIds.toString() +
                ", actualOrderId=" + actualOrderId +
                '}';
    }
}
