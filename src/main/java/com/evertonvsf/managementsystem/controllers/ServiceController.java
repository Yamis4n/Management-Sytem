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
    public static List<Service> getAllServices(){
        return DAO.getServiceDao().findMany();
    }
    public static boolean deleteAllServices(){
        return DAO.getServiceDao().deleteMany();
    }
    public static Service getServiceById(int id){
        if (id >= 0){
            return DAO.getServiceDao().findById(id);
        }
        return null;
    }
    public static boolean deleteServiceById(int id){
        if (id >= 0){
            return DAO.getServiceDao().deleteById(id);
        }
        return false;
    }
}
