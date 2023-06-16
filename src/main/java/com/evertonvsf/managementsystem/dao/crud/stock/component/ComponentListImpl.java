package com.evertonvsf.managementsystem.dao.crud.stock.component;

import com.evertonvsf.managementsystem.dao.persistence.stock.componentstock.ComponentPersistence;
import com.evertonvsf.managementsystem.models.stock.Component;
import com.evertonvsf.managementsystem.models.stock.ComponentType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ComponentListImpl implements ComponentCRUD{
    private static final ComponentPersistence persistence = new ComponentPersistence();
    private List<Component> components;

    private int newId;

    public ComponentListImpl() {
        this.loadPersistence();
    }

    @Override
    public Component create(Component component) {
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
        for (Component componentStock : this.components){
            if (componentStock.getId() > this.newId){
                this.newId = componentStock.getId();
            }
        }
        this.newId++;

    }

    @Override
    public List<Component> findMany() {
        return new ArrayList<Component>(this.components);
    }

    @Override
    public boolean update(Component component) {
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
    public Component findById(int id) {
        for (Component component : this.components){
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
            this.components = new ArrayList<Component>();
            return true;
        }
        return false;
    }

    @Override
    public Component findByComponent(String description, ComponentType type) {

        for (Component component : this.components){
            if (component.getType() == type){
                if (type == ComponentType.OTHER && !Objects.equals(component.getDescription(), description)){
                    return null;
                }
                return component;
            }
        }
        return null;
    }
}
