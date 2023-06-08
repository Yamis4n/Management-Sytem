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
    private String username;
    private String password;
    private List<Integer> OrdersIds;
    private int actualOrderId;
/**
 * Construtor da classe <code>Technician</code>.
 *
 * @param name Nome do <code>Technician</code>.
 * @param password Senha do <code>Technician</code>.
 * @param username Email do <code>Technician</code>;
 */
    public Technician(String name, String password, String username) {
        this.name = name;
        this.password = password;
        this.username = username;
        this.actualOrderId = -1;
        this.OrdersIds = new ArrayList<Integer>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
                ", emailAddress='" + username + '\'' +
                ", OrdersIds=" + OrdersIds.toString() +
                ", actualOrderId=" + actualOrderId +
                '}';
    }
}
