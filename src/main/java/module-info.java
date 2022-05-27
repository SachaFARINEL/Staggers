module ihm {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens staggers to javafx.base;


    exports ihm;
    opens ihm to javafx.fxml;

}