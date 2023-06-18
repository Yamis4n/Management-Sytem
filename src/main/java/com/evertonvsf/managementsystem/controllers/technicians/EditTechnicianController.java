package com.evertonvsf.managementsystem.controllers.technicians;

import com.evertonvsf.managementsystem.controllers.utils.MainController;
import com.evertonvsf.managementsystem.dao.DAO;
import com.evertonvsf.managementsystem.models.users.Technician;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
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
    private PasswordField newPasswordField;

    @FXML
    private Button saveButton;

    @FXML
    private Button cancelButton;

    @FXML
    private void initialize(){

        feedbackLabel.setAlignment(Pos.BASELINE_CENTER);
        feedbackLabel.setTextFill(Color.RED);

        if ( DataController.selectedTechnician == null ) {
            feedbackLabel.setText("Selecione um Técnico!");

            newUserField.setEditable(false);
            newNameField.setEditable(false);
            newPasswordField.setEditable(false);

            saveButton.setDisable(true);
        }
        else {
            newUserField.setText(DataController.selectedTechnician.getUsername());
            newNameField.setText(DataController.selectedTechnician.getName());
            newPasswordField.setText(DataController.selectedTechnician.getPassword());
        }

        if (Objects.equals(DataController.selectedTechnician.getUsername(), "admin")){
            newUserField.setEditable(false);
        }

    }

    @FXML
    private void save() throws IOException {
        Technician technician = DataController.selectedTechnician;

        if (newPasswordField.getLength() == 0 && newNameField.getLength() == 0 && newUserField.getLength() == 0){
            feedbackLabel.setText("Nenhuma alteração!");
            return;
        }

        if (technician == null){
            feedbackLabel.setText("Técnico não encontrado!");
            return;
        }

        if ( newPasswordField.getLength() != 0 || newNameField.getLength() == 0 || newUserField.getLength() == 0){

            if ( newUserField.getLength() != 0 && !Objects.equals(DataController.selectedTechnician.getUsername(), "admin")) {
                String newUsername = newUserField.getText();
                if (!Objects.equals(newUsername, DataController.selectedTechnician.getUsername())) {
                    if (DAO.fromTechnician().findByUsername(newUsername) == null) {
                        technician.setUsername(newUsername);
                    } else {
                        feedbackLabel.setText("Usuário já existe!");
                        return;
                    }
                }
            }

            if (newPasswordField.getLength() != 0) {
                technician.setPassword(newPasswordField.getText());
            }
            if ( newNameField.getLength() != 0 ){
                technician.setName(newNameField.getText());
            }

            DAO.fromTechnician().update(DataController.selectedTechnician);
            MainController.saveInfo();
            MainController.loadInfo();
            this.cancel();
        }



    }

    @FXML
    private void cancel() throws IOException {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        MainController.changePanel(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/data.fxml"))));
        stage.close();
    }
}
