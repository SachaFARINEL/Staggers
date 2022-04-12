package ihm;

import dao.UtilisateurDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import static utils.Utils.isPasswordCorrect;

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
    void sendForm(ActionEvent event) throws NoSuchAlgorithmException, InvalidKeySpecException {
        checkLogin();
    }

    private void getPassword() {


    }

    private void checkLogin() throws NoSuchAlgorithmException, InvalidKeySpecException {
        Main main = new Main();
        String usernameSent = username.getText().toString();
        String passwordSent = password.getText().toString();
        String passwordInDatabase = UtilisateurDAO.getInstance().getPasswordWithEmail(usernameSent);
        if (isPasswordCorrect(passwordSent,passwordInDatabase)) {
            errorLogin.setText("Success !");
        }

    }
}