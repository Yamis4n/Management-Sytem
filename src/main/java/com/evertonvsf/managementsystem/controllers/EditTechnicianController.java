package com.evertonvsf.managementsystem.controllers;

import com.evertonvsf.managementsystem.dao.DAO;
import com.evertonvsf.managementsystem.models.users.Technician;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.Objects;

public class EditTechnicianController {

    @FXML
    private AnchorPane window;

    @FXML
    private Label feedbackLabel;

    @FXML
    private TextField newUserField;

    @FXML
    private TextField newNameField;

    @FXML
    private TextField newPasswordField;

    @FXML
    private Button saveButton;

    @FXML
    private Button cancelButton;

    @FXML
    private void initialize(){

        feedbackLabel.setAlignment(Pos.BASELINE_CENTER);
        feedbackLabel.setTextFill(Color.RED);

        if ( DataController.techId == -1 ) {
            feedbackLabel.setText("Selecione um Técnico!");

            newUserField.setEditable(false);
            newNameField.setEditable(false);
            newPasswordField.setEditable(false);

            saveButton.setDisable(true);
        }
        else {
            newUserField.setText(DAO.fromTechnician().findById(DataController.techId).getUsername());
            newNameField.setText(DAO.fromTechnician().findById(DataController.techId).getName());
        }

        if (Objects.equals(DataController.techId, DAO.fromTechnician().findByUsername("admin").getId())){
            newUserField.setEditable(false);
        }

    }

    @FXML
    private void save() throws IOException {
        Technician technician = DAO.fromTechnician().findById(DataController.techId);

        if (newPasswordField.getLength() == 0 && newNameField.getLength() == 0 && newUserField.getLength() == 0){
            feedbackLabel.setText("Nenhuma alteração!");
            return;
        }

        if (technician == null){
            feedbackLabel.setText("Técnico não encontrado!");
            feedbackLabel.setText(DataController.techId.toString());

            return;
        }

        if ( newPasswordField.getLength() != 0 || newNameField.getLength() == 0 || newUserField.getLength() == 0){

            if ( newUserField.getLength() != 0 ) {
                String newUsername = newUserField.getText();
                if (DAO.fromTechnician().findByUsername(newUsername) == null) {
                    technician.setUsername(newUsername);
                }
                else {
                    feedbackLabel.setText("Usuário já existe!");
                    return;
                }
            }

            if (newPasswordField.getLength() != 0) {
                technician.setPassword(newPasswordField.getText());
            }
            if ( newNameField.getLength() != 0 ){
                technician.setName(newNameField.getText());
            }

            MainController.saveInfo();
            MainController.loadInfo();
            this.cancel();
        }



    }

    @FXML
    private void cancel() throws IOException {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        MainController.STAGE.setScene(new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/data.fxml")))));
        MainController.STAGE.show();
        stage.close();
    }
}
