module com.example.staggers {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.staggers to javafx.fxml;
    exports com.example.staggers;
}