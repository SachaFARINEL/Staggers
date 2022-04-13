package ihm;

import dao.UtilisateurDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import static utils.Utils.isPasswordCorrect;

public class logginController {

    @FXML
    private Button connexion;

    @FXML
    private Label createAccount;

    @FXML
    private Label errorLogin;

    @FXML
    private Label forgotPassword;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    @FXML
    void sendForgotPassword(MouseEvent event) throws IOException {
        Main main = new Main();
        main.nextScene("recuperation-view.fxml");
    }

    @FXML
    void sendForm(ActionEvent event) throws NoSuchAlgorithmException, InvalidKeySpecException, IOException {
        checkLogin();
    }

    @FXML
    void sendInscription(MouseEvent event) throws IOException {
        Main main = new Main();
        main.nextScene("inscription-view.fxml");
    }

    private void checkLogin() throws NoSuchAlgorithmException, InvalidKeySpecException, IOException {
        Main main = new Main();
        String usernameSent = username.getText().toString();
        String passwordSent = password.getText().toString();
        String passwordInDatabase = UtilisateurDAO.getInstance().getWithEmail("mot_de_passe", usernameSent);
        if (isPasswordCorrect(passwordSent, passwordInDatabase)) {
            errorLogin.setText("Authentification réussie !");
            main.nextScene("accueil-view.fxml");
        } else {
            errorLogin.setText("Identifiant/Mot de passe incorrect !");
        }

    }
}