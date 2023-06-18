package com.evertonvsf.managementsystem.controllers.utils;

import com.evertonvsf.managementsystem.dao.DAO;
import com.evertonvsf.managementsystem.models.users.Technician;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.security.auth.login.AccountLockedException;
import java.io.IOException;
import java.util.Objects;

public abstract class MainController {
    public static Stage STAGE;;
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

    public static void changePanel(Node root) throws IOException {
        BorderPane borderPane = (BorderPane) STAGE.getScene().getRoot();
        borderPane.setRight(root);
        STAGE.setScene(STAGE.getScene());
        MainController.saveInfo();
        MainController.loadInfo();
    }

    public static void login() throws IOException {
        BorderPane borderPane = new BorderPane();
        Node left = FXMLLoader.load(Objects.requireNonNull(MainController.class.getResource("/views/menu.fxml")));
        Node right = FXMLLoader.load(Objects.requireNonNull(MainController.class.getResource("/views/home.fxml")));
        borderPane.setRight(right);
        borderPane.setLeft(left);
        Scene scene= new Scene(borderPane);
        STAGE.setScene(scene);
    }

}
