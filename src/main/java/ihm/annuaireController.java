package ihm;

import dao.AdresseDAO;
import dao.EntrepriseDAO;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import staggers.Entreprise;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class annuaireController implements Initializable {

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
    void versProfil(MouseEvent event) throws IOException {
        main.nextScene("profil-view.fxml");
    }

    @FXML
    private ListView<?> myListView;

    int currentId;
    List<Entreprise> listeEntreprise = EntrepriseDAO.getInstance().readAll();

    private String[] getEntreprise(List<Entreprise> listeEntreprise) {
        String[] nomEntreprise = new String[listeEntreprise.size()];
        int compteur = 0;
        String informationsEntreprise;
        String adresseEntreprise;
        for (Entreprise entreprise : listeEntreprise) {
            adresseEntreprise = (AdresseDAO.readWithId("id_entreprise", entreprise.getId())).getCode_postal() + ", " + (AdresseDAO.readWithId("id_entreprise", entreprise.getId())).getVille();
            informationsEntreprise = entreprise.getNom() + " - " + adresseEntreprise + " - " + entreprise.getLangage();
            nomEntreprise[compteur++] = informationsEntreprise;
        }
        return nomEntreprise;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> maListe = (ObservableList<String>) myListView.getItems();

        maListe.addAll(getEntreprise(listeEntreprise));
    }


}
