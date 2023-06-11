package com.evertonvsf.managementsystem.controllers;

import com.evertonvsf.managementsystem.dao.DAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ClientsController extends MenuController{

    public static int actualClient = -1;

    @FXML
    private Label usernameLabel;

    @FXML
    private Label feedbackLabel;


    @FXML
    private void initialize(){
        MenuController.showUser(usernameLabel);
        this.feedbackLabel.setAlignment(Pos.BASELINE_CENTER);



    }
    @FXML
    private void gotoRegister() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/clients_register.fxml")));
        popUp(root);

    }

    @FXML
    private void gotoEdit() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/clients_edit.fxml")));
        popUp(root);
    }

    @FXML
    private void deleteClient(){
        boolean response = DAO.fromClient().deleteById(ClientsController.actualClient);
        if ( response ){
            feedbackLabel.setTextFill(Color.GREEN);
            feedbackLabel.setText("Cliente deletado com sucesso!");
        }
        else {
            feedbackLabel.setTextFill(Color.RED);
            feedbackLabel.setText("Cliente não encontrado!");
        }
    }

    public void popUp(Parent root){
        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(MainController.stage);
        stage.setScene(new Scene(root));
        stage.setResizable(false);

        stage.show();
    }
}
