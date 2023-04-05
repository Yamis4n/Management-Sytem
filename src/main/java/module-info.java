module com.evertonvsf.managementsystem {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.evertonvsf.managementsystem to javafx.fxml;
    exports com.evertonvsf.managementsystem;
}