package com.evertonvsf.managementsystem.controllers;

import com.evertonvsf.managementsystem.dao.DAO;
import com.evertonvsf.managementsystem.models.stock.Component;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class StockController extends MenuController{
    @FXML
    private Label usernameLabel;

    @FXML
    private TextField searchBox;

    @FXML
    private Button editButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button buyButton;

    @FXML
    private Label feedbackLabel;

    public static int selectedComponent;
    private final ObservableList<Component> componentsObservable = FXCollections.observableArrayList();

    @FXML
    private void initialize(){
        StockController.selectedComponent = -1;
        MenuController.showUser(usernameLabel);
    }

    @FXML
    private void gotoBuy(){}

    @FXML
    private void gotoEdit(){}

    @FXML
    private void deleteComponent(){
        if (DAO.fromComponent().deleteById(StockController.selectedComponent)){
            this.feedbackLabel.setTextFill(Color.GREEN);
            this.feedbackLabel.setText("Componente deletado com sucesso!");
            componentsObservable.removeIf(component -> component.getId() == StockController.selectedComponent);
            StockController.selectedComponent = -1;
            showComponent( null );
        }
        else {
            this.feedbackLabel.setText("Não foi possível deletar!");
        }
    }
    
    private void showComponent( Component component ) {}
}
