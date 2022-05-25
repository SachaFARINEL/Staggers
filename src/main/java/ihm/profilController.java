package ihm;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class profilController {

    Main main = new Main();
    @FXML
    private Label deco;

    @FXML
    private Label fil_actualite;

    @FXML
    private Label profil;

    @FXML
    private Label annuaire;

    @FXML
    private Label conseils;

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
        main.nextScene("profil-view.fxml");
    }


}
