package com.evertonvsf.managementsystem.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ClientsController extends MenuController{

    @FXML
    private Label usernameLabel;
    @FXML
    private void initialize(){
        MenuController.showUser(usernameLabel);



    }
    @FXML
    private void gotoRegister() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/clients_register.fxml")));
        popUp(root);

    }

    @FXML
    private void gotoEdit() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/clients_edit.fxml")));
        popUp(root);
    }

    @FXML
    private void deleteClient(){}

    public void popUp(Parent root){
        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(MainController.stage);
        stage.setScene(new Scene(root));
        stage.setResizable(false);

        stage.show();
    }
}
