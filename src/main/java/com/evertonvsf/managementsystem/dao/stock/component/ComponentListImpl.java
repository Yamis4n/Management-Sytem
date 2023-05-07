package com.evertonvsf.managementsystem.dao.stock.component;

import com.evertonvsf.managementsystem.models.stock.Component;
import com.evertonvsf.managementsystem.models.stock.ComponentStock;
import com.evertonvsf.managementsystem.models.users.Client;

import java.util.ArrayList;
import java.util.List;

public class ComponentListImpl implements ComponentCRUD{
    private List<ComponentStock> components;

    @Override
    public Component create(Component component) {
        this.components.add(component);
        return component;
    }

    @Override
    public List<Component> findMany() {
        return new ArrayList<Component>(this.components);
    }

    @Override
    public boolean update(Component component) {
        for (int index =0; index < this.components.size(); index++){
            if (this.components.get(index).getId() == component.getId()){
                this.components.add(index, component);
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
    public Component findById(int id) {
        for (Component component : this.components){
            if (component.getId() == id){
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
    public List<Component> findByPrice(double price) {
        List<Component> samePriceComponents = new ArrayList<Component>();
        for (Component component : this.components){
            if (component.getValue() == price){
                samePriceComponents.add(component);
            }
        }
        return samePriceComponents;
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
    public boolean deleteByQuantity(int quantity) {
        List<Component> sameQuantityComponents = this.findByQuantity(quantity);
        if (sameQuantityComponents.size() > 0){
            this.components.removeAll(sameQuantityComponents);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteByPrice(double price) {
        List<Component> samePriceComponents = findByPrice(price);
        if (samePriceComponents.size() > 0){
            this.components.removeAll(samePriceComponents);
            return true;
        }
        return false;
    }
}
