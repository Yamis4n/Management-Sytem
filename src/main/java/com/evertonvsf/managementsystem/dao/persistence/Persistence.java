package com.evertonvsf.managementsystem.dao.persistence;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public abstract class Persistence<Generic>{

    public List<Generic> loadFiles(String fileName) {
        List<Generic> files;
        try {
            ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(fileName));
            files = (List<Generic>) objectInput.readObject();
            objectInput.close();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
        return files;
    }


    public void writeFiles(List<Generic> files, String fileName) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName));
            outputStream.writeObject(files);
            outputStream.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
