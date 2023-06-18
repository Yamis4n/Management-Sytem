package com.evertonvsf.managementsystem.controllers.stock;


import com.evertonvsf.managementsystem.controllers.utils.MainController;
import com.evertonvsf.managementsystem.dao.DAO;
import com.evertonvsf.managementsystem.models.stock.BuyOrder;
import com.evertonvsf.managementsystem.models.stock.Component;
import com.evertonvsf.managementsystem.models.stock.ComponentType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


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
    private Label titleLabel;

    @FXML
    private AnchorPane workWindow;

    @FXML
    private ChoiceBox<ComponentType> typeField;

    @FXML
    private void initialize(){
        titleLabel.setAlignment(Pos.BASELINE_CENTER);
        titleLabel.setText("Ordem de Compra");
        typeField.getItems().addAll(ComponentType.values());
        typeField.onActionProperty().setValue(actionEvent -> {
            this.descriptionField.setText("Sem descrição");
            if (typeField.getValue() == ComponentType.OTHER){
                this.descriptionField.setDisable(false);
                this.descriptionField.setText("");
            }
        });

    }

    @FXML
    private void cancel() throws IOException {
        Stage stage = (Stage) this.workWindow.getScene().getWindow();
        MainController.changePanel( FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/stock.fxml"))));
        stage.close();

    }

    @FXML
    private void save() throws IOException{
        if (validate()){
            int qnt = Integer.parseInt(this.qntField.getText());
            double buyPrice = Double.parseDouble(this.buyPriceField.getText());
            String description = this.descriptionField.getText();
            ComponentType type = this.typeField.getValue();
            Component component = DAO.fromComponent().findByComponent(description, type);
            if (component == null){
                component = DAO.fromComponent().create(new Component(0, buyPrice, description, type));
            }
            DAO.fromBuyOrder().create(new BuyOrder(MainController.loggedTechnician.getUsername(), component.getId(), qnt, type.getName(), buyPrice));
            MainController.saveInfo();
            MainController.loadInfo();
            cancel();
        }

    }


    private boolean validate() {
        if (this.typeField.getValue() == null || this.qntField.getText().length() == 0 ||
        this.buyPriceField.getText().length() == 0 || this.descriptionField.getText().length() == 0){
            this.feedbackLabel.setText("DADOS INCOMPLETOS!");
            return false;
        }
        try {
            Integer.parseInt(this.qntField.getText());
            Double.parseDouble(this.buyPriceField.getText());
        }
        catch (Exception e){
            this.feedbackLabel.setText("DADOS INVÁLIDOS!");
            return false;
        }
        return true;
    }
}
