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
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;
import java.util.*;


public class DataController extends MenuController {

    public static Integer techId;

    @FXML
    private BorderPane workWindow;

    @FXML
    private Label usernameLabel;


    @FXML
    private void initialize(){



        DataController.techId = -1;

        MenuController.showUser(usernameLabel);

        TableView<Technician> technicianTable = createTechnicianTable();


        for (Technician technician : DAO.fromTechnician().findMany()){
            technicianTable.getItems().add(technician);
        }

        if (Objects.equals(MainController.loggedTechnician.getId(), DAO.fromTechnician().findByUsername("admin").getId())) {
            workWindow.setTop(createTopBar());
        }
        workWindow.setCenter(technicianTable);


    }

    public void getTechnicianId(Technician technician){
        DataController.techId = technician.getId();
    }
    public BorderPane createTopBar(){
            BorderPane topBar = new BorderPane();
            Button editButton = new Button("EDITAR");
            Button removeButton = new Button("REMOVER");
            Label feedbackLabel = new Label();

            topBar.setCenter(feedbackLabel);
            topBar.setRight(removeButton);
            topBar.setLeft(editButton);


            feedbackLabel.setTextFill(Color.RED);
            feedbackLabel.setAlignment(Pos.BASELINE_CENTER);
            feedbackLabel.fontProperty().setValue(Font.font("Open Sans Extrabold"));

            // Styling removeButton:
            removeButton.backgroundProperty().setValue(Background.fill(Color.CORAL));
            removeButton.autosize();

            // add function to removeButton:
            removeButton.onActionProperty().setValue(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    deleteTechnician(feedbackLabel);
                }
            });

            // Styling editButton:
            editButton.backgroundProperty().setValue(Background.fill(Color.YELLOW));
            editButton.autosize();

            // add function to editButton:
            editButton.onActionProperty().setValue(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    try {
                        editTechnician();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });

            return topBar;


    }

    public TableView<Technician> createTechnicianTable() {

        TableView<Technician> technicianTable = new TableView<Technician>();
        technicianTable.idProperty().setValue("technicianTable");
        technicianTable.setEditable(false);

        TableColumn<Technician, Integer> idColumn = new TableColumn<Technician, Integer>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<Technician, Integer>("Id"));
        idColumn.setCellFactory(TextFieldTableCell.forTableColumn( new IntegerStringConverter() ));
        idColumn.idProperty().setValue("idColumn");
        idColumn.setStyle("-fx-alignment: CENTER;");

        TableColumn<Technician, String> nameColumn = new TableColumn<Technician, String>("NOME");
        nameColumn.setCellValueFactory(new PropertyValueFactory<Technician, String>("name"));
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nameColumn.idProperty().setValue("nameColumn");
        nameColumn.setStyle("-fx-alignment: CENTER;");

        TableColumn<Technician, String> usernameColumn = new TableColumn<Technician, String>("USERNAME");
        usernameColumn.setCellValueFactory(new PropertyValueFactory<Technician, String>("username"));
        usernameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        usernameColumn.idProperty().setValue("usernameColumn");
        usernameColumn.setStyle("-fx-alignment: CENTER;");

        TableColumn<Technician, Integer> orderColumn = new TableColumn<Technician, Integer>("ORDEM ATUAL");
        orderColumn.setCellValueFactory(new PropertyValueFactory<Technician, Integer>("actualOrderId"));
        orderColumn.setCellFactory(TextFieldTableCell.forTableColumn( new IntegerStringConverter() ));
        orderColumn.idProperty().setValue("orderColumn");
        orderColumn.setStyle("-fx-alignment: CENTER;");


        technicianTable.getColumns().add(idColumn);
        technicianTable.getColumns().add(nameColumn);
        technicianTable.getColumns().add(usernameColumn);
        technicianTable.getColumns().add(orderColumn);
        technicianTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        technicianTable.onMouseClickedProperty().setValue(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                getTechnicianId(technicianTable.getSelectionModel().getSelectedItem());

            }
        });

        return technicianTable;
    }

    public void deleteTechnician(Label feedbackLabel){
        int adminId = DAO.fromTechnician().findByUsername("admin").getId();

        if (MainController.loggedTechnician.getId() != adminId){
            feedbackLabel.setText("Você não tem permissão para isso!");
            return;
        }

        if (DataController.techId == adminId){
            feedbackLabel.setText("Impossível apagar!");
            return;
        }

        DAO.fromTechnician().deleteById(DataController.techId);
        initialize();
        feedbackLabel.setText("");


    }

    public void editTechnician() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/editTechnician.fxml")));

        MainController.popUp(root);


    }


}
