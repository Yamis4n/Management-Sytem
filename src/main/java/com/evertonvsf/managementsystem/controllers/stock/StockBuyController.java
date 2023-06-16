package com.evertonvsf.managementsystem.controllers.stock;


import com.evertonvsf.managementsystem.controllers.utils.MainController;
import com.evertonvsf.managementsystem.models.stock.ComponentType;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class StockBuyController {

    @FXML
    private TextField buyPriceField;

    @FXML
    private TextField descriptionField;

    @FXML
    private Label feedbackLabel;

    @FXML
    private TextField qntField;

    @FXML
    private TextField sellPriceField;

    @FXML
    private Label titleLabel;

    @FXML
    private Button cancelButton;

    @FXML
    private ChoiceBox<ComponentType> typeField;

    @FXML
    private void initialize(){
        titleLabel.setAlignment(Pos.BASELINE_CENTER);
        titleLabel.setText("Ordem de Compra");
        typeField.getItems().addAll(ComponentType.values());
        typeField.onActionProperty().setValue(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String price = "0.00";
                String description = "Sem descrição";
                switch (typeField.getValue()){
                    case HD_SSD, POWER_SUPPLY -> price = "30.00";
                    case RAM -> price = "20.00";
                    case MOTHERBOARD, VIDEO_CARD -> price = "100.00";
                    case default -> {
                        sellPriceField.setDisable(false);
                        descriptionField.setDisable(false);
                        description = "";
                    }
                }
                sellPriceField.setText(price);
                descriptionField.setText(description);
            }
        });

    }

    @FXML
    private void cancel() throws IOException {
        Stage stage = (Stage) this.cancelButton.getScene().getWindow();
        MainController.closePopUp(stage, "/views/stock.fxml");
    }

    @FXML
    private void save() throws IOException{
        if (validate()){
            System.out.println("---");
        }
        cancel();
    }


    private boolean validate() {
        return true;
    }
}
