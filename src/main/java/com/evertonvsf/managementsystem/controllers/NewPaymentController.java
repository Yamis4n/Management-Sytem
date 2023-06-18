package com.evertonvsf.managementsystem.controllers;

import com.evertonvsf.managementsystem.controllers.utils.MainController;
import com.evertonvsf.managementsystem.dao.DAO;
import com.evertonvsf.managementsystem.models.money.Invoice;
import com.evertonvsf.managementsystem.models.money.Payment;
import com.evertonvsf.managementsystem.models.money.PaymentMethod;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class NewPaymentController {


    @FXML
    private Label feedbackLabel;

    @FXML
    private ChoiceBox<PaymentMethod> paymentChoice;

    @FXML
    private TextField valueField;

    @FXML
    private void initialize(){
        paymentChoice.getItems().addAll(PaymentMethod.values());
        paymentChoice.setValue(PaymentMethod.CASH);
        this.valueField.setText(Double.toString(DAO.fromInvoice().findById(InvoicesController.selectedInvoiceId).getTotalValue()));
    }

    @FXML
    void cancel( ) throws IOException {
        Stage stage = (Stage) this.valueField.getScene().getWindow();
        MainController.changePanel(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/invoices.fxml"))));
        stage.close();
    }

    @FXML
    void save(ActionEvent event) throws IOException {
        if (validate()){
            cancel();
        }

    }

    private boolean validate(){
        Invoice invoice = DAO.fromInvoice().findById(InvoicesController.selectedInvoiceId);
        if (this.valueField.getText().length() == 0){
            this.feedbackLabel.setText("Preencha os dados!");
            return false;
        }
        double value = 0.0;
        try {
            value = Double.parseDouble(this.valueField.getText());
        }catch (Exception e){
            this.feedbackLabel.setText("Valor inválido!");
            return false;
        }
        if (invoice.getPaidValue() + value > invoice.getTotalValue()){
            this.feedbackLabel.setText("O valor excedeu o preço total!");
            return false;
        }
        invoice.setPaidValue(invoice.getPaidValue()+ value);
        if (invoice.getPaidValue() == invoice.getTotalValue()){
            DAO.fromServiceOrder().findById(invoice.getServiceOrderId()).setPayed(true);
        }
        DAO.fromInvoice().update(invoice);
        return true;
    }

}
