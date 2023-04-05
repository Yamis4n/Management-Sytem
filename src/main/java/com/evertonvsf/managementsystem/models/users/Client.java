package com.evertonvsf.managementsystem.models.users;

public class Client {
    String name;
    int id;
    String address;
    String emailAddress;
    String phoneNumber;

    public Client(String address, String emailAddress, String phoneNumber){
        this.name = "";
        this.address = address;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;

    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String toString(){
    return "nome: " + this.getName() + "\nEndereço: " + this.getAddress() +
        "\nEmail: " + this.getEmailAddress() + "\nnumero: " + this.getPhoneNumber();
    }
}
