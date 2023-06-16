package com.evertonvsf.managementsystem.dao.crud.stock.component;

import com.evertonvsf.managementsystem.dao.crud.CRUD;
import com.evertonvsf.managementsystem.models.stock.Component;
import com.evertonvsf.managementsystem.models.stock.ComponentType;

public interface ComponentCRUD extends CRUD<Component> {
    public Component findByComponent(String description, ComponentType type);
}
