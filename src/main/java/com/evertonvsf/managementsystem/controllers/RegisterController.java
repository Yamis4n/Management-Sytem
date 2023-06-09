package com.evertonvsf.managementsystem.controllers;

import com.evertonvsf.managementsystem.dao.DAO;
import com.evertonvsf.managementsystem.models.users.Technician;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.util.Date;
import java.util.Objects;

public class RegisterController {

    @FXML
    private AnchorPane window;

    @FXML
    private TextField nameField;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField passwordConfirmationField;

    @FXML
    private Button registerButton;

    @FXML
    private Button goToLoginButton;

    @FXML
    private Label feedbackInfo;

    @FXML
    private void goToLogin() throws IOException {
        Parent loginView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/login.fxml")));
        MainController.stage.setScene(new Scene(loginView));
    }


    private boolean validateInfo(String name, String username, String password, String passwordConfirmation){
        Technician newTechnician = DAO.fromTechnician().findByUsername(username);

        if ( name.length() == 0 || username.length() == 0 || password.length() == 0 || passwordConfirmation.length() == 0 ){
            feedbackInfo.setText("Dados incompletos!");
            feedbackInfo.setTextFill(Color.RED);
            return false;
        }

        if ( !Objects.equals(password, passwordConfirmation) ){
            feedbackInfo.setText("As senhas não são iguais!");
            feedbackInfo.setTextFill(Color.RED);
            return false;
        }

        if ( newTechnician != null ){
            feedbackInfo.setText("Técnico já cadastrado!");
            feedbackInfo.setTextFill(Color.RED);
            return false;
        }

        feedbackInfo.setText("Cadastro Efetuado!");
        feedbackInfo.setTextFill(Color.GREEN);

        return true;

    }

    @FXML
    private void register() throws IOException, InterruptedException {
        String name = nameField.getText();
        String username = usernameField.getText();
        String password = passwordField.getText();
        String passwordConfirmation = passwordConfirmationField.getText();

        boolean dataIsValid = validateInfo(name, username, password, passwordConfirmation);

        if ( dataIsValid ){

            DAO.fromTechnician().create(new Technician(name, password, username));

        }
    }
}
