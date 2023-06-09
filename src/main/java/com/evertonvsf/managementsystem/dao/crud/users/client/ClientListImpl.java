package com.evertonvsf.managementsystem.dao.crud.users.client;

import com.evertonvsf.managementsystem.dao.persistence.users.client.ClientPersistence;
import com.evertonvsf.managementsystem.models.users.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ClientListImpl implements ClientCRUD{
    private static final ClientPersistence persistence = new ClientPersistence();
    private List<Client> clients;
    private int newId;
    public ClientListImpl(){
        this.loadPersistence();
    }

    @Override
    public void writePersistence(){
        persistence.writeFiles(this.clients, persistence.fileName);
    }
    @Override
    public void loadPersistence() {
        this.clients = persistence.loadFiles(persistence.fileName);
        int newId = -1;
        for (Client client : clients){
            if (client.getId() > newId){
                newId = client.getId();
            }
        }
        this.newId = newId+1;
    }
    @Override
    public Client create(Client client) {
        client.setId(this.newId);
        this.newId++;
        this.clients.add(client);
        return client;
    }

    @Override
    public List<Client> findMany() {
        return new ArrayList<Client>(this.clients);
    }

    @Override
    public boolean update(Client client) {
        for (int index = 0; index < this.clients.size(); index++){
            if (this.clients.get(index).getId() == client.getId()){
                this.clients.set(index, client);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteMany() {
        this.newId = 0;
        if (this.clients.size() > 0) {
            this.clients = new ArrayList<Client>();
            return true;
        }
        return false;
    }

    @Override
    public List<Client> findByName(String name) {
        List<Client> sameNameClients = new ArrayList<Client>();
        for (Client client : this.clients){
            if (Objects.equals(client.getName(), name)){
                sameNameClients.add(client);
            }
        }
        return sameNameClients;
    }

    @Override
    public Client findById(int id) {
        for (Client client : this.clients){
            if (client.getId() == id){
                return client;
            }
        }
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        for (int index = 0; index < this.clients.size(); index++){
            if (this.clients.get(index).getId() == id){
                this.clients.remove(index);
                return true;
            }
        }
        return false;
    }


}
