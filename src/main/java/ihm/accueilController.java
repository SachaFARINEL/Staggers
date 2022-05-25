package ihm;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class accueilController implements Initializable {

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
    private Label admin;

    @FXML
    private Label bienvenue;

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
    void versProfil(MouseEvent event) throws IOException {
        main.nextScene("profil2-view.fxml");
    }
    @FXML
    void versAdmin(MouseEvent event) throws IOException {
        main.nextScene("admin-crea-entreprise-view.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bienvenue.setText("Hey, " + logginController.connectedUser.getPrenom());

        if (logginController.connectedUser.isEst_admin()) {
           admin.setVisible(true);
        } else {
            admin.setVisible(false);
        }
    }
}
