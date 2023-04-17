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

    Technician loggedTechnician = null;
    public boolean technicianLogin(String stringId, String password) {
        Integer id = Validations.tryParse(stringId);
        if (id != null) {
            Technician toLoginTech = TechnicianController.getById(id);
            if (Objects.equals(toLoginTech.getPassword(), password)){
                loggedTechnician = toLoginTech;
                return true;
            }
        }
        return false;
    }


     // registro de clientes:
    public boolean createNewClient(String name, String address, String emailAddress, String phoneNumber){
        Client newClient = ClientController.createClient(name, address, emailAddress, phoneNumber);
        return newClient != null;
    }
    public boolean updateClient(String name, String address, String emailAddress, String phoneNumber, String idString){
        Integer id = Validations.tryParse(idString);
        if (id != null){
            return ClientController.updateClient(name, address, emailAddress, phoneNumber, id);
        }
        return false;
    }

    public List<Client> getAllClients(){
        return ClientController.getAllClients();
    }
    public

// Gerenciar Ordens de serviço;
// Agenda de atentidmento;
// Gerenciamento de peças e estoque;
// Faturamentp e pagamneto;
// relatórios;



}
