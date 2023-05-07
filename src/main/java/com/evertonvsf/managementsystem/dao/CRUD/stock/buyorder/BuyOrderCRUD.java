package com.evertonvsf.managementsystem.dao.CRUD.stock.buyorder;

import com.evertonvsf.managementsystem.dao.CRUD;
import com.evertonvsf.managementsystem.models.stock.BuyOrder;

import java.util.List;

public interface BuyOrderCRUD extends CRUD<BuyOrder> {

    public List<BuyOrder> findByTechnician(int technicianId);
    public List<BuyOrder> findByPrice(double price);

}
