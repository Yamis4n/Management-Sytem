package com.evertonvsf.managementsystem.controllers;

import com.evertonvsf.managementsystem.models.users.Technician;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;

import static javafx.application.Application.launch;


public class DataController extends  MenuController {

    @FXML
    private AnchorPane workWindow;

    @FXML
    private Label usernameLabel;

    @FXML
    private void initialize(){
        MenuController.showUser(usernameLabel);
    }




}
