package com.evertonvsf.managementsystem.dao.users.client;

import com.evertonvsf.managementsystem.dao.CRUD;
import com.evertonvsf.managementsystem.models.users.Client;

import java.util.List;

public interface ClientCRUD extends CRUD<Client> {
    public List<Client> findByName(String name);
    public Client findById(int id);
    public boolean deleteById(int id);
    public boolean deleteByName(String name);
}
