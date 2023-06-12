package com.evertonvsf.managementsystem.controllers;

import com.evertonvsf.managementsystem.dao.DAO;
import com.evertonvsf.managementsystem.models.users.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.util.converter.LongStringConverter;

import java.io.IOException;
import java.util.Objects;

public class ClientsController extends MenuController{

    public static int actualClient;

    @FXML
    private TextField searchBox;

    @FXML
    private Label usernameLabel;

    @FXML
    private Label feedbackLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Label addressLabel;

    @FXML
    private Label phoneLabel;

    @FXML
    private Label cpfLabel;

    @FXML
    private TableView<Client> clientsTable;

    @FXML
    private TableColumn<Client, String> nameColumn;

    @FXML
    private TableColumn<Client, String> addressColumn;

    @FXML
    private TableColumn<Client, String> phoneColumn;

    @FXML
    private TableColumn<Client, String> cpfColumn;

    private final ObservableList<Client> clientsObservable = FXCollections.observableArrayList();
    @FXML
    private void initialize(){
        clientsObservable.addAll(DAO.fromClient().findMany());
        ClientsController.actualClient = -1;
        MenuController.showUser(usernameLabel);
        this.feedbackLabel.setAlignment(Pos.BASELINE_CENTER);

        initializeTable();
        initializeSearch();

    }
    @FXML
    private void gotoRegister() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/clients_register.fxml")));
        MainController.popUp(root);

    }

    @FXML
    private void gotoEdit() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/clients_edit.fxml")));
        MainController.popUp(root);
    }

    @FXML
    private void deleteClient(){
        boolean response = DAO.fromClient().deleteById(ClientsController.actualClient);
        if ( response ){
            feedbackLabel.setTextFill(Color.GREEN);
            feedbackLabel.setText("Cliente deletado com sucesso!");
            clientsObservable.removeIf(client -> client.getId() == ClientsController.actualClient);
            showClient(null);
            ClientsController.actualClient = -1;

        }
        else {
            feedbackLabel.setTextFill(Color.RED);
            feedbackLabel.setText("Cliente não encontrado!");
        }
    }



    public void initializeTable(){

        this.nameColumn.setCellValueFactory(new PropertyValueFactory<Client, String>("name"));
        this.addressColumn.setCellValueFactory(new PropertyValueFactory<Client, String>("address"));
        this.phoneColumn.setCellValueFactory(new PropertyValueFactory<Client, String>("phoneNumber"));
        this.cpfColumn.setCellValueFactory(new PropertyValueFactory<Client, String>("CPF"));

        this.nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.addressColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.phoneColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.cpfColumn.setCellFactory(TextFieldTableCell.forTableColumn());



        this.clientsTable.onMouseClickedProperty().setValue(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (clientsTable.getSelectionModel().getSelectedItem() != null) {
                    Client client = clientsTable.getSelectionModel().getSelectedItem();
                    ClientsController.actualClient = client.getId();
                    showClient(client);
                }
            }
        });

    }


    private void showClient(Client client){
        if (client != null) {
            this.nameLabel.setText(client.getName());
            this.addressLabel.setText(client.getAddress());
            this.phoneLabel.setText(client.getPhoneNumber());
            this.cpfLabel.setText(client.getCPF());
        }
        else {
            this.nameLabel.setText("Nome");
            this.addressLabel.setText("Endereço");
            this.phoneLabel.setText("Telefone");
            this.cpfLabel.setText("CPF");
        }

    }
    private void initializeSearch(){
        FilteredList<Client> filteredClientList = new FilteredList<Client>(clientsObservable, b -> true);

        this.searchBox.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredClientList.setPredicate(client -> {

                if ( newValue == null || newValue.isEmpty() ){
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if ( client.getName().toLowerCase().contains(lowerCaseFilter) ){
                    return true;
                }
                else if ( client.getAddress().toLowerCase().contains(lowerCaseFilter) ){
                    return true;
                }
                else if ( client.getCPF().contains(lowerCaseFilter) ){
                    return true;
                }
                else return client.getPhoneNumber().contains(lowerCaseFilter);

            });

        });
        SortedList<Client> sortedClientList = new SortedList<Client>(filteredClientList);

        sortedClientList.comparatorProperty().bind(clientsTable.comparatorProperty());

        clientsTable.setItems(sortedClientList);
    }


}
