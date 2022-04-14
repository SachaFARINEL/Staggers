package ihm;

import dao.UtilisateurDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import staggers.Utilisateur;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        String dateNaissanceSent = dateNaissance.getValue().toString();
        String emailSent = email.getText().toString();
        String telephoneSent = telephone.getText().toString();
        String passwordSent = password.getText().toString();
        String confirmationPasswordSent = passwordConfirmation.getText().toString();
        String numeroSent = numero.getText().toString();
        String voieSent = typeDeVoie.getText().toString();
        String adresseSent = adresse.getText().toString();
        String codePostalSent = codePostal.getText().toString();
        String villeSent = ville.getText().toString();
        String reponseSent = reponseQuestion.getText().toString();

        if (sexeSent.isEmpty()) {
            isNotEmpty = false;
        } else if (nomSent.isEmpty()) {
            wrongNom.setText("Nom obligatoire");
            isNotEmpty = false;
        } else if (prenomSent.isEmpty()) {
            wrongPrenom.setText("Prenom obligatoire");
            isNotEmpty = false;
        } else if (dateNaissanceSent.isEmpty()) {
            wrongDate.setText("Date de naissance obligatoire");
            isNotEmpty = false;
        } else if (emailSent.isEmpty()) {
            wrongEmail.setText("Email obligatoire");
            isNotEmpty = false;
        } else if (telephoneSent.isEmpty()) {
            wrongTelephone.setText("Téléphone obligatoire");
            isNotEmpty = false;
        } else if (passwordSent.isEmpty() || confirmationPasswordSent.isEmpty()) {
            wrongPassword.setText("Mot de passe obligatoire");
            isNotEmpty = false;
        } else if (numeroSent.isEmpty() || voieSent.isEmpty() || adresseSent.isEmpty()) {
            wrongAdresse.setText("Adresse complète obligatoire");
            isNotEmpty = false;
        } else if (codePostalSent.isEmpty()) {
            wrongCodePostal.setText("Code postal obligatoire");
            isNotEmpty = false;
        } else if (villeSent.isEmpty()) {
            wrongVille.setText("Ville obligatoire");
            isNotEmpty = false;
        } else if (reponseSent.isEmpty()) {
            wrongReponse.setText("Réponse à la question obligatoire");
            isNotEmpty = false;
        }
        return isNotEmpty;
    }


    @FXML
    void sendInscription(ActionEvent event) throws ParseException {
        String sexeSent = sexe.getValue().toString();
        String nomSent = nom.getText().toString();
        String prenomSent = prenom.getText().toString();
        String dateNaissanceSent = dateNaissance.getValue().toString();
        //Date dateNaissanceSentToDate = (Date) new SimpleDateFormat("dd-MM-yyyy").parse(dateNaissanceSent);

        String emailSent = email.getText().toString();
        String telephoneSent = telephone.getText().toString();
        String passwordSent = password.getText().toString();
        String confirmationPasswordSent = passwordConfirmation.getText().toString();
        String numeroSent = numero.getText().toString();
        String voieSent = typeDeVoie.getText().toString();
        String adresseSent = adresse.getText().toString();
        String codePostalSent = codePostal.getText().toString();
        String villeSent = ville.getText().toString();
        String reponseSent = reponseQuestion.getText().toString();
        if (checkIfEmpty()) {
            Utilisateur user = new Utilisateur(1, 21 / 22, nomSent, prenomSent, null, emailSent, telephoneSent,
                    false, sexeSent, passwordSent, false, "stagiaire", reponseSent);
            UtilisateurDAO.getInstance().create(user);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sexe.getItems().addAll(arraySexe);
    }


}








