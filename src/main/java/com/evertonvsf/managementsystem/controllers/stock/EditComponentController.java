package com.evertonvsf.managementsystem.controllers.stock;

import com.evertonvsf.managementsystem.models.stock.ComponentType;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class EditComponentController {


    @FXML
    public Button cancelButton;

    @FXML
    public Button saveButton;

    @FXML
    public AnchorPane window;

    @FXML
    private Label feedbackLabel;

    @FXML
    private TextField descriptionField;

    @FXML
    private TextField qntField;

    @FXML
    private TextField costField;

    @FXML
    private ChoiceBox<ComponentType> typeChoice;

    @FXML
    private void initialize(){
        this.feedbackLabel.setTextFill(Color.RED);
        this.feedbackLabel.setAlignment(Pos.BASELINE_CENTER);
        if (StockController.selectedComponent == null){
            this.costField.setEditable(false);
            this.descriptionField.setEditable(false);
            this.qntField.setEditable(false);
            this.typeChoice.setDisable(true);
            this.feedbackLabel.setText("Peça não encontrada!");
        }
        else{
            this.descriptionField.setText(StockController.selectedComponent.getComponentDescription());
            this.costField.setText(StockController.selectedComponent.getPrice().toString());
            this.qntField.setText(StockController.selectedComponent.getQuantity().toString());
            initialize_choices();
        }
    }

    @FXML
    private void save(){
        System.out.println("hello");
    }

    @FXML
    private void cancel(){
        System.out.println("hello");
    }

    private void initialize_choices(){

        this.typeChoice.getItems().addAll(ComponentType.values());
        this.typeChoice.setValue(StockController.selectedComponent.getComponent().getType());

    }
}
