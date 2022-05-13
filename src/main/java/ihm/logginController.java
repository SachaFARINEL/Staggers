package ihm;

import dao.UtilisateurDAO;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
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
    public void buttonPressed(KeyEvent e) throws NoSuchAlgorithmException, InvalidKeySpecException, IOException {
        if (e.getCode().toString().equals("ENTER")) {
            checkLogin();
        }
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

        if (usernameSent.isEmpty() || passwordSent.isEmpty()) {
            errorLogin.setText("Veuillez remplir les champs vides");
        } else {

            String passwordInDatabase = UtilisateurDAO.getInstance().getWithEmail("mot_de_passe", usernameSent);
            //Gérer le mot de passe incorrect.
            if (passwordInDatabase != null) {
                if (isPasswordCorrect(passwordSent, passwordInDatabase)) {
                    errorLogin.setStyle("-fx-text-fill: #20DF7F;");
                    errorLogin.setText("Authentification réussie !");
                    Timeline timeline = new Timeline(new KeyFrame(
                            Duration.millis(1000),
                            ae -> {
                                try {
                                    main.nextScene("accueil-view.fxml");
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }));
                    timeline.play();
                } else {
                    errorLogin.setText("Mot de passe incorrect");
                }
            } else {
                errorLogin.setText("Identifiant incorrect");
            }
        }
    }

}