package com.evertonvsf.managementsystem.dao.stock.buyorder;

import com.evertonvsf.managementsystem.dao.CRUD;
import com.evertonvsf.managementsystem.models.stock.BuyOrder;

import java.util.List;

public interface BuyOrderCRUD extends CRUD<BuyOrder> {

    public BuyOrder findById(int id);
    public List<BuyOrder> findByTechnician(int technicianId);
    public List<BuyOrder> findByPrice(double price);
    public boolean deleteById(int id);
    public boolean deleteByTechnician(int technicianId);
    public boolean deleteByPrice(double price);
}
