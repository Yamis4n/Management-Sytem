package com.evertonvsf.managementsystem.dao.crud.stock.component;

import com.evertonvsf.managementsystem.dao.persistence.stock.componentstock.ComponentPersistence;
import com.evertonvsf.managementsystem.models.stock.ComponentStock;

import java.util.ArrayList;
import java.util.List;

public class ComponentListImpl implements ComponentCRUD{
    private static final ComponentPersistence persistence = new ComponentPersistence();
    private List<ComponentStock> components;

    @Override
    public ComponentStock create(ComponentStock component) {
        this.components.add(component);
        return component;
    }
    @Override
    public void writePersistence(){
        persistence.writeFiles(this.components);
    }
    @Override
    public List<ComponentStock> findMany() {
        return new ArrayList<ComponentStock>(this.components);
    }

    @Override
    public boolean update(ComponentStock component) {
        for (int index =0; index < this.components.size(); index++){
            if (this.components.get(index).getComponent().getId() == component.getComponent().getId()){
                this.components.add(index, component);
                return true;
            }
        }
        return false;
    }

    @Override
    public ComponentStock findById(int id) {
        for (ComponentStock component : this.components){
            if (component.getComponent().getId() == id){
                return component;
            }
        }
        return null;
    }

    @Override
    public List<ComponentStock> findByQuantity(int quantity) {
        List<ComponentStock> sameQuantityComponents = new ArrayList<ComponentStock>();
        for (ComponentStock component : this.components){
            if (component.getQuantity() == quantity){
                sameQuantityComponents.add(component);
            }
        }
        return sameQuantityComponents;
    }

    @Override
    public List<ComponentStock> findByPrice(double price) {
        List<ComponentStock> samePriceComponents = new ArrayList<ComponentStock>();
        for (ComponentStock component : this.components){
            if (component.getPrice() == price){
                samePriceComponents.add(component);
            }
        }
        return samePriceComponents;
    }

    @Override
    public boolean deleteById(int id) {
        for (int index = 0; index < this.components.size(); index++){
            if (this.components.get(index).getComponent().getId() == id){
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
}
