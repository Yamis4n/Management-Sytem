package com.evertonvsf.managementsystem.controllers.clients;

import com.evertonvsf.managementsystem.controllers.utils.MainController;
import com.evertonvsf.managementsystem.dao.DAO;
import com.evertonvsf.managementsystem.models.users.Client;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ClientsEditController {

    @FXML
    public TextField nameField;

    @FXML
    public Button saveButton;

    @FXML
    public Button cancelButton;

    @FXML
    public TextField addressField;

    @FXML
    public TextField phoneField;

    @FXML
    public TextField cpfField;

    @FXML
    public Label feedbackLabel;

    @FXML
    public Label titleLabel;

    private static Client clientToUpdate;

    @FXML
    private void initialize(){

        setOnActionProperties();

        feedbackLabel.setAlignment(Pos.BASELINE_CENTER);
        feedbackLabel.setTextFill(Color.RED);
        titleLabel.setAlignment(Pos.BASELINE_CENTER);
        titleLabel.setText("EDITAR");

        clientToUpdate = DAO.fromClient().findById(ClientsController.actualClient);


        if (clientToUpdate != null) {
            this.nameField.setText(clientToUpdate.getName());
            this.addressField.setText(clientToUpdate.getAddress());
            this.phoneField.setText(clientToUpdate.getPhoneNumber());
            this.cpfField.setText(clientToUpdate.getCPF());
        }
        else{
            this.cancelButton.setText("VOLTAR");
            this.saveButton.setDisable(true);
            this.nameField.setDisable(true);
            this.addressField.setDisable(true);
            this.phoneField.setDisable(true);
            this.cpfField.setDisable(true);
            this.feedbackLabel.setText("Nenhum cliente foi selecionado!");
        }




    }

    public void setOnActionProperties(){
        this.nameField.onActionProperty().setValue(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                addressField.requestFocus();
            }
        });
        this.addressField.onActionProperty().setValue(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                phoneField.requestFocus();
            }
        });
        this.phoneField.onActionProperty().setValue(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                cpfField.requestFocus();
            }
        });

    }

    @FXML
    private void saveClient() throws IOException {


        if ( validateInfo( this.nameField.getText(), this.addressField.getText(), this.phoneField.getText(), this.cpfField.getText() ) ){

            clientToUpdate.setName(this.nameField.getText());
            clientToUpdate.setAddress(this.addressField.getText());
            clientToUpdate.setPhoneNumber(this.phoneField.getText());
            clientToUpdate.setCPF(this.cpfField.getText());

            DAO.fromClient().update( clientToUpdate );
            MainController.saveInfo();
            MainController.loadInfo();
            this.cancel();
        }


    }

    @FXML
    private void cancel() throws IOException {
        Stage stage = (Stage) this.cancelButton.getScene().getWindow();
        MainController.changePanel(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/clients.fxml"))));
        stage.close();
    }

    public boolean validateInfo( String name, String address, String phone, String cpf) {
        if ( name.length() == 0 || address.length() == 0 ||
                phone.length() == 0 || cpf.length() == 0){

            feedbackLabel.setText("Preencha todos os campos!");
            return false;
        }
        if (cpf.length() != 11 ){
            feedbackLabel.setText("CPF inválido!");
            return false;
        }
        if  ( phone.length() > 11 || phone.length() < 8){
            feedbackLabel.setText("telefone inválido!");
        }
        long phoneLong, cpfLong;

        try {
            phoneLong = Long.parseLong(this.phoneField.getText());
        }
        catch (Exception e) {
            feedbackLabel.setText("Telefone inválido!");
            return false;
        }

        try {
            cpfLong = Long.parseLong(this.cpfField.getText());
        }
        catch (Exception e) {
            feedbackLabel.setText("CPF inválido!");
            return false;
        }
        if ( DAO.fromClient().findByCpf(cpf) != null && DAO.fromClient().findByCpf(cpf).getId() != DAO.fromClient().findById(ClientsController.actualClient).getId()) {
            feedbackLabel.setText("Este Cliente já existe!");
            return false;
        }
        return true;
    }
}
