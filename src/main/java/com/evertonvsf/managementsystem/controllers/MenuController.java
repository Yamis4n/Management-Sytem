package com.evertonvsf.managementsystem.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.util.Objects;

public class MenuController {

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


    public static void showUser( Label usernameLabel ){
        usernameLabel.setAlignment(Pos.BASELINE_CENTER);
        usernameLabel.setText(MainController.loggedTechnician.getUsername());
        usernameLabel.setTextFill(Color.WHITE);
    }
    @FXML
    private void gotoClients() throws IOException {
        Parent clientsView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/clients.fxml")));
        MainController.stage.setScene(new Scene(clientsView));
    }

    @FXML
    private void gotoServices() throws IOException {
        Parent servicesView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/services.fxml")));
        MainController.stage.setScene(new Scene(servicesView));
    }

    @FXML
    private void gotoData() throws IOException {
        Parent dataView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/data.fxml")));
        MainController.stage.setScene(new Scene(dataView));

    }

    @FXML
    private void gotoHome() throws IOException {
        Parent homeView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/home.fxml")));
        MainController.stage.setScene(new Scene(homeView));

    }

    @FXML
    private void gotoInvoices() throws IOException {
        Parent invoicesView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/invoices.fxml")));
        MainController.stage.setScene(new Scene(invoicesView));

    }

    @FXML
    private void gotoStock() throws IOException {
        Parent stockView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/stock.fxml")));
        MainController.stage.setScene(new Scene(stockView));

    }

    @FXML
    private void logOut() throws IOException {
        MainController.loggedTechnician = null;
        Parent loginView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/login.fxml")));
        MainController.stage.setScene(new Scene(loginView));

    }




}
