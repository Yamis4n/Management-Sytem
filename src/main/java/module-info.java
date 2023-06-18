module com.evertonvsf.managementsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires commons.validator;


    opens com.evertonvsf.managementsystem to javafx.fxml;
    exports com.evertonvsf.managementsystem;

    exports com.evertonvsf.managementsystem.controllers;
    opens com.evertonvsf.managementsystem.controllers to javafx.fxml;

    exports com.evertonvsf.managementsystem.models.users;
    opens com.evertonvsf.managementsystem.models.users to javafx.fxml;

    exports com.evertonvsf.managementsystem.models.task;
    opens com.evertonvsf.managementsystem.models.task to javafx.fxml;

    exports com.evertonvsf.managementsystem.models.stock;
    opens com.evertonvsf.managementsystem.models.stock to javafx.fxml;

    exports com.evertonvsf.managementsystem.models.money;
    opens com.evertonvsf.managementsystem.models.money to javafx.fxml;
    exports com.evertonvsf.managementsystem.controllers.clients;
    opens com.evertonvsf.managementsystem.controllers.clients to javafx.fxml;
    exports com.evertonvsf.managementsystem.controllers.technicians;
    opens com.evertonvsf.managementsystem.controllers.technicians to javafx.fxml;
    exports com.evertonvsf.managementsystem.controllers.stock;
    opens com.evertonvsf.managementsystem.controllers.stock to javafx.fxml;
    exports com.evertonvsf.managementsystem.controllers.utils;
    opens com.evertonvsf.managementsystem.controllers.utils to javafx.fxml;
    exports com.evertonvsf.managementsystem.controllers.tasks;
    opens com.evertonvsf.managementsystem.controllers.tasks to javafx.fxml;

}