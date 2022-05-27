package ihm;

import dao.UtilisateurDAO;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.io.IOException;

public class recuperationController {
    Main main = new Main();

    @FXML
    void sendLoggin(MouseEvent event) throws IOException {
        main.nextScene("loggin-view.fxml");
    }

    @FXML
    private Label errorLogin;
    @FXML
    private TextField identifiant;
    @FXML
    private PasswordField newPassword;
    @FXML
    private PasswordField confirmationNewPassword;
    @FXML
    private TextField reponse;
    @FXML
    private Label mdpIdentique;

    private boolean isNewMotDePasseConfirmed() {
        boolean mdpConfirmed = true;
        if (!newPassword.getText().equals(confirmationNewPassword.getText())) {
            mdpConfirmed = false;
            mdpIdentique.setText("Les mots de passe ne sont pas identiques");
        } else {
            mdpIdentique.setText("");
        }
        return mdpConfirmed;
    }

    @FXML
    void sendForm(ActionEvent event) {
        String usernameSent = identifiant.getText();
        String passwordSent = newPassword.getText();
        String reponseSecretDatabase = UtilisateurDAO.getInstance().getWithEmail("question_secrete", usernameSent);
        if (isNewMotDePasseConfirmed() && reponse.getText().equals(reponseSecretDatabase)) {
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
