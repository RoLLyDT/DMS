module com.vexed.vexed {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens com.comp2059.app to javafx.fxml;
    exports com.comp2059.app;
    exports com.comp2059.app.controllers;
    opens com.comp2059.app.controllers to javafx.fxml;
    exports com.comp2059.app.models;
    opens com.comp2059.app.models to javafx.fxml;
}