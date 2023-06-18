package com.evertonvsf.managementsystem.controllers.tasks;

import com.evertonvsf.managementsystem.controllers.utils.MainController;
import com.evertonvsf.managementsystem.dao.DAO;
import com.evertonvsf.managementsystem.models.money.Invoice;
import com.evertonvsf.managementsystem.models.task.Service;
import com.evertonvsf.managementsystem.models.task.ServiceCategory;
import com.evertonvsf.managementsystem.models.task.ServiceOrder;
import com.evertonvsf.managementsystem.models.task.Status;
import com.evertonvsf.managementsystem.models.users.Technician;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UpdateOrderController {

    @FXML
    private Button cancelButton;

    @FXML
    private Button saveButton;

    @FXML
    private ChoiceBox<Status> statusChoices;

    @FXML
    private void initialize(){
        this.statusChoices.getItems().addAll(Status.values());
        this.statusChoices.setValue(ServiceOrdersController.selectedOrder.getStatus());
        if (ServiceOrdersController.selectedOrder.getStatus() == Status.INITIALIZED){
            this.statusChoices.getItems().remove(Status.WAITING);
        }
        if (ServiceOrdersController.selectedOrder.getStatus() == Status.WAITING){
            this.statusChoices.getItems().remove(Status.INITIALIZED);
            this.statusChoices.getItems().remove(Status.FINISHED);
        }
    }
    @FXML
    void cancel() throws IOException {
        Stage stage = (Stage) this.cancelButton.getScene().getWindow();
        MainController.changePanel(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/serviceOrders.fxml"))));
        stage.close();
    }

    @FXML
    void save(ActionEvent event) throws IOException {
        ServiceOrder serviceOrder = DAO.fromServiceOrder().findById(ServiceOrdersController.selectedOrder.getId());
        Technician technician = DAO.fromTechnician().findByUsername(serviceOrder.getTechnicianUsername());
        serviceOrder.setStatus(this.statusChoices.getValue());
        List<Service> services = new ArrayList<>();
        for (Integer serviceId : serviceOrder.getServicesIds()){
            services.add(DAO.fromService().findById(serviceId));
        }

        for (Service service : services){
            if (service.getStatus() != Status.FINISHED && service.getStatus() != Status.CANCELED){
                service.setStatus(this.statusChoices.getValue());
                DAO.fromService().update(service);
            }
        }
        if (serviceOrder.getStatus() == Status.FINISHED){
            technician.setActualOrderId(-1);
            createInvoice();
        }
        if (serviceOrder.getStatus() == Status.CANCELED){
            technician.setActualOrderId(-1);
        }
        DAO.fromServiceOrder().update(serviceOrder);
        DAO.fromTechnician().update(technician);
        MainController.saveInfo();
        MainController.loadInfo();
        MainController.loggedTechnician = DAO.fromTechnician().findByUsername(MainController.loggedTechnician.getUsername());
        cancel();
    }
    private void createInvoice(){
        List<Service> services = new ArrayList<>();

        for (Integer serviceId : ServiceOrdersController.selectedOrder.getServicesIds()){
            services.add(DAO.fromService().findById(serviceId));
        }
        Double totalPrice = 0.0;
        for (Service service : services){
            totalPrice += service.getPrice();
        }


        ServiceOrdersController.selectedOrder.setInvoiceId(DAO.fromInvoice().create(new Invoice(ServiceOrdersController.selectedOrder.getId(), totalPrice)).getId());
    }
}
