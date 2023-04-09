module com.evertonvsf.managementsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires commons.validator;


    opens com.evertonvsf.managementsystem to javafx.fxml;
    exports com.evertonvsf.managementsystem;
}