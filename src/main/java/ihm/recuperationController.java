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
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.io.IOException;

public class recuperationController {

    @FXML
    void sendLoggin(MouseEvent event) throws IOException {
        Main main = new Main();
        main.nextScene("loggin-view.fxml");
    }

    @FXML
    private Label errorLogin;

    @FXML
    private Label question;

    @FXML
    private TextField identifiant;

    @FXML
    private PasswordField newPassword;

    @FXML
    private PasswordField confirmationNewPassword;

    @FXML
    private TextField reponse;

    @FXML
    private Button valider;

    @FXML
    private Label mdpIdentique;

    private boolean isNewMotDePasseConfirmed() {
        boolean mdpConfirmed = true;
        if (!newPassword.getText().toString().equals(confirmationNewPassword.getText().toString())) {
            mdpConfirmed = false;
            mdpIdentique.setText("Les mots de passe ne sont pas identiques");
        } else {
            mdpIdentique.setText("");
        }
        return mdpConfirmed;
    }

    @FXML
    void sendForm(ActionEvent event) throws IOException {
        Main main = new Main();
        String usernameSent = identifiant.getText().toString();
        String passwordSent = newPassword.getText().toString();
        String reponseSecretDatabase = UtilisateurDAO.getInstance().getWithEmail("question_secrete", usernameSent);
        if (isNewMotDePasseConfirmed() && reponse.getText().toString().equals(reponseSecretDatabase)) {
            errorLogin.setStyle("-fx-text-fill: #20DF7F;");
            errorLogin.setText("Changement de mot de passe réussie ! Retour à l'authentification");
            UtilisateurDAO.getInstance().updatePassword(passwordSent, usernameSent);
            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.millis(1500),
                    ae -> {
                        try {
                            main.nextScene("loggin-view.fxml");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }));
            timeline.play();
        } else {
            errorLogin.setText("Identifiant/Réponse à la question incorrect !");
        }
    }

}
