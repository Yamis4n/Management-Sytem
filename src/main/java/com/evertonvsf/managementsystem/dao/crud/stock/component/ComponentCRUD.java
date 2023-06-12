package com.evertonvsf.managementsystem.dao.crud.stock.component;

import com.evertonvsf.managementsystem.dao.crud.CRUD;
import com.evertonvsf.managementsystem.models.stock.Component;
import com.evertonvsf.managementsystem.models.stock.ComponentStock;

import java.util.List;

public interface ComponentCRUD extends CRUD<ComponentStock> {

    public ComponentStock findByComponent(Component component);
}
