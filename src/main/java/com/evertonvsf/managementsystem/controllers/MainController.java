package com.evertonvsf.managementsystem.controllers;

import com.evertonvsf.managementsystem.dao.DAO;
import com.evertonvsf.managementsystem.models.users.Technician;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public abstract class MainController {
    public static Stage STAGE;
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

    public static void loadInfo() {
        DAO.fromClient().loadPersistence();
        DAO.fromTechnician().loadPersistence();

        DAO.fromService().loadPersistence();
        DAO.fromServiceOrder().loadPersistence();

        DAO.fromBuyOrder().loadPersistence();
        DAO.fromComponent().loadPersistence();

        DAO.fromInvoice().loadPersistence();
        DAO.fromPayment().loadPersistence();
    }

    public static void popUp(Parent root){
        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(MainController.STAGE);
        stage.setScene(new Scene(root));
        stage.setResizable(false);

        stage.show();
    }
}
