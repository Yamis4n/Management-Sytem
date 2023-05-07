package com.evertonvsf.managementsystem.dao.crud.stock.component;

import com.evertonvsf.managementsystem.dao.crud.CRUD;
import com.evertonvsf.managementsystem.models.stock.ComponentStock;

import java.util.List;

public interface ComponentCRUD extends CRUD<ComponentStock> {
    public List<ComponentStock> findByQuantity(int quantity);
    public List<ComponentStock> findByPrice(double price);
}
