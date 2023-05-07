package com.evertonvsf.managementsystem.dao.stock.component;

import com.evertonvsf.managementsystem.dao.CRUD;
import com.evertonvsf.managementsystem.models.stock.Component;
import com.evertonvsf.managementsystem.models.stock.ComponentStock;

import java.util.List;

public interface ComponentCRUD extends CRUD<ComponentStock> {
    public List<ComponentStock> findByQuantity(int quantity);
    public List<ComponentStock> findByPrice(double price);
}
