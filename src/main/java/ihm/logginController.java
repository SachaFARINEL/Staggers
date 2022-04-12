package ihm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class logginController {

    @FXML
    private Button connexion;

    @FXML
    private Label errorLogin;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    @FXML
    void sendForm(ActionEvent event) {
        checkLogin();
    }

    private void checkLogin() {
        Main main = new Main();
    }
}