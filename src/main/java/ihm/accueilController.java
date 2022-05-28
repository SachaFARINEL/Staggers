package ihm;

import dao.EntrepriseDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import staggers.Entreprise;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class accueilController implements Initializable {

    Main main = new Main();

    @FXML
    private Label admin;
    @FXML
    private Label bienvenue;
    @FXML
    private TableView<Entreprise> tableauEntreprise;

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
        main.nextScene("profil-view.fxml");
    }

    @FXML
    void versAdmin(MouseEvent event) throws IOException {
        main.nextScene("panneauAdmin-view.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bienvenue.setText("Hey, " + logginController.connectedUser.getPrenom());
        admin.setVisible(logginController.connectedUser.isEst_admin());

    }


}
