package com.evertonvsf.managementsystem.controllers;

import com.evertonvsf.managementsystem.controllers.utils.MenuController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class InvoicesController extends MenuController {
    @FXML
    private Label usernameLabel;
    @FXML
    private void initialize(){
        MenuController.showUser(usernameLabel);
    }
}
