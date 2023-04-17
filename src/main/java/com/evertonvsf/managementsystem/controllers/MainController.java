package com.evertonvsf.managementsystem.controllers;


import com.evertonvsf.managementsystem.models.users.Client;
import com.evertonvsf.managementsystem.models.users.Technician;
import org.apache.commons.validator.routines.EmailValidator;

import com.evertonvsf.managementsystem.controllers.Validations;

import java.io.LineNumberInputStream;
import java.nio.channels.ClosedByInterruptException;
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

    




     // registro de clientes:
    public static boolean createNewClient(String name, String address, String emailAddress, String phoneNumber){
        Client newClient = ClientController.createClient(name, address, emailAddress, phoneNumber);
        return newClient != null;
    }
    public static boolean updateClient(String name, String address, String emailAddress, String phoneNumber, String idString){
        Integer id = Validations.tryParse(idString);
        if (id != null){
            return ClientController.updateClient(name, address, emailAddress, phoneNumber, id);
        }
        return false;
    }

    public static List<Client> getAllClients() {
        return ClientController.getAllClients();
    }

// Gerenciar Ordens de serviço;
// Agenda de atentidmento;
// Gerenciamento de peças e estoque;
// Faturamentp e pagamneto;
// relatórios;



}
