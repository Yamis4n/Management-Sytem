package com.evertonvsf.managementsystem.dao.crud.stock.component;

import com.evertonvsf.managementsystem.dao.persistence.stock.componentstock.ComponentPersistence;
import com.evertonvsf.managementsystem.models.stock.Component;
import com.evertonvsf.managementsystem.models.stock.ComponentStock;

import java.util.ArrayList;
import java.util.List;

public class ComponentListImpl implements ComponentCRUD{
    private static final ComponentPersistence persistence = new ComponentPersistence();
    private List<ComponentStock> components;

    private int newId;

    public ComponentListImpl() {
        this.loadPersistence();
    }

    @Override
    public ComponentStock create(ComponentStock component) {
        component.setId(this.newId);
        this.components.add(component);
        this.newId++;
        this.writePersistence();
        return component;

    }
    @Override
    public void writePersistence(){
        persistence.writeFiles(this.components, persistence.fileName);
    }

    @Override
    public void loadPersistence(){
        this.components = persistence.loadFiles(persistence.fileName);
        this.newId = -1;
        for (ComponentStock componentStock : this.components){
            if (componentStock.getId() > this.newId){
                this.newId = componentStock.getId();
            }
        }
        this.newId++;

    }

    @Override
    public List<ComponentStock> findMany() {
        return new ArrayList<ComponentStock>(this.components);
    }

    @Override
    public boolean update(ComponentStock component) {
        for (int index =0; index < this.components.size(); index++){
            if (this.components.get(index).getId() == component.getId()){
                this.components.remove(index);
                this.components.add(component);
                return true;
            }
        }
        return false;
    }

    @Override
    public ComponentStock findById(int id) {
        for (ComponentStock component : this.components){
            if (component.getId() == id){
                return component;
            }
        }
        return null;
    }


    @Override
    public boolean deleteById(int id) {
        for (int index = 0; index < this.components.size(); index++){
            if (this.components.get(index).getId() == id){
                this.components.remove(index);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteMany() {
        if (this.components.size() > 0){
            this.components = new ArrayList<ComponentStock>();
            return true;
        }
        return false;
    }

    @Override
    public ComponentStock findByComponent(Component component) {
        for (ComponentStock componentStock : this.components){
            if (componentStock.getComponent().equals(component)){
                return componentStock;
            }
        }
        return null;
    }
}
