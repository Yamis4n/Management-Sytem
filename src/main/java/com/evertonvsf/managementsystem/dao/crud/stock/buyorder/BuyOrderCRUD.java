package com.evertonvsf.managementsystem.dao.crud.stock.buyorder;

import com.evertonvsf.managementsystem.dao.crud.CRUD;
import com.evertonvsf.managementsystem.models.stock.BuyOrder;

import java.util.List;

public interface BuyOrderCRUD extends CRUD<BuyOrder> {

    public List<BuyOrder> findByTechnician(int technicianId);
    public List<BuyOrder> findByPrice(double price);

}
