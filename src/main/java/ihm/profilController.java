package ihm;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class profilController {

    Main main = new Main();
    @FXML
    private TextField adresse;

    @FXML
    private Label annuaire;

    @FXML
    private TextField birthday;

    @FXML
    private Label conseils;

    @FXML
    private TextField cp;

    @FXML
    private Button deco;

    @FXML
    private Label fil_actualite;

    @FXML
    private TextField mail;

    @FXML
    private Button modifier;

    @FXML
    private TextField mp;

    @FXML
    private TextField nom;

    @FXML
    private TextField num_rue;

    @FXML
    private TextField num_tel;

    @FXML
    private TextField prenom;

    @FXML
    private Label profil;

    @FXML
    private TextField type;

    @FXML
    private TextField ville;

    @FXML
    void deconnexion(MouseEvent event) throws IOException {
        main.nextScene("loggin-view.fxml");
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
    void versAdmin(MouseEvent event) throws IOException {
        main.nextScene("admin-crea-entreprise-view.fxml");
    }
    @FXML
    void versProfil(MouseEvent event) throws IOException {

    }


}
