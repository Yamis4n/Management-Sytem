package com.evertonvsf.managementsystem.dao.crud.stock.buyorder;

import com.evertonvsf.managementsystem.dao.persistence.stock.buyorder.BuyOrderPersistence;
import com.evertonvsf.managementsystem.models.money.Payment;
import com.evertonvsf.managementsystem.models.stock.BuyOrder;

import java.util.ArrayList;
import java.util.List;

public class BuyOrderListImpl implements BuyOrderCRUD{
    private static final BuyOrderPersistence persistence = new BuyOrderPersistence();
    private List<BuyOrder> buyOrders;
    private int newId;

    public BuyOrderListImpl() {
        this.buyOrders = persistence.loadFiles();
        int newId = -1;
        for (BuyOrder buyOrder : buyOrders){
            if (buyOrder.getId() > newId){
                newId = buyOrder.getId();
            }
        }
        this.newId = newId +1;
    }

    @Override
    public void writePersistence(){
        persistence.writeFiles(this.buyOrders);
    }

    @Override
    public BuyOrder create(BuyOrder buyOrder) {
        buyOrder.setId(this.newId);
        this.newId++;
        this.buyOrders.add(buyOrder);
        return buyOrder;
    }

    @Override
    public List<BuyOrder> findMany() {
        return new ArrayList<BuyOrder>(this.buyOrders);
    }

    @Override
    public boolean update(BuyOrder buyOrder) {
        for (int index = 0; index < this.buyOrders.size(); index++){
            if (this.buyOrders.get(index).getId() == buyOrder.getId()){
                this.buyOrders.add(index, buyOrder);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteMany() {
        this.newId = 0;
        if (this.buyOrders.size() == 0){
            return false;
        }
        this.buyOrders = new ArrayList<BuyOrder>();
        return true;
    }

    @Override
    public BuyOrder findById(int id) {
        for (BuyOrder buyOrder : this.buyOrders){
            if (buyOrder.getId() == id){
                return buyOrder;
            }
        }
        return null;
    }

    @Override
    public List<BuyOrder> findByTechnician(int technicianId) {
        List<BuyOrder> sameTechnicianBuyOrders = new ArrayList<BuyOrder>();
        for (BuyOrder buyOrder : this.buyOrders){
            if (buyOrder.getId() == technicianId){
                sameTechnicianBuyOrders.add(buyOrder);
            }
        }
        return sameTechnicianBuyOrders;
    }

    @Override
    public List<BuyOrder> findByPrice(double price) {
        List<BuyOrder> samePriceBuyOrders = new ArrayList<BuyOrder>();
        for (BuyOrder buyOrder : this.buyOrders){
            if (buyOrder.getId() == price){
                samePriceBuyOrders.add(buyOrder);
            }
        }
        return samePriceBuyOrders;
    }

    @Override
    public boolean deleteById(int id) {
        for (int index = 0; index < this.buyOrders.size(); index++) {
            if (this.buyOrders.get(index).getId() == id) {
                this.buyOrders.remove(index);
                return true;
            }
        }
        return false;
    }
}
