package com.evertonvsf.managementsystem.models.users;

import java.util.ArrayList;
import java.util.List;

public class Technician {
    private int id;
    private String name;
    private String emailAddress;
    private String password;
    private List<Integer> OrdersIds;
    private int actualOrderId;


    public Technician(String name, String password, String emailAddress) {
        this.name = name;
        this.password = password;
        this.emailAddress = emailAddress;
        this.actualOrderId = -1;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setOrdersIds(List<Integer> ordersIds) {
        OrdersIds = ordersIds;
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

    @Override
    public String toString() {
        return "Technician{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", password='" + password + '\'' +
                ", OrdersIds=" + OrdersIds.toString() +
                ", actualOrderId=" + actualOrderId +
                '}';
    }
}
