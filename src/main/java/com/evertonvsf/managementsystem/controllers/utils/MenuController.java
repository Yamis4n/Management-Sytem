package com.evertonvsf.managementsystem.controllers.utils;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.util.Objects;

public class MenuController {
    @FXML
    private AnchorPane workflow;

    @FXML
    private Button homeButton;

    @FXML
    private Button clientsButton;

    @FXML
    private Button stockButton;

    @FXML
    private Button servicesButton;

    @FXML
    private Button invoicesButton;

    @FXML
    private Button logOutButton;

    @FXML
    private Button myData;

    @FXML
    private Label usernameLabel;

    @FXML
    private void initialize( ) throws IOException {
        usernameLabel.setAlignment(Pos.BASELINE_CENTER);
        usernameLabel.setText(MainController.loggedTechnician.getUsername());
        usernameLabel.setTextFill(Color.WHITE);
        gotoHome();
    }
    @FXML
    private void gotoClients() throws IOException {
        changePanel(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/clients.fxml"))));

    }

    @FXML
    private void gotoServices() throws IOException {
        changePanel(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/services.fxml"))));
    }

    @FXML
    private void gotoTechnicians() throws IOException {
        changePanel(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/data.fxml"))));

    }

    @FXML
    private void gotoHome() throws IOException {
        changePanel(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/home.fxml"))));

    }

    @FXML
    private void gotoInvoices() throws IOException {
        changePanel(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/invoices.fxml"))));

    }

    @FXML
    private void gotoStock() throws IOException {
        changePanel(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/stock.fxml"))));
    }

    @FXML
    private void logOut() throws IOException {
        MainController.loggedTechnician = null;
        Parent loginView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/login.fxml")));
        MainController.STAGE.setScene(new Scene(loginView));
        MainController.saveInfo();

    }

    private void changePanel(Parent root){
        if (this.workflow.getChildren() != null) {
            this.workflow.getChildren().removeAll();
        }
        this.workflow.getChildren().add(root);
    }




}
