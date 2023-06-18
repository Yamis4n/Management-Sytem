package com.evertonvsf.managementsystem.controllers.tasks;

import com.evertonvsf.managementsystem.controllers.utils.MainController;
import com.evertonvsf.managementsystem.dao.DAO;
import com.evertonvsf.managementsystem.models.stock.Component;
import com.evertonvsf.managementsystem.models.task.Service;
import com.evertonvsf.managementsystem.models.task.ServiceCategory;
import com.evertonvsf.managementsystem.models.task.ServiceOrder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;

public class NewServiceController {

    @FXML
    public Label feedbackLabel;

    @FXML
    private TextField clientCpf;

    @FXML
    private ChoiceBox<ServiceCategory> serviceTypeChoice;

    @FXML
    private TableView<Service> servicesTable;

    @FXML
    private TableColumn<Service, Integer> componentColumn;

    @FXML
    private TableColumn<Service, Double> priceColumn;

    @FXML
    private TableColumn<Service, ServiceCategory> typeColumn;

    public static Service newService;

    private final List<Integer> services = new ArrayList<>();

    @FXML
    private void initialize(){
        newService = null;
        initializeTable();
        initializeChoices();
    }

    @FXML
    void cancel() {

    }

    @FXML
    void include(ActionEvent event) {

    }

    @FXML
    void save(ActionEvent event) {
        if (validate()){
            DAO.fromServiceOrder().create(new ServiceOrder(Integer.parseInt( this.clientCpf.getText() ), services));
        }
        else {
            this.feedbackLabel.setText("Dados inválidos!");
        }
        cancel();
    }

    private boolean validate(){
        if (this.clientCpf.getText().length() > 0 && services.size() > 0){
            try{
                Integer.parseInt(this.clientCpf.getText());
            }
            catch (Exception e){
                return false;
            }
            return true;

        }
        return false;
    }

    private void initializeTable(){}
    private void initializeChoices(){
        this.serviceTypeChoice.getItems().addAll(ServiceCategory.values());
    }
}

