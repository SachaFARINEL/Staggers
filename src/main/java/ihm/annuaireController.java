package ihm;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class annuaireController {
    Main main = new Main();
    @FXML
    private Label annuaire;

    @FXML
    private Label conseils;

    @FXML
    private Button deco;

    @FXML
    private Button details;

    @FXML
    private Label fil_actualite;

    @FXML
    private ImageView img_ent_default;

    @FXML
    private Label nomEntreprise;

    @FXML
    private Label profil;

    @FXML
    private Label villeEntreprise;

    @FXML
    void deconnexion(MouseEvent event) throws IOException {
        main.nextScene("loggin-view.fxml");
    }

    @FXML
    void versActualite(MouseEvent event) throws IOException {
        main.nextScene("accueil-view.fxml");
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

}
