package com.evertonvsf.managementsystem.controllers.stock;

import com.evertonvsf.managementsystem.controllers.utils.MainController;
import com.evertonvsf.managementsystem.controllers.utils.MenuController;
import com.evertonvsf.managementsystem.dao.DAO;
import com.evertonvsf.managementsystem.models.stock.Component;
import com.evertonvsf.managementsystem.models.stock.ComponentType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;
import java.util.Objects;


public class StockController extends MenuController {
    @FXML
    private Label usernameLabel;

    @FXML
    private Label feedbackLabel;

    @FXML
    private TextField searchBox;

    @FXML
    private TableView<Component> componentsTable;

    @FXML
    private TableColumn<Component, String> typeColumn;

    @FXML
    private TableColumn<Component, String> descriptionColumn;

    @FXML
    private TableColumn<Component, Integer> quantityColumn;

    @FXML
    private TableColumn<Component, Double> priceColumn;

    @FXML
    private Label descriptionLabel;

    @FXML
    private Label typeLabel;

    @FXML
    private Label quantityLabel;

    @FXML
    private Label priceLabel;


    public static Component selectedComponent;
    private final ObservableList<Component> componentsObservable = FXCollections.observableArrayList();


    @FXML
    private void initialize(){
        this.feedbackLabel.setAlignment(Pos.BASELINE_CENTER);
        StockController.selectedComponent = null;
        MenuController.showUser(usernameLabel);

        initializeTable();
        initializeSearch();
        componentsObservable.addAll(DAO.fromComponent().findMany());

        showComponent(null);
    }

    @FXML
    private void gotoBuy() throws IOException {
        MainController.popUp(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/buyComponent.fxml"))));

    }

    private void initializeTable( ){
        this.typeColumn.setCellValueFactory(new PropertyValueFactory<Component, String>("componentType"));
        this.descriptionColumn.setCellValueFactory(new PropertyValueFactory<Component, String>("componentDescription"));
        this.quantityColumn.setCellValueFactory(new PropertyValueFactory<Component, Integer>("quantity"));
        this.priceColumn.setCellValueFactory(new PropertyValueFactory<Component, Double>("Buyprice"));

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
                    Component componentStock = componentsTable.getSelectionModel().getSelectedItem();
                    StockController.selectedComponent = componentStock;
                    showComponent(componentStock);
                }
            }
        });


    }

    private void initializeSearch(){
        FilteredList<Component> filteredComponentStockList = new FilteredList<Component>(componentsObservable, b -> true);

        this.searchBox.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredComponentStockList.setPredicate(componentStock -> {

                if ( newValue == null || newValue.isEmpty() ){
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if ( componentStock.getType().getName().toLowerCase().contains(lowerCaseFilter) ){
                    return true;
                }
                else if ( componentStock.getDescription().toLowerCase().contains(lowerCaseFilter) ){
                    return true;
                }
                else if ( componentStock.getQuantity().toString().contains(lowerCaseFilter) ){
                    return true;
                }
                else return componentStock.getBuyPrice().toString().contains(lowerCaseFilter);

            });

        });
        SortedList<Component> sortedComponentStockList = new SortedList<Component>(filteredComponentStockList);

        sortedComponentStockList.comparatorProperty().bind(componentsTable.comparatorProperty());

        componentsTable.setItems(sortedComponentStockList);
    }


    private void showComponent( Component componentStock ) {
        if (componentStock != null) {

            this.descriptionLabel.setText(componentStock.getDescription());
            this.typeLabel.setText(componentStock.getType().getName());
            this.quantityLabel.setText(componentStock.getQuantity().toString() +" unidades");
            this.priceLabel.setText("R$ " + componentStock.getBuyPrice().toString());
        }
    }
}
