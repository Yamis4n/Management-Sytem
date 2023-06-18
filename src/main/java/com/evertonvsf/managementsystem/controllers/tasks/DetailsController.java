package com.evertonvsf.managementsystem.controllers.tasks;

import com.evertonvsf.managementsystem.dao.DAO;
import com.evertonvsf.managementsystem.models.stock.Component;
import com.evertonvsf.managementsystem.models.task.Service;
import com.evertonvsf.managementsystem.models.task.ServiceCategory;
import com.evertonvsf.managementsystem.models.task.ServiceOrder;
import com.evertonvsf.managementsystem.models.task.Status;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.text.Text;
import javafx.util.StringConverter;

import java.util.ArrayList;
import java.util.List;

public class DetailsController {

    @FXML
    private Text clientCpf;

    @FXML
    private Text priceField;

    @FXML
    private Text payedField;

    @FXML
    private TableView<Service> servicesTable;

    @FXML
    private TableColumn<Service, Double> priceColumn;

    @FXML
    private TableColumn<Service, Status> statusColumn;

    @FXML
    private TableColumn<Service, Integer> componentColumn;

    @FXML
    private TableColumn<Service, ServiceCategory> typeColumn;

    @FXML
    private Text statusField;

    @FXML
    private Text techUsernameField;
    private final List<Service> services = new ArrayList<>();
   @FXML
    private void initialize(){
        this.clientCpf.setText(DAO.fromClient().findByCpf(ServiceOrdersController.selectedOrder.getClientCPF()).getCPF());
        if(ServiceOrdersController.selectedOrder.getPayed()) {
            this.payedField.setText("SIM");
        }else {
            this.payedField.setText("NÃO");
        }
        this.statusField.setText(ServiceOrdersController.selectedOrder.getStatus().getStatusName());
        this.techUsernameField.setText(ServiceOrdersController.selectedOrder.getTechnicianUsername());

       for (Integer serviceId : ServiceOrdersController.selectedOrder.getServicesIds()){
           services.add(DAO.fromService().findById(serviceId));
       }
       Double totalPrice = 0.0;
       for (Service service : services){
           totalPrice += service.getPrice();
       }
        this.priceField.setText("R$ "+ totalPrice.toString());

       initializeTable();
   }

   private void initializeTable(){
       this.componentColumn.setCellValueFactory(new PropertyValueFactory<>("componentId"));
       this.priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
       this.statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
       this.typeColumn.setCellValueFactory(new PropertyValueFactory<>("category"));

       this.componentColumn.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Integer>() {
           @Override
           public String toString(Integer integer) {
               if (integer != null) {
                   return DAO.fromComponent().findById( integer).getType().getName();
               }
               return "";
           }

           @Override
           public Integer fromString(String s) {
               return null;
           }
       }));
       servicesTable.getItems().addAll(services);
   }

}
