package com.evertonvsf.managementsystem.dao.persistence;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public abstract class Persistence<Generic>{
    private final String fileName = "file.byte";

    public List<Generic> loadFiles() {
        List<Generic> files;
        try {
            ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(fileName));
            files = (List<Generic>) objectInput.readObject();
            objectInput.close();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<Generic>();
        }
        return files;
    }


    public boolean writeFiles(List<Generic> files) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName));
            outputStream.writeObject(files);
            outputStream.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}
