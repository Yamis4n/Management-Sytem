package com.evertonvsf.managementsystem.dao.task.service;

import com.evertonvsf.managementsystem.dao.CRUD;
import com.evertonvsf.managementsystem.models.task.Service;
import com.evertonvsf.managementsystem.models.task.ServiceCategory;
import com.evertonvsf.managementsystem.models.task.ServiceStatus;

import java.util.List;

public interface ServiceCRUD extends CRUD<Service> {
    public Service findById(int id);
    public List<Service> findByRating(int rating);
    public List<Service> findByCategory(String category);
    public List<Service> findByStatus(String status);
    public boolean deleteById(int id);
    public boolean deleteByRating(int rating);
    public boolean deleteByCategory(String category);
    public boolean deleteByStatus(String status);

}
