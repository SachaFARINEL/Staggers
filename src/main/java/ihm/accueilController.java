package ihm;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class accueilController {
    Main main = new Main();

    @FXML
    private Label annuaire;

    @FXML
    private Label conseils;

    @FXML
    private Button deco;

    @FXML
    private Label fil_actualite;

    @FXML
    private Label profil;

    @FXML
    void deconnexion(MouseEvent event) throws IOException {
        main.nextScene("loggin-view.fxml");
    }

    @FXML
    void versActualite(MouseEvent event) {

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

}
