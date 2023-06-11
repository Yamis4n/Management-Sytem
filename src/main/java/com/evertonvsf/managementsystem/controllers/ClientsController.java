package com.evertonvsf.managementsystem.controllers;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class ClientsController extends MenuController{

    @FXML
    private Label usernameLabel;
    @FXML
    private void initialize(){
        MenuController.showUser(usernameLabel);



    }

   
}
