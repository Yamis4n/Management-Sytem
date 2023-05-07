package com.evertonvsf.managementsystem.dao.crud.task.service;

import com.evertonvsf.managementsystem.dao.crud.CRUD;
import com.evertonvsf.managementsystem.models.task.Service;

import java.util.List;

public interface ServiceCRUD extends CRUD<Service> {
    public List<Service> findByRating(int rating);
    public List<Service> findByCategory(String category);
    public List<Service> findByStatus(String status);
    public boolean deleteById(int id);

}
