package com.evertonvsf.managementsystem.controllers;

import com.evertonvsf.managementsystem.controllers.clients.ClientsController;
import com.evertonvsf.managementsystem.controllers.utils.MainController;
import com.evertonvsf.managementsystem.dao.DAO;
import com.evertonvsf.managementsystem.models.money.Invoice;
import com.evertonvsf.managementsystem.models.task.ServiceOrder;
import com.evertonvsf.managementsystem.models.task.Status;
import com.evertonvsf.managementsystem.models.users.Client;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;

public class InvoicesController {

    @FXML
    private Label feedbackLabel;

    @FXML
    private TableView<Invoice> invoiceTable;

    @FXML
    private TableColumn<Invoice, Integer> idColumn;


    @FXML
    private TableColumn<Invoice, Double> paidValue;

    @FXML
    private TableColumn<Invoice, Double> totalValue;

    @FXML
    private AnchorPane workWindow1;

    public static Integer selectedInvoiceId;
    @FXML
    private void initialize(){
        selectedInvoiceId = -1;
        initializeTable();
    }

    @FXML
    void newPayment(ActionEvent event) throws IOException {
        if (selectedInvoiceId != -1) {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/newPayment.fxml")));
            MainController.popUp(root);
        }
        else {
            this.feedbackLabel.setText("selecione uma fatura!");
        }
    }

    private void initializeTable(){
        this.paidValue.setCellValueFactory(new PropertyValueFactory<>("paidValue"));
        this.idColumn.setCellValueFactory(new PropertyValueFactory<>("ServiceOrderId"));
        this.totalValue.setCellValueFactory(new PropertyValueFactory<>("totalValue"));

        this.invoiceTable.onMouseClickedProperty().setValue(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (invoiceTable.getSelectionModel().getSelectedItem() != null) {
                    InvoicesController.selectedInvoiceId = invoiceTable.getSelectionModel().getSelectedItem().getId();
                }
            }
        });

        invoiceTable.getItems().addAll(DAO.fromInvoice().findMany());
    }


}
