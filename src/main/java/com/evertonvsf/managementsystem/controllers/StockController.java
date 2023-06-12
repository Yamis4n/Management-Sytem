package com.evertonvsf.managementsystem.controllers;

import com.evertonvsf.managementsystem.dao.DAO;
import com.evertonvsf.managementsystem.models.stock.Component;
import com.evertonvsf.managementsystem.models.stock.ComponentStock;
import com.evertonvsf.managementsystem.models.stock.ComponentType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;
import java.text.FieldPosition;
import java.text.Format;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Arrays;
import java.util.Locale;


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
    private TableColumn<ComponentStock, Integer> quantityColumn;

    @FXML
    private TableColumn<ComponentStock, Double> priceColumn;

    @FXML
    private Label descriptionLabel;

    @FXML
    private Label typeLabel;

    @FXML
    private Label quantityLabel;

    @FXML
    private Label priceLabel;


    public static int selectedComponent;
    private final ObservableList<ComponentStock> componentsObservable = FXCollections.observableArrayList();


    @FXML
    private void initialize(){
        this.feedbackLabel.setAlignment(Pos.BASELINE_CENTER);
        StockController.selectedComponent = -1;
        MenuController.showUser(usernameLabel);

        initializeTable();
        initializeSearch();
        componentsObservable.addAll(DAO.fromComponent().findMany());

        showComponent(null);
    }

    @FXML
    private void gotoBuy() throws IOException {
        DAO.fromComponent().create(new ComponentStock(10, 20, new Component("none", ComponentType.HD_SSD)));
        MainController.saveInfo();
        MainController.loadInfo();



    }

    @FXML
    private void gotoEdit(){}

    @FXML
    private void deleteComponent(){
        if (DAO.fromComponent().deleteById(StockController.selectedComponent)){
            this.feedbackLabel.setTextFill(Color.GREEN);
            this.feedbackLabel.setText("Componente deletado com sucesso!");
            componentsObservable.removeIf(componentStock -> componentStock.getId() == StockController.selectedComponent);
            StockController.selectedComponent = -1;
            showComponent( null );
        }
        else {
            this.feedbackLabel.setTextFill(Color.RED);
            this.feedbackLabel.setText("Não foi possível deletar!");
        }
    }

    private void initializeTable( ){
        this.typeColumn.setCellValueFactory(new PropertyValueFactory<ComponentStock, String>("componentType"));
        this.descriptionColumn.setCellValueFactory(new PropertyValueFactory<ComponentStock, String>("componentDescription"));
        this.quantityColumn.setCellValueFactory(new PropertyValueFactory<ComponentStock, Integer>("quantity"));
        this.priceColumn.setCellValueFactory(new PropertyValueFactory<ComponentStock, Double>("price"));

        this.typeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.descriptionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.quantityColumn.setCellFactory(TextFieldTableCell.forTableColumn( new IntegerStringConverter() ));
        this.priceColumn.setCellFactory(TextFieldTableCell.forTableColumn( new DoubleStringConverter() ));

        this.typeColumn.setStyle("-fx-alignment: CENTER;");
        this.descriptionColumn.setStyle("-fx-alignment: CENTER;");
        this.quantityColumn.setStyle("-fx-alignment: CENTER;");
        this.priceColumn.setStyle("-fx-alignment: CENTER;");

        this.componentsTable.onMouseClickedProperty().setValue(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (componentsTable.getSelectionModel().getSelectedItem() != null) {
                    ComponentStock componentStock = componentsTable.getSelectionModel().getSelectedItem();
                    StockController.selectedComponent = componentStock.getId();
                    showComponent(componentStock);
                }
            }
        });


    }

    private void initializeSearch(){
        FilteredList<ComponentStock> filteredComponentStockList = new FilteredList<ComponentStock>(componentsObservable, b -> true);

        this.searchBox.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredComponentStockList.setPredicate(componentStock -> {

                if ( newValue == null || newValue.isEmpty() ){
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if ( componentStock.getComponentType().toLowerCase().contains(lowerCaseFilter) ){
                    return true;
                }
                else if ( componentStock.getComponentDescription().toLowerCase().contains(lowerCaseFilter) ){
                    return true;
                }
                else if ( componentStock.getQuantity().toString().contains(lowerCaseFilter) ){
                    return true;
                }
                else return componentStock.getPrice().toString().contains(lowerCaseFilter);

            });

        });
        SortedList<ComponentStock> sortedComponentStockList = new SortedList<ComponentStock>(filteredComponentStockList);

        sortedComponentStockList.comparatorProperty().bind(componentsTable.comparatorProperty());

        componentsTable.setItems(sortedComponentStockList);
    }


    private void showComponent( ComponentStock componentStock ) {
        if (componentStock != null) {

            this.descriptionLabel.setText(componentStock.getComponentDescription());
            this.typeLabel.setText(componentStock.getComponentType());
            this.quantityLabel.setText(componentStock.getQuantity().toString());
            this.priceLabel.setText("R$ " + componentStock.getPrice().toString());
        }
    }
}
