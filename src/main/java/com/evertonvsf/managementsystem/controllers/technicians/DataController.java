package com.evertonvsf.managementsystem.controllers.technicians;


import com.evertonvsf.managementsystem.controllers.utils.MainController;
import com.evertonvsf.managementsystem.dao.DAO;
import com.evertonvsf.managementsystem.models.users.Technician;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;
import java.util.*;


public class DataController  {

    public static Technician selectedTechnician;

    @FXML
    private TableView<Technician> techniciansTable;

    @FXML
    private TableColumn<Technician, String> nameColumn;

    @FXML
    private TableColumn<Technician, Integer> orderColumn;

    @FXML
    private TableColumn<Technician, String> usernameColumn;

    @FXML
    private TextField searchBox;

    @FXML
    private Label feedbackLabel;

    @FXML
    private Label usernameLabel;

    @FXML
    private Label nameLabel;

    private final ObservableList<Technician> techniciansObservable = FXCollections.observableArrayList();



    @FXML
    private void initialize(){


        techniciansObservable.addAll(DAO.fromTechnician().findMany());
        DataController.selectedTechnician = null;
        createTechnicianTable();
        initializeSearch();

    }
    private void createTechnicianTable() {

        nameColumn.setCellValueFactory(new PropertyValueFactory<Technician, String>("name"));
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nameColumn.setStyle("-fx-alignment: CENTER;");

        usernameColumn.setCellValueFactory(new PropertyValueFactory<Technician, String>("username"));
        usernameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        usernameColumn.setStyle("-fx-alignment: CENTER;");

        orderColumn.setCellValueFactory(new PropertyValueFactory<Technician, Integer>("actualOrderId"));
        orderColumn.setCellFactory(TextFieldTableCell.forTableColumn( new IntegerStringConverter() ));
        orderColumn.setStyle("-fx-alignment: CENTER;");


        techniciansTable.onMouseClickedProperty().setValue(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                selectedTechnician =  techniciansTable.getSelectionModel().getSelectedItem();
                showTech(selectedTechnician);

            }
        });

    }

    private void initializeSearch(){
        FilteredList<Technician> filteredTechnicians = new FilteredList<Technician>(techniciansObservable, b -> true);

        this.searchBox.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredTechnicians.setPredicate(technician -> {

                if ( newValue == null || newValue.isEmpty() ){
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if ( technician.getName().toLowerCase().contains(lowerCaseFilter) ){
                    return true;
                }
                else if ( technician.getUsername().toLowerCase().contains(lowerCaseFilter) ){
                    return true;
                }
                else {
                    return technician.getActualOrderId().toString().contains(lowerCaseFilter);
                }


            });

        });
        SortedList<Technician> sortedTechnicians = new SortedList<Technician>(filteredTechnicians);

        sortedTechnicians.comparatorProperty().bind(this.techniciansTable.comparatorProperty());

        this.techniciansTable.setItems(sortedTechnicians);
    }

    @FXML
    public void deleteTechnician() throws IOException {

        if (!Objects.equals(MainController.loggedTechnician.getUsername(), "admin")){
            this.feedbackLabel.setText("Você não tem permissão para isso!");
            return;
        }

        if (Objects.equals(selectedTechnician.getUsername(), "admin")){
            this.feedbackLabel.setText("Não pode apagar!");
            return;
        }

        if (DAO.fromTechnician().deleteById(DataController.selectedTechnician.getId())) {
            MainController.changePanel(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/data.fxml"))));
        }
        else{
            this.feedbackLabel.setText("Técnico não encontrado!");
        }


    }

    @FXML
    public void editTechnician() throws IOException {
        if (!Objects.equals(selectedTechnician.getUsername(), MainController.loggedTechnician.getUsername()) && !Objects.equals(MainController.loggedTechnician.getUsername(), "admin")){
            this.feedbackLabel.setText("Você não tem permissão para isso!");
            return;
        }
        MainController.popUp(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/editTechnician.fxml"))));


    }

    private void showTech(Technician tech){
        if (tech != null){
            this.nameLabel.setText(tech.getName());
            this.usernameLabel.setText(tech.getUsername());
        }
        else{
            this.usernameLabel.setText("Username");
            this.nameLabel.setText("Nome");
        }
    }


}
