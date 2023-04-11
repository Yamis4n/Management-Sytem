package com.evertonvsf.managementsystem.controllers;

import com.evertonvsf.managementsystem.dao.DAO;
import com.evertonvsf.managementsystem.models.task.ServiceOrder;

import java.util.List;

public class ServiceOrderController {
    public static ServiceOrder createServiceOrder(int clientId, int technicianId, List<Integer> servicesIds){
        ServiceOrder newServiceOrder = new ServiceOrder(clientId, technicianId);
        for (int serviceId : servicesIds){
            newServiceOrder.setServicesIds(serviceId);
        }
       return DAO.getServiceOrderDAO().create(new ServiceOrder(clientId, technicianId));
    }
    public static boolean updateServiceOrder(int clientId, int technicianId,
                                             List<Integer> servicesIds, int serviceOrderId){

        ServiceOrder newServiceOrder = new ServiceOrder(clientId, technicianId);
        for (int serviceId : servicesIds){
            newServiceOrder.setServicesIds(serviceId);
        }
        newServiceOrder.setId(serviceOrderId);
        return DAO.getServiceOrderDAO().update(newServiceOrder);
    }
    public static ServiceOrder getServiceOrderById(int id){
        if (id >= 0){
            return DAO.getServiceOrderDAO().findById(id);
        }
        return null;
    }

    public static List<ServiceOrder> getAllServiceOrders(){
        return DAO.getServiceOrderDAO().findMany();
    }

    public static boolean deleteServiceOrderById(int id){
        if (id  >= 0){
            return DAO.getServiceOrderDAO().deleteById(id);
        }
        return false;
    }

    public static boolean deleteAllServiceOrders(){
        return DAO.getServiceOrderDAO().deleteMany();
    }

    public static List<ServiceOrder> getServiceOrderByTechnician(int technicianId) {
        if (technicianId >= 0) {
            return DAO.getServiceOrderDAO().findByTechnician(technicianId);
        }
        return null;
    }
    public static List<ServiceOrder> getServiceOrderByStatus(String status) {
        return DAO.getServiceOrderDAO().findByStatus(status);
    }


    public static boolean deleteServiceOrderByTechnician(int technicianId) {
        if (technicianId >= 0) {
            return DAO.getServiceOrderDAO().deleteByTechnician(technicianId);
        }
        return false;
    }
    public static boolean deleteServiceOrderByStatus(String status) {
        return DAO.getServiceOrderDAO().deleteByStatus(status);
    }

}
