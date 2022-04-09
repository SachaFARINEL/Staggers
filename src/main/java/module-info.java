module com.example.staggers {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.staggers to javafx.fxml;
    exports com.example.staggers;
}