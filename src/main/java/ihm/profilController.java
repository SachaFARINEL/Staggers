package ihm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class profilController implements Initializable {

        private final String[] arraySexe = {"Monsieur", "Madame", "Autre"};

        Main main = new Main();

        @FXML private Label admin;
        @FXML private Label wrongEmail;
        @FXML private Label wrongPassword;
        @FXML private TextField numero;
        @FXML private AnchorPane retourLoggin;
        @FXML private DatePicker dateNaissance;
        @FXML private Label wrongNom;
        @FXML private ImageView retourLogginArrow;
        @FXML private ChoiceBox<String> sexe;
        @FXML private TextField nom;
        @FXML private Label wrongDate;
        @FXML private PasswordField password;
        @FXML private Label wrongCodePostal;
        @FXML private Label wrongAdresse;
        @FXML private Label wrongPrenom;
        @FXML private Label wrongReponse;
        @FXML private TextField prenom;
        @FXML private TextField email;
        @FXML private Button valider;
        @FXML private TextField ville;
        @FXML private Label labelInscription;
        @FXML private TextField telephone;
        @FXML private TextField typeDeVoie;
        @FXML private TextField codePostal;
        @FXML private PasswordField passwordConfirmation;
        @FXML private TextField adresse;
        @FXML private Label wrongVille;
        @FXML private TextField reponseQuestion;
        @FXML private Label wrongTelephone;
        @FXML void retourLoggin(ActionEvent event) {

        }

        @FXML void sendInscription(ActionEvent event) {
        if (password.getText() == "" && passwordConfirmation.getText() == "") {

        } else {

        }
        }

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
            admin.setVisible(logginController.connectedUser.isEst_admin());
            nom.setText(logginController.connectedUser.getNom());
            prenom.setText(logginController.connectedUser.getPrenom());
            email.setText(logginController.connectedUser.getEmail());
            numero.setText(logginController.connectedAdresse.getNumero());
            typeDeVoie.setText(logginController.connectedAdresse.getType_de_voie());
            adresse.setText(logginController.connectedAdresse.getAdresse());
            ville.setText(logginController.connectedAdresse.getVille());
            codePostal.setText(logginController.connectedAdresse.getCode_postal());
            telephone.setText(logginController.connectedUser.getNum_tel());
//            password.setText(logginController.connectedUser.getMot_de_passe());
//            passwordConfirmation.setText(logginController.connectedUser.getMot_de_passe());
            LocalDate dateNaiss = logginController.connectedUser.getDate_naissance().toLocalDate();
            dateNaissance.setValue(dateNaiss);
            sexe.setValue(logginController.connectedUser.getSexe());
            sexe.getItems().addAll(arraySexe);
        }

        @FXML void deconnexion(MouseEvent event) throws IOException {
                main.nextScene("loggin-view.fxml");
        }

        @FXML void versActualite(MouseEvent event) throws IOException {
                main.nextScene("accueil-view.fxml");

        }

        @FXML void versAnnuaire(MouseEvent event) throws IOException {
                main.nextScene("annuaire-view.fxml");

        }

        @FXML void versConseil(MouseEvent event) {

        }

        @FXML void versAdmin(MouseEvent event) throws IOException {
                main.nextScene("panneauAdmin-view.fxml");
        }

        @FXML void versProfil(MouseEvent event) throws IOException {

        }

}


