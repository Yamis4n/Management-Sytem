package com.evertonvsf.managementsystem.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class StockController extends MenuController{
    @FXML
    private Label usernameLabel;
    @FXML
    private void initialize(){
        MenuController.showUser(usernameLabel);
    }
}
