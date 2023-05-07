package com.evertonvsf.managementsystem.dao.persistence.users;

import com.evertonvsf.managementsystem.dao.persistence.Persistence;
import com.evertonvsf.managementsystem.models.users.Client;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;


public class ClientPersistence implements Persistence<Client> {
    @Override
    public List<Client> loadFiles() {
        try{
            ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream())
        }
    }

    @Override
    public boolean writeFiles(List<Client> files) {
        return false;
    }
}
