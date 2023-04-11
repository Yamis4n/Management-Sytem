package com.evertonvsf.managementsystem.controllers;

import com.evertonvsf.managementsystem.dao.DAO;
import com.evertonvsf.managementsystem.models.stock.BuyOrder;

import java.util.List;

public class BuyOrderController {

    public static BuyOrder  createBuyOrder(int technicianId, int componentId,
                                           int quantity, double unitaryCost){
        if (technicianId >= 0 && quantity > 0 && unitaryCost >0 && componentId > 0 && componentId <= 5){
            return DAO.getBuyOrderDAO().create(new BuyOrder(technicianId, componentId, quantity, unitaryCost));
        }
        return null;
    }
    public static boolean updateBuyOrder(int technicianId, int componentId, int quantity,
                                         double unitaryCost, int buyOderId){
        if (technicianId >= 0 && quantity > 0 && unitaryCost >0 && componentId > 0 && componentId <= 5 && buyOderId >=0){
            BuyOrder updatedBuyOrder = new BuyOrder(technicianId, componentId, quantity, unitaryCost);
            updatedBuyOrder.setId(buyOderId);
            return DAO.getBuyOrderDAO().update(updatedBuyOrder);
        }
        return false;
    }
    public static BuyOrder getById(int id) {
        if (id >= 0) {
            return DAO.getBuyOrderDAO().findById(id);
        }
        return null;
    }

    public static List<BuyOrder> getAll(){
        return DAO.getBuyOrderDAO().findMany();
    }

    public static List<BuyOrder> getByTechnician(int technicianId){
        if (technicianId >= 0){
            return DAO.getBuyOrderDAO().findByTechnician(technicianId);
        }
        return null;
    }

    public static boolean deleteById(int id){
        if (id >= 0){
            return DAO.getBuyOrderDAO().deleteById(id);
        }
        return false;
    }

    public static boolean deleteAll(){
        return DAO.getBuyOrderDAO().deleteMany();
    }







}
