package com.evertonvsf.managementsystem.controllers.technicians;


import com.evertonvsf.managementsystem.controllers.utils.MainController;
import com.evertonvsf.managementsystem.controllers.utils.MenuController;
import com.evertonvsf.managementsystem.dao.DAO;
import com.evertonvsf.managementsystem.models.users.Technician;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
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



    @FXML
    private void initialize(){



        DataController.selectedTechnician = null;



        createTechnicianTable();


        for (Technician technician : DAO.fromTechnician().findMany()){
            techniciansTable.getItems().add(technician);
        }


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

            }
        });

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
        MainController.popUp(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/editTechnician.fxml"))));


    }


}
