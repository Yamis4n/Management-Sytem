package com.evertonvsf.managementsystem.controllers;

import com.evertonvsf.managementsystem.dao.DAO;
import com.evertonvsf.managementsystem.models.users.Technician;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public abstract class MainController {
    public static Stage stage;
    public static Technician loggedTechnician;
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
