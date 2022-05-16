package ihm;

import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class adminCreaEntreprise implements Initializable {

    private final String[] arrayNbSalarie = {"Moins de 5","Entre 6 et 9","Entre 10 et 49","50 et plus"};

    private final String[] arrayNbStagiaire = {"1","2","3","4 et plus"};

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
    private Label fil_actualite1;

    @FXML
    private ChoiceBox<?> nbSalarie;

    @FXML
    private ChoiceBox<?> nbStagiaire;

    @FXML
    private TextField nom1;

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
    void deconnexion(MouseEvent event) {

    }

    @FXML
    void retourLoggin(MouseEvent event) {

    }

    @FXML
    void sendInscription(ActionEvent event) {

    }

    @FXML
    void versActualite(MouseEvent event) {

    }

    @FXML
    void versAnnuaire(MouseEvent event) {

    }

    @FXML
    void versConseil(MouseEvent event) {

    }

    @FXML
    void versProfil(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<String> selectNbSalarie = (ObservableList<String>) nbSalarie.getItems();
        ObservableList<String> selectNbStagiaire = (ObservableList<String>) nbStagiaire.getItems();

        selectNbSalarie.addAll(arrayNbSalarie);
        selectNbStagiaire.addAll(arrayNbStagiaire);

    }

}
