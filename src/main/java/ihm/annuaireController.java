package ihm;

import dao.AdresseDAO;
import dao.EntrepriseDAO;
import dao.UtilisateurDAO;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import staggers.Entreprise;
import staggers.Utilisateur;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class annuaireController implements Initializable  {

    static Entreprise selectedEntreprise;
    List<Entreprise> listeEntreprise = EntrepriseDAO.getInstance().readAll();
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
    private TextField searchBox;

    @FXML
    private ListView<?> myListView;

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
    void rechercheLIKE(MouseEvent event) {
        String dataUser = searchBox.getText();
        System.out.println(dataUser);
        List<Entreprise> listeEntrepriseLIKE = EntrepriseDAO.getInstance().chercherEntrepriseParNomLIKE(dataUser);
        ObservableList<String> entrepriseInListView = (ObservableList<String>) myListView.getItems();
        entrepriseInListView.clear();
        entrepriseInListView.addAll(getEntreprise(listeEntrepriseLIKE));
    }

    public void getEntrepriseSelected() {
        String textSelectedCellule = (String) myListView.getSelectionModel().getSelectedItem();
        String[] listViewSelectedEntreprise = textSelectedCellule.split(" ");
        int idSelectedEntreprise =  parseInt(listViewSelectedEntreprise[0]);
        selectedEntreprise = EntrepriseDAO.getInstance().read(idSelectedEntreprise);
    }

    public void handleMouseClick(MouseEvent mouseEvent) throws IOException {
        getEntrepriseSelected();
        main.nextScene("ficheEntreprise-view.fxml");
    }

    private String[] getEntreprise(List<Entreprise> listeEntreprise) {
        String[] nomEntreprise = new String[listeEntreprise.size()];
        int compteur = 0;
        String informationsEntreprise;
        String adresseEntreprise;
        for (Entreprise entreprise : listeEntreprise) {
            adresseEntreprise = (AdresseDAO.readWithId("id_entreprise", entreprise.getId())).getCode_postal() + ", " + (AdresseDAO.readWithId("id_entreprise", entreprise.getId())).getVille();
            informationsEntreprise = entreprise.getId() + " - " + entreprise.getNom() + " - " + adresseEntreprise + " - " + entreprise.getLangage();
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
