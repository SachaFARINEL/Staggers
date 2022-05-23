package ihm;

import dao.AdresseDAO;
import dao.EntrepriseDAO;
import dao.UtilisateurDAO;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import staggers.Adresse;
import staggers.Entreprise;
import staggers.Utilisateur;

public class adminCreaEntreprise implements Initializable {

    Main main = new Main();

    private final String[] arrayNbSalarie = {"Moins de 5", "Entre 6 et 9", "Entre 10 et 49", "50 et plus"};

    private final String[] arrayNbStagiaire = {"1", "2", "3", "4 et plus"};

    @FXML
    private TextField adresse;

    @FXML
    private Label annuaire;

    @FXML
    private TextField codePostal;

    @FXML
    private Label conseils;

    @FXML
    private Button deco;

    @FXML
    private TextField email;

    @FXML
    private TextField email_contact;

    @FXML
    private Label fil_actualite;

    @FXML
    private Label admin;

    @FXML
    private ChoiceBox<?> nbSalarie;

    @FXML
    private ChoiceBox<?> nbStagiaire;

    @FXML
    private TextField nom;

    @FXML
    private TextField nom_contact;

    @FXML
    private TextField num_contact;

    @FXML
    private TextField num_tel;

    @FXML
    private TextField numero;

    @FXML
    private Label profil;

    @FXML
    private AnchorPane retourLoggin;

    @FXML
    private ImageView retourLogginArrow;

    @FXML
    private TextField typeDeVoie;

    @FXML
    private Button valider;

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
    private TextField description;

    @FXML
    private TextField langage;

    @FXML
    void deconnexion(MouseEvent event) {

    }

    @FXML
    void retourLoggin(MouseEvent event) {

    }


    @FXML
    void versActualite(MouseEvent event) throws IOException {
        main.nextScene("accueil-view.fxml");
    }

    @FXML
    void versAnnuaire(MouseEvent event) throws IOException {
        main.nextScene("annuaire-view.fxml");
    }

    @FXML
    void versConseil(MouseEvent event) {

    }

    @FXML
    void versProfil(MouseEvent event) {

    }

    @FXML
    void versAdmin(MouseEvent event) {

    }

    private boolean checkIfEmpty() throws ParseException {
        boolean isNotEmpty = true;
        String nomSent = nom.getText().toString();
        String numTelSent = num_tel.getText().toString();
        String nomContactSent = nom_contact.getText().toString();
        String numContactSent = num_contact.getText().toString();
        String emailSent = email.getText().toString();
        String emailContact = email_contact.getText().toString();
        String nbSalarieSent = nbSalarie.getValue().toString();
        String nbStagiaireSent = nbStagiaire.getValue().toString();
        String numeroSent = numero.getText();
        String voieSent = typeDeVoie.getText().toString();
        String adresseSent = adresse.getText().toString();
        String codePostalSent = codePostal.getText().toString();
        String villeSent = ville.getText().toString();
        String descriptionSent = description.getText().toString();
        String langageSent = langage.getText().toString();

        if (nomSent.isEmpty()) {
            isNotEmpty = false;
        }
        if (numTelSent.isEmpty()) {
            isNotEmpty = false;
        }
        if (nomContactSent.isEmpty()) {
            isNotEmpty = false;
        }
        if (numContactSent.isEmpty()) {
            isNotEmpty = false;
        }
        if (emailSent.isEmpty()) {
            isNotEmpty = false;
        }
        if (emailContact.isEmpty()) {
            isNotEmpty = false;
        }
        if (nbSalarieSent.isEmpty()) {
            isNotEmpty = false;
        }
        if (nbStagiaireSent.isEmpty()) {
            isNotEmpty = false;
        }
        if (numeroSent.isEmpty() || voieSent.isEmpty() || adresseSent.isEmpty()) {
            isNotEmpty = false;
        }
        if (codePostalSent.isEmpty()) {
            isNotEmpty = false;

        }
        if (villeSent.isEmpty()) {
            isNotEmpty = false;
        }
        if (descriptionSent.isEmpty()) {
            isNotEmpty = false;
        }
        if (langageSent.isEmpty()) {
            isNotEmpty = false;
        }
        return isNotEmpty;
    }

    public void sendCreationEnt(ActionEvent event) throws ParseException {
        if (checkIfEmpty()) {

            String nomSent = nom.getText().toString();
            String numTelSent = num_tel.getText().toString();
            String nomContactSent = nom_contact.getText().toString();
            String numContactSent = num_contact.getText().toString();
            String emailSent = email.getText().toString();
            String emailContact = email_contact.getText().toString();
            String nbSalarieSent = nbSalarie.getValue().toString();
            String nbStagiaireSent = nbStagiaire.getValue().toString();
            String voieSent = typeDeVoie.getText().toString();
            String numeroSent = numero.getText().toString();
            String adresseSent = adresse.getText().toString();
            String codePostalSent = codePostal.getText().toString();
            String villeSent = ville.getText().toString();
            String descriptionSent = description.getText().toString();
            String langageSent = langage.getText().toString();

            Entreprise entreprise = new Entreprise(nomSent, emailSent, numTelSent, nomContactSent, emailContact, numContactSent, nbSalarieSent, nbStagiaireSent, descriptionSent, langageSent);
            EntrepriseDAO.getInstance().create(entreprise);

            Integer idEnt = Integer.parseInt((EntrepriseDAO.getInstance().getWithEmailEnt("id", emailSent)));
            System.out.println(idEnt);
            Adresse entAdresse = new Adresse(numeroSent, voieSent, adresseSent, villeSent, codePostalSent, idEnt);
            AdresseDAO.getInstance().createEntAdmin(entAdresse);

            try {
                Main main = new Main();
                main.nextScene("accueil-view.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }
            ;
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<String> selectNbSalarie = (ObservableList<String>) nbSalarie.getItems();
        ObservableList<String> selectNbStagiaire = (ObservableList<String>) nbStagiaire.getItems();

        selectNbSalarie.addAll(arrayNbSalarie);
        selectNbStagiaire.addAll(arrayNbStagiaire);

    }

}
