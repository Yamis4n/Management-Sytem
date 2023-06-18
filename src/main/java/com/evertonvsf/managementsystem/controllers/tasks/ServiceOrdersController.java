package com.evertonvsf.managementsystem.controllers.tasks;

import com.evertonvsf.managementsystem.controllers.clients.ClientsController;
import com.evertonvsf.managementsystem.dao.DAO;
import com.evertonvsf.managementsystem.models.task.ServiceOrder;
import com.evertonvsf.managementsystem.models.task.Status;
import com.evertonvsf.managementsystem.models.users.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.StringConverter;
import javafx.util.converter.BooleanStringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.util.ArrayList;
import java.util.List;

public class ServiceOrdersController {

    @FXML
    private Button createButton;

    @FXML
    private Button detailsButton;

    @FXML
    private Button editButton;

    @FXML
    private Label feedbackLabel;

    @FXML
    private TextField searchBox;

    @FXML
    private TableView<ServiceOrder> ordersTable;

    @FXML
    private TableColumn<ServiceOrder, Integer> clientColumn;

    @FXML
    private TableColumn<ServiceOrder, Boolean> payedColumn;

    @FXML
    private TableColumn<ServiceOrder, String> statusColumn;

    @FXML
    private TableColumn<ServiceOrder, String> technicianColumn;

    @FXML
    private AnchorPane workWindow;


    public static ServiceOrder selectedOrder;
    private final ObservableList<ServiceOrder> serviceOrdersObservable = FXCollections.observableArrayList();

    @FXML
    private void initialize(){
        serviceOrdersObservable.addAll(DAO.fromServiceOrder().findMany());
        serviceOrdersObservable.add((new ServiceOrder(111, new ArrayList<Integer>())));
        selectedOrder = null;
        initializeTable();
        initializeSearch();
    }
    private void initializeTable(){
        this.statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        this.clientColumn.setCellValueFactory(new PropertyValueFactory<>("clientCPF"));
        this.technicianColumn.setCellValueFactory(new PropertyValueFactory<>("technicianUsername"));
        this.payedColumn.setCellValueFactory(new PropertyValueFactory<>("payed"));

        this.statusColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.clientColumn.setCellFactory(TextFieldTableCell.forTableColumn( new IntegerStringConverter()));
        this.technicianColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.payedColumn.setCellFactory(TextFieldTableCell.forTableColumn( new BooleanStringConverter()));

        this.statusColumn.setStyle("-fx-alignment: CENTER;");
        this.clientColumn.setStyle("-fx-alignment: CENTER;");
        this.technicianColumn.setStyle("-fx-alignment: CENTER;");
        this.payedColumn.setStyle("-fx-alignment: CENTER;");
        this.ordersTable.onMouseClickedProperty().setValue(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (ordersTable.getSelectionModel().getSelectedItem() != null) {
                    ServiceOrdersController.selectedOrder = ordersTable.getSelectionModel().getSelectedItem();

                }
            }
        });


    }

    private void initializeSearch(){
        FilteredList<ServiceOrder> filteredClientList = new FilteredList<ServiceOrder>(serviceOrdersObservable, b -> true);

        this.searchBox.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredClientList.setPredicate(order -> {

                if ( newValue == null || newValue.isEmpty() ){
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if ( order.getClientCPF().toString().contains(lowerCaseFilter) ){
                    return true;
                }
                else if ( order.getStatus().toLowerCase().contains(lowerCaseFilter) ){
                    return true;
                }
                else {
                    return order.getTechnicianUsername().contains(lowerCaseFilter) ;
                }


            });

        });
        SortedList<ServiceOrder> serviceOrdersSorted = new SortedList<ServiceOrder>(filteredClientList);

        serviceOrdersSorted.comparatorProperty().bind(ordersTable.comparatorProperty());

        ordersTable.setItems(serviceOrdersSorted);
    }

    public void gotoRegister(ActionEvent actionEvent) {
    }

    public void gotoEdit(ActionEvent actionEvent) {
    }

    public void gotoDetails(ActionEvent actionEvent) {
    }

}
