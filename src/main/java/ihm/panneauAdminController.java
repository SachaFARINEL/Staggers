package ihm;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import java.io.IOException;

public class panneauAdminController {

    Main main = new Main();

    @FXML
    void deconnexion(MouseEvent event) throws IOException {
        main.nextScene("loggin-view.fxml");
    }

    @FXML
    void versActualite(MouseEvent event) throws IOException {
        main.nextScene("accueil-view.fxml");
    }

    @FXML
    void versAdmin(MouseEvent event) throws IOException {
        main.nextScene("panneauAdmin-view.fxml");
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
    void addEntreprise(MouseEvent event) throws IOException {
        main.nextScene("creaEntreprise-view.fxml");
    }

    @FXML
    public void editEntreprise(MouseEvent mouseEvent) throws IOException {
        main.nextScene("editEntreprise-view.fxml");
    }

    @FXML
    void voirUser(MouseEvent event) throws IOException {
        main.nextScene("voirUser-view.fxml");

    }

}
