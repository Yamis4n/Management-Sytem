package com.evertonvsf.managementsystem.controllers;

import com.evertonvsf.managementsystem.dao.DAO;

public abstract class MainController {
    public static void saveInfo() {
        DAO.fromClient().writePersistence();
        DAO.fromTechnician().writePersistence();

        DAO.fromService().writePersistence();
        DAO.fromServiceOrder().writePersistence();

        DAO.fromBuyOrder().writePersistence();
        DAO.fromComponent().writePersistence();

        DAO.fromInvoice().writePersistence();
        DAO.fromPayment().writePersistence();
    }
}
