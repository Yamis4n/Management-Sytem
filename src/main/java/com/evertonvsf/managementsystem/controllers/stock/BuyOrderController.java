package com.evertonvsf.managementsystem.controllers.stock;

import com.evertonvsf.managementsystem.controllers.utils.MainController;
import com.evertonvsf.managementsystem.dao.DAO;
import com.evertonvsf.managementsystem.models.stock.BuyOrder;
import com.evertonvsf.managementsystem.models.stock.Component;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.converter.BooleanStringConverter;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;
import java.util.Objects;

public class BuyOrderController {
    @FXML
    private Button backButton;

    @FXML
    private Label descriptionLabel;

    @FXML
    private Label feedbackLabel;

    @FXML
    private TableView<BuyOrder> buyOrdersTable;

    @FXML
    private TableColumn<BuyOrder, Double> priceColumn;

    @FXML
    private TableColumn<BuyOrder, Integer> quantityColumn;

    @FXML
    private TableColumn<BuyOrder, String> typeColumn;

    @FXML
    private TableColumn<BuyOrder, String> technicianColumn;

    @FXML
    private TableColumn<BuyOrder, Boolean> statusColumn;

    @FXML
    private Label quantityLabel;

    @FXML
    private TextField searchBox;

    @FXML
    private Label technicianLabel;

    @FXML
    private Label typeLabel;

    @FXML
    private Label valueLabel;

    @FXML
    private AnchorPane workWindow;

    private static BuyOrder selectedOrder;
    private final ObservableList<BuyOrder> buyOrderObservable = FXCollections.observableArrayList();


    @FXML
    private void initialize() {
        selectedOrder = null;
        initializeTable();
        initializeSearch();
        buyOrderObservable.addAll(DAO.fromBuyOrder().findMany());
    }

    @FXML
    public void goBack() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/stock.fxml")));
        MainController.changePanel(root);

    }

    private void initializeTable( ){
        this.technicianColumn.setCellValueFactory(new PropertyValueFactory<BuyOrder, String>("technicianUsername"));
        this.typeColumn.setCellValueFactory(new PropertyValueFactory<BuyOrder, String>("componentType"));
        this.statusColumn.setCellValueFactory(new PropertyValueFactory<BuyOrder, Boolean>("arrived"));
        this.quantityColumn.setCellValueFactory(new PropertyValueFactory<BuyOrder, Integer>("quantity"));
        this.priceColumn.setCellValueFactory(new PropertyValueFactory<BuyOrder, Double>("unitaryCost"));

        this.technicianColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.statusColumn.setCellFactory(TextFieldTableCell.forTableColumn( new BooleanStringConverter()));

        this.typeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.quantityColumn.setCellFactory(TextFieldTableCell.forTableColumn( new IntegerStringConverter() ));
        this.priceColumn.setCellFactory(TextFieldTableCell.forTableColumn( new DoubleStringConverter() ));


        this.technicianColumn.setStyle("-fx-alignment: CENTER;");
        this.typeColumn.setStyle("-fx-alignment: CENTER;");
        this.statusColumn.setStyle("-fx-alignment: CENTER;");
        this.quantityColumn.setStyle("-fx-alignment: CENTER;");
        this.priceColumn.setStyle("-fx-alignment: CENTER;");

        this.buyOrdersTable.onMouseClickedProperty().setValue(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (buyOrdersTable.getSelectionModel().getSelectedItem() != null) {
                    BuyOrder buyOrder = buyOrdersTable.getSelectionModel().getSelectedItem();
                    BuyOrderController.selectedOrder = buyOrder;
                    showOrder(buyOrder);
                }
            }
        });

    }

    @FXML
    private void arrive() throws IOException {
        if (selectedOrder == null ){
            this.feedbackLabel.setText("ORDEM NÃO ENCONTRADA!");
            return;
        }
        if (selectedOrder.isArrived() ){
            this.feedbackLabel.setText("ESTA ORDEM JÁ FOI CONCLUIDA!");
            return;
        }

        selectedOrder.setArrived(true);
        DAO.fromBuyOrder().update(selectedOrder);
        Component component = DAO.fromComponent().findById(selectedOrder.getComponentId());
        component.setQuantity(component.getQuantity() + selectedOrder.getQuantity());
        component.setBuyPrice(selectedOrder.getUnitaryCost());
        DAO.fromComponent().update(component);


        MainController.changePanel(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/buyOrder.fxml"))));



    }
    private void initializeSearch(){
        FilteredList<BuyOrder> filteredBuyOrderList = new FilteredList<BuyOrder>(buyOrderObservable, b -> true);

        this.searchBox.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredBuyOrderList.setPredicate(buyOrder -> {

                if ( newValue == null || newValue.isEmpty() ){
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if ( buyOrder.getTechnicianUsername().toLowerCase().contains(lowerCaseFilter) ){
                    return true;
                }
                else if ( buyOrder.getQuantity().toString().contains(lowerCaseFilter) ){
                    return true;
                }
                else if ( buyOrder.getUnitaryCost().toString().contains(lowerCaseFilter) ){
                    return true;
                }
                else return DAO.fromComponent().findById(buyOrder.getComponentId()).getType().getName().toLowerCase().contains(lowerCaseFilter);

            });

        });
        SortedList<BuyOrder> sortedBuyOrderList = new SortedList<BuyOrder>(filteredBuyOrderList);

        sortedBuyOrderList.comparatorProperty().bind(buyOrdersTable.comparatorProperty());

        buyOrdersTable.setItems(sortedBuyOrderList);
    }

    private void showOrder(BuyOrder buyOrder){
        if (buyOrder != null) {

            this.descriptionLabel.setText(DAO.fromComponent().findById(buyOrder.getComponentId()).getDescription());
            this.typeLabel.setText(buyOrder.getComponentType());
            this.quantityLabel.setText(buyOrder.getQuantity().toString() +" unidades");
            this.technicianLabel.setText(buyOrder.getTechnicianUsername());
            this.valueLabel.setText("R$ "+ buyOrder.getUnitaryCost().toString());
        }
    }
}
