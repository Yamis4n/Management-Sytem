package com.evertonvsf.managementsystem.controllers;

import com.evertonvsf.managementsystem.dao.DAO;
import com.evertonvsf.managementsystem.models.task.Service;

import java.util.List;

public class ServiceController {
    public static Service createService(int category){
        if (category >= 0 && category <= 7){
            Service newService = new Service(category);
            return DAO.getServiceDao().create(newService);
        }
        return null;
    }
    public static boolean updateService(int category, int id){
        if (id >= 0 && category >= 0 && category <= 7){
            Service newService = new Service(category);
            newService.setId(id);
            return DAO.getServiceDao().update(newService);
        }
        return false;
    }
    public static List<Service> getAll(){
        return DAO.getServiceDao().findMany();
    }
    public static Service getById(int id){
        if (id >= 0){
            return DAO.getServiceDao().findById(id);
        }
        return null;
    }
    public static boolean deleteById(int id){
        if (id >= 0){
            return DAO.getServiceDao().deleteById(id);
        }
        return false;
    }
    public static boolean deleteAll(){
        return DAO.getServiceDao().deleteMany();
    }
    public static List<Service> getByCategory(String category){
        return DAO.getServiceDao().findByCategory(category);
    }
    public static List<Service> getByRating(int rating){
        return DAO.getServiceDao().findByRating(rating);
    }
    public static List<Service> getByStatus(String status){
        return DAO.getServiceDao().findByStatus(status);
    }
    public static boolean deleteByRating(int rating){
        return DAO.getServiceDao().deleteByRating(rating);
    }
    public static boolean deleteByCategory(String category){
        return DAO.getServiceDao().deleteByCategory(category);
    }
    public static boolean deleteByStatus(String status){
        return DAO.getServiceDao().deleteByStatus(status);
    }
}
