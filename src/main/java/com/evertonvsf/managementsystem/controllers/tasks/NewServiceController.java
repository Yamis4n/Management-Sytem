package com.evertonvsf.managementsystem.controllers.tasks;

import com.evertonvsf.managementsystem.controllers.clients.ClientsController;
import com.evertonvsf.managementsystem.controllers.utils.MainController;
import com.evertonvsf.managementsystem.dao.DAO;
import com.evertonvsf.managementsystem.models.stock.Component;
import com.evertonvsf.managementsystem.models.stock.ComponentType;
import com.evertonvsf.managementsystem.models.task.Service;
import com.evertonvsf.managementsystem.models.task.ServiceCategory;
import com.evertonvsf.managementsystem.models.task.ServiceOrder;
import com.evertonvsf.managementsystem.models.users.Client;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NewServiceController {

    @FXML
    private Button cancelButton;

    @FXML
    private Label feedbackLabel;

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

    public static ObservableList<Service> serviceObservableList = FXCollections.observableArrayList();
    static final List<Integer> services = new ArrayList<>();
    private int selectedServiceId;

    @FXML
    private void initialize(){
        selectedServiceId = -1;
        initializeTable();
        initializeChoices();
    }

    @FXML
    private void cancel() throws IOException {
        Stage stage = (Stage) this.cancelButton.getScene().getWindow();
        MainController.changePanel(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/serviceOrders.fxml"))));
        stage.close();
    }

    @FXML
    private void include(ActionEvent event) throws IOException {
        if (this.serviceTypeChoice.getValue() == null){
            this.feedbackLabel.setText("selecione um tipo de serviço!");
            return;
        }
        if (this.serviceTypeChoice.getValue() == ServiceCategory.MOUNTING_OTHER){
            MainController.popUp(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/chooseType.fxml"))));
            return;
        }
        Service service = DAO.fromService().create(new Service(this.serviceTypeChoice.getValue()));
        service.setPrice(this.serviceTypeChoice.getValue().getPrice());
        Component component;
        boolean needComponent = true;
        switch (this.serviceTypeChoice.getValue()) {
            case MOUNTING_RAM -> component = DAO.fromComponent().findByComponent("", ComponentType.RAM);
            case MOUNTING_HD_SSD -> component = DAO.fromComponent().findByComponent("", ComponentType.HD_SSD);
            case MOUNTING_MOTHERBOARD -> component = DAO.fromComponent().findByComponent("", ComponentType.MOTHERBOARD);
            case MOUNTING_VIDEO_CARD -> component = DAO.fromComponent().findByComponent("", ComponentType.VIDEO_CARD);
            case MOUNTING_POWER_SUPPLY -> component = DAO.fromComponent().findByComponent("", ComponentType.POWER_SUPPLY);
            default -> {
                component = null;
                needComponent = false;
            }
        }

        if (needComponent){
            if (component != null && component.getQuantity() > 0){
                service.setComponentId(component.getId());
                component.setQuantity(component.getQuantity()-1);
            }
            else {
                feedbackLabel.setText("sem estoque!");
                return;
            }
        }
        serviceObservableList.add(service);
        services.add(service.getId());
        DAO.fromService().update(service);
        DAO.fromComponent().update(component);
        feedbackLabel.setText("");
    }
    @FXML
    private void remove(ActionEvent event) {
        if (selectedServiceId != -1){
            services.removeIf(id -> id == selectedServiceId);
            servicesTable.getItems().removeIf(service -> service.getId() == selectedServiceId);
            Component component = DAO.fromComponent().findById(DAO.fromService().findById(selectedServiceId).getComponentId());
            component.setQuantity(component.getQuantity()+1);
            DAO.fromComponent().update(component);
            DAO.fromService().deleteById(selectedServiceId);
        }
        else {
            feedbackLabel.setText("selecione um serviço!");
        }
    }

    @FXML
    private void save(ActionEvent event) throws IOException {
        if (validate()){
            DAO.fromServiceOrder().create(new ServiceOrder(this.clientCpf.getText(), services));
        }
        else {
            this.feedbackLabel.setText("Dados inválidos!");
            return;
        }
        cancel();
    }

    private boolean validate(){

        if (this.clientCpf.getText().length() > 0 && services.size() > 0){
            return DAO.fromClient().findByCpf(this.clientCpf.getText()) != null;
        }
        return false;
    }

    private void initializeTable(){


        this.typeColumn.setCellValueFactory(new PropertyValueFactory<Service, ServiceCategory>("category"));
        this.priceColumn.setCellValueFactory(new PropertyValueFactory<Service, Double>("price"));
        this.componentColumn.setCellValueFactory(new PropertyValueFactory<Service, Integer>("componentId"));

        this.componentColumn.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Integer>() {
            @Override
            public String toString(Integer integer) {
                if (integer != null) {
                    return DAO.fromComponent().findById(integer).getType().getName();
                }
                return " ";
            }

            @Override
            public Integer fromString(String s) {
                return null;
            }
        }));
        this.servicesTable.onMouseClickedProperty().setValue(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (servicesTable.getSelectionModel().getSelectedItem() != null) {
                    selectedServiceId = servicesTable.getSelectionModel().getSelectedItem().getId();

                }
            }
        });
        servicesTable.setItems(serviceObservableList);

    }
    private void initializeChoices(){
        this.serviceTypeChoice.getItems().addAll(ServiceCategory.values());
    }
}

