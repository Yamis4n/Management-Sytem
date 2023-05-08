package com.evertonvsf.managementsystem.dao.crud.users.technician;

import com.evertonvsf.managementsystem.dao.persistence.users.technician.TechnicianPersistence;
import com.evertonvsf.managementsystem.models.users.Technician;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TechnicianListImpl implements TechnicianCRUD{
    private static final TechnicianPersistence persistence = new TechnicianPersistence();
    private List<Technician> technicians;
    private int newId;

    public TechnicianListImpl() {
        this.technicians = persistence.loadFiles(persistence.fileName);
        newId = -1;
        for (Technician technician : technicians) {
            if (technician.getId() > newId) {
                newId = technician.getId();
            }
        }
        this.newId = newId + 1;
    }
    @Override
    public void writePersistence(){
        persistence.writeFiles(this.technicians, persistence.fileName);
    }
    @Override
    public Technician create(Technician technician) {
        technician.setId(this.newId);
        this.newId++;
        this.technicians.add(technician);
        return technician;
    }

    @Override
    public List<Technician> findMany() {
        return new ArrayList<Technician>(this.technicians);
    }

    @Override
    public boolean update(Technician technician) {
        for (int index = 0; index < this.technicians.size(); index++){
            if (this.technicians.get(index).getId() == technician.getId()){
                this.technicians.set(index, technician);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteMany() {
        this.newId = 0;
        if (this.technicians.size() > 0) {
            this.technicians = new ArrayList<Technician>();
            return true;
        }
        return false;
    }

    @Override
    public List<Technician> findByName(String name) {
        List<Technician> sameNameTechnicians = new ArrayList<Technician>();
        for (Technician technician : this.technicians){
            if (Objects.equals(technician.getName(), name)){
                sameNameTechnicians.add(technician);
            }
        }
        return sameNameTechnicians;
    }

    @Override
    public Technician findById(int id) {
        for (Technician technician: this.technicians){
            if (technician.getId() == id){
                return technician;
            }
        }
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        for (int index = 0; index < this.technicians.size(); index++){
            if (this.technicians.get(index).getId() == id){
                this.technicians.remove(index);
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean deleteByName(String name) {
        List<Technician> sameNameTechnicians = findByName(name);
        if (sameNameTechnicians.size() > 0){
            this.technicians.removeAll(sameNameTechnicians);
            return true;
        }
        return false;
    }
}
