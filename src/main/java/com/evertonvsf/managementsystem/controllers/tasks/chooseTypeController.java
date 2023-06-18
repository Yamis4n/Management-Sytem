package com.evertonvsf.managementsystem.controllers.tasks;

import com.evertonvsf.managementsystem.controllers.utils.MainController;
import com.evertonvsf.managementsystem.dao.DAO;
import com.evertonvsf.managementsystem.models.stock.Component;
import com.evertonvsf.managementsystem.models.stock.ComponentType;
import com.evertonvsf.managementsystem.models.task.Service;
import com.evertonvsf.managementsystem.models.task.ServiceCategory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class chooseTypeController {

    @FXML
    private Button cancelButton;

    @FXML
    private Label feedbackLabel;

    @FXML
    private TextField priceField;

    @FXML
    private Button okButton;

    @FXML
    private ChoiceBox<Component> typeChoice;


    @FXML
    private void initialize(){
        this.okButton.setDisable(true);
        this.typeChoice.getItems().addAll(DAO.fromComponent().findMany());
        this.typeChoice.getItems().removeIf(component -> component.getType() != ComponentType.OTHER);
        this.typeChoice.onActionProperty().setValue(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                okButton.setDisable(typeChoice.getValue() == null);
            }
        });
    }

    @FXML
    private void cancel() throws IOException {
        Stage stage = (Stage) this.cancelButton.getScene().getWindow();
        MainController.changePanel(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/serviceOrders.fxml"))));
        stage.close();
    }

    @FXML
    private void save(ActionEvent event) throws IOException {
        if (validate()) {
            Component component = DAO.fromComponent().findById(this.typeChoice.getValue().getId());
            if (component.getQuantity() > 0) {
                Service service = DAO.fromService().create(new Service(ServiceCategory.MOUNTING_OTHER));
                service.setPrice(Double.parseDouble(this.priceField.getText()));
                service.setComponentId(this.typeChoice.getValue().getId());
                NewServiceController.serviceObservableList.add(service);
                NewServiceController.services.add(service.getId());
                component.setQuantity(component.getQuantity() - 1);
                DAO.fromComponent().update(component);

                cancel();
            }
            else {
                this.feedbackLabel.setText("Não há estoque!");
            }
        }
        else {
            this.feedbackLabel.setText("Dados inválidos!");
        }
    }

    private boolean validate(){
        if (this.priceField.getText().length() == 0 ){
            return false;
        }
        try {
            Double.parseDouble(this.priceField.getText());
        }catch (Exception e){
            return false;
        }
        return true;
    }



}
