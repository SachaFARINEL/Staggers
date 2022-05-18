package ihm;

import dao.AdresseDAO;
import dao.EntrepriseDAO;
import dao.UtilisateurDAO;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import staggers.Adresse;
import staggers.Entreprise;
import staggers.Utilisateur;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ResourceBundle;

public class inscriptionController implements Initializable {


    private final String[] arraySexe = {"Monsieur", "Madame", "Autre"};
    Main main = new Main();

    @FXML
    private TextField adresse;

    @FXML
    private TextField codePostal;

    @FXML
    private TextField email;

    @FXML
    private TextField nom;

    @FXML
    private TextField numero;

    @FXML
    private TextField password;

    @FXML
    private DatePicker dateNaissance;

    @FXML
    private TextField reponseQuestion;

    @FXML
    private TextField passwordConfirmation;

    @FXML
    private TextField prenom;

    @FXML
    private ChoiceBox<String> sexe;

    @FXML
    private TextField telephone;

    @FXML
    private TextField typeDeVoie;

    @FXML
    private TextField ville;

    @FXML
    private Label wrongAdresse;

    @FXML
    private Label wrongCodePostal;

    @FXML
    private Label wrongDate;

    @FXML
    private Label wrongEmail;

    @FXML
    private Label wrongNom;

    @FXML
    private Label wrongPassword;

    @FXML
    private Label wrongPrenom;


    @FXML
    private Label wrongReponse;

    @FXML
    private Label wrongTelephone;

    @FXML
    private Label wrongVille;

    @FXML
    private Button valider;

    @FXML
    private Label labelInscription;

    public inscriptionController() throws ParseException {
    }

    @FXML
    void retourLoggin(MouseEvent event) throws IOException {
        Main main = new Main();
        main.nextScene("loggin-view.fxml");
    }


    private boolean checkIfEmpty() {
        boolean isNotEmpty = true;
        String sexeSent = sexe.getValue();
        String nomSent = nom.getText();
        String prenomSent = prenom.getText();
        LocalDate dateNaissanceSent = dateNaissance.getValue();
        String emailSent = email.getText();
        String telephoneSent = telephone.getText();
        String passwordSent = password.getText();
        String confirmationPasswordSent = passwordConfirmation.getText();
        String numeroSent = numero.getText();
        String voieSent = typeDeVoie.getText();
        String adresseSent = adresse.getText();
        String codePostalSent = codePostal.getText();
        String villeSent = ville.getText();
        String reponseSent = reponseQuestion.getText();

        if (sexeSent.isEmpty()) {
            isNotEmpty = false;
        }
        if (nomSent.isEmpty()) {
            wrongNom.setText("Nom obligatoire");
            isNotEmpty = false;
        } else {
            wrongNom.setText("");
        }
        if (prenomSent.isEmpty()) {
            wrongPrenom.setText("Prenom obligatoire");
            isNotEmpty = false;
        } else {
            wrongPassword.setText("");

        }
        if (dateNaissanceSent == null) {
            wrongDate.setText("Date de naissance obligatoire");
            isNotEmpty = false;
        } else {
            wrongDate.setText("");

        }
        if (emailSent.isEmpty()) {
            wrongEmail.setText("Email obligatoire");
            isNotEmpty = false;
        } else {
            wrongEmail.setText("");
        }
        if (telephoneSent.isEmpty()) {
            wrongTelephone.setText("Téléphone obligatoire");
            isNotEmpty = false;
        } else {
            wrongTelephone.setText("");

        }
        if (passwordSent.isEmpty() || confirmationPasswordSent.isEmpty()) {
            wrongPassword.setText("Mot de passe obligatoire");
            isNotEmpty = false;
        } else {
            wrongPassword.setText("");

        }
        if (numeroSent.isEmpty() || voieSent.isEmpty() || adresseSent.isEmpty()) {
            wrongAdresse.setText("Adresse complète obligatoire");
            isNotEmpty = false;
        } else {
            wrongAdresse.setText("");

        }
        if (codePostalSent.isEmpty()) {
            wrongCodePostal.setText("Code postal obligatoire");
            isNotEmpty = false;
        } else {
            wrongCodePostal.setText(null);

        }
        if (villeSent.isEmpty()) {
            wrongVille.setText("Ville obligatoire");
            isNotEmpty = false;
        } else {
            wrongVille.setText("");

        }
        if (reponseSent.isEmpty()) {
            wrongReponse.setText("Réponse à la question obligatoire");
            isNotEmpty = false;
        } else {
            wrongReponse.setText("");
        }
        return isNotEmpty;
    }

    private boolean isMotDePasseConfirmed() {
        boolean mdpConfirmed = true;
        if (!password.getText().equals(passwordConfirmation.getText())) {
            mdpConfirmed = false;
            wrongPassword.setText("Les mots de passe ne sont pas identiques");
        } else {
            wrongPassword.setText("");
        }
        return mdpConfirmed;
    }

    private boolean emailNotInDatabase() {
        boolean emailIsFree = true;
        if ((UtilisateurDAO.getInstance().getUserWithMail(email.getText())) != null) {
            emailIsFree = false;
            wrongEmail.setText("L'e-mail est déjà utilisé");
        }
        return emailIsFree;
    }


    @FXML
    void sendInscription(){
        if (isMotDePasseConfirmed() && checkIfEmpty() && emailNotInDatabase()) {
            String sexeSent = sexe.getValue();
            String nomSent = nom.getText().trim();
            String prenomSent = prenom.getText().trim();
            LocalDate dateNaissanceSent = dateNaissance.getValue();
            LocalDateTime dateNaiss = dateNaissanceSent.atTime(0,0);

            String emailSent = email.getText();
            String telephoneSent = telephone.getText();
            String passwordSent = password.getText();
            String numeroSent = numero.getText();
            String voieSent = typeDeVoie.getText();
            String adresseSent = adresse.getText();
            String codePostalSent = codePostal.getText();
            String villeSent = ville.getText();
            String reponseSent = reponseQuestion.getText();

            Utilisateur user = new Utilisateur(21 / 22, nomSent, prenomSent, dateNaiss, emailSent, telephoneSent,
                    false, sexeSent, passwordSent, false, "stagiaire", reponseSent);
            UtilisateurDAO.getInstance().create(user);

            Integer idUser = Integer.parseInt(UtilisateurDAO.getInstance().getWithEmail("id", emailSent));
            Adresse userAdresse = new Adresse(0, numeroSent, voieSent, adresseSent, villeSent, codePostalSent, idUser, null);
            AdresseDAO.getInstance().create(userAdresse);
            labelInscription.setText("Inscription réussie");
            labelInscription.setTextFill(Color.web("#20DF7F"));

            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.millis(1000),
                    ae -> {
                        try {
                            main.nextScene("loggin-view.fxml");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }));
            timeline.play();

        }

    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sexe.getItems().addAll(arraySexe);
    }


}








