package com.evertonvsf.managementsystem.dao.stock.component;

import com.evertonvsf.managementsystem.dao.CRUD;
import com.evertonvsf.managementsystem.models.stock.Component;

import java.util.List;

public interface ComponentCRUD extends CRUD<Component> {
    public Component getById(int Id);
    public List<Component> getByQuantity(int quantity);
    public List<Component> getByPrice(double price);
    public boolean deleteById(int id);
    public boolean deleteByQuantity(int quantity);
    public boolean deleteByPrice(double price);
}
