package com.evertonvsf.managementsystem.controllers;

import com.evertonvsf.managementsystem.controllers.clients.ClientsController;
import com.evertonvsf.managementsystem.controllers.utils.MainController;
import com.evertonvsf.managementsystem.dao.DAO;
import com.evertonvsf.managementsystem.models.stock.ComponentType;
import com.evertonvsf.managementsystem.models.task.ServiceCategory;
import com.evertonvsf.managementsystem.models.task.ServiceOrder;
import com.evertonvsf.managementsystem.models.task.Status;
import com.evertonvsf.managementsystem.models.users.Client;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class HomeController {


    @FXML
    private AnchorPane workWindow;

    @FXML
    private Label feedbackLabel;

    @FXML
    private TableView<ServiceOrder> orderTable;

    @FXML
    private TableColumn<ServiceOrder, String> clientColumn;

    @FXML
    private TableColumn<ServiceOrder, Integer>  idColumn;

    private static Integer nextOrderId = DAO.fromServiceOrder().getNewID()+1;
    @FXML
    private void initialize(){
        initializeTable();
        for (ServiceOrder serviceOrder : orderTable.getItems()){
            if (serviceOrder.getId() < nextOrderId){
                nextOrderId = serviceOrder.getId();
            }
        }

    }
    @FXML
    void getAnOrder(ActionEvent event) {
        if (MainController.loggedTechnician.getActualOrderId() == -1 && orderTable.getItems().size() > 0){
            MainController.loggedTechnician.setActualOrderId(nextOrderId);
            DAO.fromTechnician().update(MainController.loggedTechnician);
            orderTable.getItems().removeIf(order -> order.getId() == nextOrderId);
            ServiceOrder serviceOrder = DAO.fromServiceOrder().findById(nextOrderId);
            serviceOrder.setStatus(Status.INITIALIZED);
            DAO.fromServiceOrder().update(serviceOrder);

        }
        else{
            feedbackLabel.setText("Você não pode pegar uma nova ordem!");
        }
    }

    private void initializeTable(){
        this.clientColumn.setCellValueFactory(new PropertyValueFactory<>("clientCPF"));
        this.idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        for (ServiceOrder serviceOrder : DAO.fromServiceOrder().findMany()){
            if (serviceOrder.getStatus() == Status.WAITING){
                orderTable.getItems().add(serviceOrder);
            }
        }
    }
}
