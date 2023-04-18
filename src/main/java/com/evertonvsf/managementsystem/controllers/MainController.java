package com.evertonvsf.managementsystem.controllers;


import com.evertonvsf.managementsystem.models.users.Client;
import com.evertonvsf.managementsystem.models.users.Technician;
import org.apache.commons.validator.routines.EmailValidator;

import com.evertonvsf.managementsystem.controllers.Validations;

import java.io.LineNumberInputStream;
import java.nio.channels.ClosedByInterruptException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainController {

    private static Technician loggedTechnician = null;
    public static boolean technicianLogin(String stringId, String password) {
        Integer id = Validations.tryParse(stringId);
        if (id != null) {
            Technician toLoginTech = TechnicianController.getTechnicianById(id);
            if (Objects.equals(toLoginTech.getPassword(), password)){
                loggedTechnician = toLoginTech;
                return true;
            }
        }
        return false;
    }
    public static boolean technicianLogout(){
        if (loggedTechnician != null){
            loggedTechnician = null;
            return true;
        }
        return false;
    }

    public static boolean deleteTechnician(String stringId){
        Integer id = Validations.tryParse(stringId);
        if (id != null && loggedTechnician != null && loggedTechnician.getId() != id){ // quero que esteja logado mas que não seja o tecnico a ser apagado
            return TechnicianController.deleteTechnicianById(id);
        }
        return false;
    }

    public static boolean createNewTechnician(String name, String password){

        Technician newTechnician = TechnicianController.createTechnician(name, password);
        return newTechnician != null;
    }

    public static boolean updateATechnician(String name, String password, String stringId){
        if (loggedTechnician != null) {
            Integer id = Validations.tryParse(stringId);
            if (id != null) {
                return TechnicianController.updateTechnician(name, password, id);
            }
        }
        return false;
    }

    public static boolean removeAllTechnicians(){
        return TechnicianController.deleteAllTechnicians();
    }

    public static List<String> getAllTechnicians(){
        List<Technician> technicians =  TechnicianController.getAllTechnicians();
        List<String> techniciansInString = new ArrayList<String>();
        for (Technician technician : technicians){
            techniciansInString.add(technician.toString());
        }
        return techniciansInString;
    }
 // --------------------------------- aqui acabam as funções relacionadas ao tecnico ----------------------------

// ---------------------------------- aqui começam as funções relacionadas ao cliente ---------------------------
    public static boolean createNewClient(String name, String address, String emailAddress, String phoneNumber) {
        if (loggedTechnician != null) {
            Client newClient = ClientController.createClient(name, address, emailAddress, phoneNumber);
            return newClient != null;
        }
        return false;
    }

    public static boolean updateClient(String name, String address, String emailAddress, String phoneNumber, String idString){
        if (loggedTechnician != null) {
            Integer id = Validations.tryParse(idString);
            if (id != null) {
                return ClientController.updateClient(name, address, emailAddress, phoneNumber, id);
            }
        }
        return false;
    }

    public static List<String> getAllClients() {
        List<Client> clientsModels = ClientController.getAllClients();
        List<String> clients = new ArrayList<String>();
        for (Client client : clientsModels){
            clients.add(client.toString());
        }
        return clients;
    }

    public static boolean removeAllClients(){
        return ClientController.deleteAllClients();
    }


    public static boolean deleteClientById(String stringId){
        if (loggedTechnician != null) {
            Integer id = Validations.tryParse(stringId);
            return ClientController.deleteClientById(id);
        }
        return false;
    }
// ------------------------------------ Aqui acabam as funções relacionadas aos clientes -----------------

//

// Agenda de atentidmento;
// Gerenciamento de peças e estoque;
// Faturamentp e pagamneto;
// relatórios;



}
