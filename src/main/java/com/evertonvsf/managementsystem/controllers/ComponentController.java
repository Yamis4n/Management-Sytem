package com.evertonvsf.managementsystem.controllers;

import com.evertonvsf.managementsystem.dao.DAO;
import com.evertonvsf.managementsystem.models.stock.Component;

import java.util.List;

public class ComponentController {
    public static Component createComponent(int quantity, int componentId, double price){
        if (quantity > 0 && componentId >= 0 && price >0){
            return DAO.getComponentDAO().create(new Component(quantity, price, componentId));
        }
        return null;
    }
    public static boolean updateComponent(int quantity, int componentId, double price){
        if (quantity > 0 && componentId >= 0 && price >0){
            return DAO.getComponentDAO().update(new Component(quantity, price, componentId));
        }
        return false;
    }
    public static Component getComponentById(int id){
        if (id >= 0){
            return DAO.getComponentDAO().findById(id);
        }
        return null;
    }

    public static List<Component> getAllComponents(){
        return DAO.getComponentDAO().findMany();
    }

    public static List<Component> getComponentsByQuantity(int quantity){
        if (quantity >= 0){
            return DAO.getComponentDAO().findByQuantity(quantity);
        }
        return null;
    }

    public static List<Component> getComponentsByPrice(double price){
        if (price >= 0){
            return DAO.getComponentDAO().findByPrice(price);
        }
        return null;
    }

    public boolean deleteComponentById(int id){
        if (id >= 0){
            return DAO.getComponentDAO().deleteById(id);
        }
        return false;
    }

    public boolean deleteAllComponents(){
        return DAO.getComponentDAO().deleteMany();
    }

}
