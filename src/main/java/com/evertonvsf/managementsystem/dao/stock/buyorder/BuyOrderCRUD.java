package com.evertonvsf.managementsystem.dao.stock.buyorder;

import com.evertonvsf.managementsystem.dao.CRUD;
import com.evertonvsf.managementsystem.models.stock.BuyOrder;

public interface BuyOrderCRUD extends CRUD<BuyOrder> {

    public BuyOrder findById(int id);
    public boolean deleteById(int id);
    
}
