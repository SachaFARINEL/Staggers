package ihm;

import dao.AdresseDAO;
import dao.EntrepriseDAO;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import staggers.Adresse;
import staggers.Entreprise;

public class creaEntrepriseController implements Initializable {

    static public final String[] arrayNbSalarie = {"Moins de 5", "Entre 6 et 9", "Entre 10 et 49", "50 et plus"};
    static public final String[] arrayNbStagiaire = {"1", "2", "3", "4 et plus"};
    static public final String[] arrayLangage = {"JavaScript", "PHP", "Ruby", "Java", "Swift", "C#", "C", "C++", "Python", "Julia", "Scala"};

    Main main = new Main();

    @FXML
    private TextField adresse;
    @FXML
    private TextField codePostal;
    @FXML
    private TextField email;
    @FXML
    private TextField email_contact;
    @FXML
    private ChoiceBox<String> nbSalarie;
    @FXML
    private ChoiceBox<String> nbStagiaire;
    @FXML
    private ChoiceBox<String> langagePrincipal;
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
    private TextField typeDeVoie;
    @FXML
    private TextField ville;
    @FXML
    private TextField description;
    @FXML
    private Label titreFiche;
    @FXML
    private Label confirmationEntreprise;

    @FXML
    void deconnexion(MouseEvent event) throws IOException {
        main.nextScene("loggin-view.fxml");
    }

    @FXML
    void retourPanneau(MouseEvent event) throws IOException {
        main.nextScene("panneauAdmin-view.fxml");
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
    void versProfil(MouseEvent event) throws IOException {
        main.nextScene("profil-view.fxml");

    }

    @FXML
    void versAdmin(MouseEvent event) throws IOException {
        main.nextScene("panneauAdmin-view.fxml");
    }

    private boolean checkIfEmpty() {
        boolean isNotEmpty = true;
        String nomSent = nom.getText();
        String numTelSent = num_tel.getText();
        String nomContactSent = nom_contact.getText();
        String numContactSent = num_contact.getText();
        String emailSent = email.getText();
        String emailContact = email_contact.getText();
        String nbSalarieSent = nbSalarie.getValue();
        String nbStagiaireSent = nbStagiaire.getValue();
        String numeroSent = numero.getText();
        String voieSent = typeDeVoie.getText();
        String adresseSent = adresse.getText();
        String codePostalSent = codePostal.getText();
        String villeSent = ville.getText();
        String descriptionSent = description.getText();
        String langageSent = langagePrincipal.getValue();

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

    public void sendCreationEnt() {
        if (checkIfEmpty()) {

            String nomSent = nom.getText();
            String numTelSent = num_tel.getText();
            String nomContactSent = nom_contact.getText();
            String numContactSent = num_contact.getText();
            String emailSent = email.getText();
            String emailContact = email_contact.getText();
            String nbSalarieSent = nbSalarie.getValue();
            String nbStagiaireSent = nbStagiaire.getValue();
            String voieSent = typeDeVoie.getText();
            String numeroSent = numero.getText();
            String adresseSent = adresse.getText();
            String codePostalSent = codePostal.getText();
            String villeSent = ville.getText();
            String descriptionSent = description.getText();
            String langageSent = langagePrincipal.getValue();

            Entreprise entreprise = new Entreprise(nomSent, emailSent, numTelSent, nomContactSent, emailContact, numContactSent, nbSalarieSent, nbStagiaireSent, descriptionSent, langageSent);
            EntrepriseDAO.getInstance().create(entreprise);

            Integer idEnt = Integer.parseInt((EntrepriseDAO.getInstance().getWithEmailEnt("id", emailSent)));
            System.out.println(idEnt);
            Adresse entAdresse = new Adresse(numeroSent, voieSent, adresseSent, villeSent, codePostalSent, idEnt);
            AdresseDAO.getInstance().createEntAdmin(entAdresse);

            titreFiche.setVisible(false);
            confirmationEntreprise.setVisible(true);
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), ae -> {
                try {
                    main.nextScene("panneauAdmin-view.fxml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }));
            timeline.play();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        confirmationEntreprise.setVisible(false);
        ObservableList<String> selectNbSalarie = nbSalarie.getItems();
        ObservableList<String> selectNbStagiaire = nbStagiaire.getItems();
        ObservableList<String> selectLangage = langagePrincipal.getItems();
        selectNbSalarie.addAll(arrayNbSalarie);
        selectNbStagiaire.addAll(arrayNbStagiaire);
        selectLangage.addAll(arrayLangage);
    }

}
