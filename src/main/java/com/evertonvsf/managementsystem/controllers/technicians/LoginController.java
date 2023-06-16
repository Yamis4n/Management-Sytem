package com.evertonvsf.managementsystem.controllers.technicians;

import com.evertonvsf.managementsystem.controllers.utils.MainController;
import com.evertonvsf.managementsystem.dao.DAO;
import com.evertonvsf.managementsystem.models.users.Technician;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;



import java.io.IOException;
import java.util.Objects;

public class LoginController {

    @FXML
    private AnchorPane window;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Button signUpButton;

    @FXML
    private Label feedbackInfo;


    @FXML
    private void initialize() throws IOException {
        passwordField.onActionProperty().setValue(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    validate();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        usernameField.onActionProperty().setValue(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                passwordField.requestFocus();
            }
        });
        if (DAO.fromTechnician().findByUsername("admin") == null){
            DAO.fromTechnician().create(new Technician("Administrator", "admin", "admin"));
        }
    }
    @FXML
    private void validate() throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();

        Technician foundedTechnician = DAO.fromTechnician().findByUsername(username);

        if ( username.length() == 0 || password.length() == 0 ){
            feedbackInfo.setText("Dados inválidos!");
            feedbackInfo.setTextFill(Color.RED);
            return ;
        }
        else if ( foundedTechnician == null || !Objects.equals(foundedTechnician.getPassword(), password) ){
            feedbackInfo.setText("Usuário ou senha incorretos!");
            feedbackInfo.setTextFill(Color.RED);
            return ;
        }
        else {
            feedbackInfo.setText("Logado!");
        feedbackInfo.setTextFill(Color.GREEN);
            MainController.loggedTechnician = foundedTechnician;
            Parent homeView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/menu.fxml")));

            MainController.STAGE.setScene(new Scene(homeView));
        }
    }

    @FXML
    private void signUp() throws IOException {

        Parent signUpView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/sign_up.fxml")));
        MainController.STAGE.setScene(new Scene(signUpView));

    }
    
}
