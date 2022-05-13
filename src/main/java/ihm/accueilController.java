package ihm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class accueilController  {

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
    void versActualite(MouseEvent event) throws IOException {
        Main main = new Main();
        main.nextScene("actualite-view.fxml");
    }
    @FXML
    void versAnnuaire(MouseEvent event) throws IOException {
        Main main = new Main();
        main.nextScene("annuaire-view.fxml");
    }
    @FXML
    void versConseil(MouseEvent event) throws IOException {
        Main main = new Main();
        main.nextScene("conseil-view.fxml");
    }
    @FXML
    void versProfil(MouseEvent event) throws IOException {
        Main main = new Main();
        main.nextScene("profil-view.fxml");
    }
    @FXML
    void deconnexion(MouseEvent event) throws IOException {
        Main main = new Main();
        main.nextScene("loggin-view.fxml");
    }


}
