package com.evertonvsf.managementsystem.controllers;

import com.evertonvsf.managementsystem.dao.DAO;
import com.evertonvsf.managementsystem.models.users.Client;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;
import java.util.Objects;

public class ClientsController extends MenuController{

    public static int actualClient = -1;

    @FXML
    private Label usernameLabel;

    @FXML
    private Label feedbackLabel;

    @FXML
    private TableView<Client> clientsTable;

    @FXML
    private TableColumn<Client, String> nameColumn;

    @FXML
    private TableColumn<Client, String> addressColumn;

    @FXML
    private TableColumn<Client, String> phoneColumn;

    @FXML
    private TableColumn<Client, Integer> cpfColumn;


    @FXML
    private void initialize(){
        MenuController.showUser(usernameLabel);
        this.feedbackLabel.setAlignment(Pos.BASELINE_CENTER);

        initialize_table();



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

    public void initialize_table(){
        this.nameColumn.setCellValueFactory(new PropertyValueFactory<Client, String>("name"));
        this.addressColumn.setCellValueFactory(new PropertyValueFactory<Client, String>("address"));
        this.phoneColumn.setCellValueFactory(new PropertyValueFactory<Client, String>("phoneNumber"));
        this.cpfColumn.setCellValueFactory(new PropertyValueFactory<Client, Integer>("CPF"));

        this.nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.addressColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.phoneColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.cpfColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        this.nameColumn.setStyle("-fx-alignment: CENTER;");
        this.addressColumn.setStyle("-fx-alignment: CENTER;");
        this.phoneColumn.setStyle("-fx-alignment: CENTER;");
        this.cpfColumn.setStyle("-fx-alignment: CENTER;");

        for ( Client client : DAO.fromClient().findMany()){
            this.clientsTable.getItems().add(client);
        }
    }



}
