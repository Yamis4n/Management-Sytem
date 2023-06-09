package com.evertonvsf.managementsystem;

import com.evertonvsf.managementsystem.controllers.MainController;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.util.Objects;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/login.fxml")));
        Scene loginScene = new Scene(root);

        stage.setResizable(false);
        stage.setScene(loginScene);
        stage.show();
        MainController.stage = stage;

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                MainController.saveInfo();
            }
        });

    }

}
