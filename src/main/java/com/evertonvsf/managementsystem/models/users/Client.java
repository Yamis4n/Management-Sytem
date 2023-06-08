package com.evertonvsf.managementsystem.models.users;

import java.io.Serializable;
/**
 * Representa um cliente da assistência técnica
 * 
 * @author Everton Vinícius da Silva Ferreira
 * @version 2.5
 * 
 */
public class Client implements Serializable {

  private String name;
  private int id;
  private String address;
  private String phoneNumber;
  /**
   * Construtor da classe <code>Client</code>.
   *
   * @param name Nome do cliente. 
   * @param address Endereço de morada do cliente.
   * @param phoneNumber Número de telefone do cliente;
   * */
  public Client(String name, String address, String phoneNumber){
    this.name = name;
    this.address = address;
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

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
  /**
   * Gera uma <code>String</code> contendo as informações do <code>Client</code>
   * 
   * @return informações do <code>Client</code>
   */
  @Override
  public String toString() {
    return "Client{" +
      "name='" + name + '\'' +
      ", id=" + id +
      ", address='" + address + '\'' +
      ", phoneNumber='" + phoneNumber + '\'' +
      '}';
  }
}
