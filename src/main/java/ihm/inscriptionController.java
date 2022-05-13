package ihm;

import dao.AdresseDAO;
import dao.UtilisateurDAO;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import staggers.Adresse;
import staggers.Utilisateur;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class inscriptionController implements Initializable {


    private final String[] arraySexe = {"Monsieur", "Madame", "Autre"};

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
    private AnchorPane retourLoggin;

    @FXML
    private ImageView retourLogginArrow;

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

    public inscriptionController() throws ParseException {
    }

    @FXML
    void retourLoggin(MouseEvent event) throws IOException {
        Main main = new Main();
        main.nextScene("loggin-view.fxml");
    }


    private boolean checkIfEmpty() throws ParseException {
        boolean isNotEmpty = true;
        String sexeSent = sexe.getValue().toString();
        String nomSent = nom.getText().toString();
        String prenomSent = prenom.getText().toString();
        LocalDate dateNaissanceSent = dateNaissance.getValue();
        String emailSent = email.getText();
        String telephoneSent = telephone.getText().toString();
        String passwordSent = password.getText();
        String confirmationPasswordSent = passwordConfirmation.getText().toString();
        String numeroSent = numero.getText();
        String voieSent = typeDeVoie.getText().toString();
        String adresseSent = adresse.getText().toString();
        String codePostalSent = codePostal.getText().toString();
        String villeSent = ville.getText().toString();
        String reponseSent = reponseQuestion.getText().toString();

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
        if (!password.getText().toString().equals(passwordConfirmation.getText().toString())) {
            mdpConfirmed = false;
            wrongPassword.setText("Les mots de passe ne sont pas identiques");
        } else {
            wrongPassword.setText("");
        }
        return mdpConfirmed;
    }


    @FXML
    void sendInscription(ActionEvent event) throws ParseException {
        if (isMotDePasseConfirmed() && checkIfEmpty()) {
            String sexeSent = sexe.getValue();
            String nomSent = nom.getText();
            String prenomSent = prenom.getText().toString();
            LocalDate dateNaissanceSent = dateNaissance.getValue();
            LocalDateTime dateNaiss = dateNaissanceSent.atTime(0,0);

            String emailSent = email.getText().toString();
            String telephoneSent = telephone.getText().toString();
            String passwordSent = password.getText().toString();
            String numeroSent = numero.getText().toString();
            String voieSent = typeDeVoie.getText().toString();
            String adresseSent = adresse.getText().toString();
            String codePostalSent = codePostal.getText().toString();
            String villeSent = ville.getText().toString();
            String reponseSent = reponseQuestion.getText().toString();

            Utilisateur user = new Utilisateur(21 / 22, nomSent, prenomSent, dateNaiss, emailSent, telephoneSent,
                    false, sexeSent, passwordSent, false, "stagiaire", reponseSent);
            UtilisateurDAO.getInstance().create(user);

            Integer idUser = Integer.parseInt(UtilisateurDAO.getInstance().getWithEmail("id", emailSent));
            Adresse userAdresse = new Adresse(0, numeroSent, voieSent, adresseSent, villeSent, codePostalSent, idUser, null);
            AdresseDAO.getInstance().create(userAdresse);

            try {
                Main main = new Main();
                main.nextScene("loggin-view.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            };
        }




    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sexe.getItems().addAll(arraySexe);
    }


}








