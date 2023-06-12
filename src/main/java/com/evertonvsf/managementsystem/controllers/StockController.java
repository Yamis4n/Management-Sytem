package com.evertonvsf.managementsystem.controllers;

import com.evertonvsf.managementsystem.dao.DAO;
import com.evertonvsf.managementsystem.models.stock.Component;
import com.evertonvsf.managementsystem.models.stock.ComponentStock;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;

public class StockController extends MenuController{
    @FXML
    private Label usernameLabel;

    @FXML
    private Label feedbackLabel;

    @FXML
    private TextField searchBox;

    @FXML
    private TableView<ComponentStock> componentsTable;

    @FXML
    private TableColumn<ComponentStock, String> typeColumn;

    @FXML
    private TableColumn<ComponentStock, String> descriptionColumn;

    @FXML
    private TableColumn<ComponentStock, String> quantityColumn;

    @FXML
    private TableColumn<ComponentStock, String> priceColumn;



    public static int selectedComponent;
    private final ObservableList<Component> componentsObservable = FXCollections.observableArrayList();

    @FXML
    private void initialize(){
        StockController.selectedComponent = -1;
        MenuController.showUser(usernameLabel);

        initializeTable();
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

    private void initializeTable( ){
        typeColumn.setCellValueFactory(new PropertyValueFactory<ComponentStock, String>());

    }

    private void showComponent( Component component ) {}
}
