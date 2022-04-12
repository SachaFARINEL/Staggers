module ihm {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    exports ihm;
    opens ihm to javafx.fxml;

}