package ihm;

import dao.AdresseDAO;
import dao.EntrepriseDAO;
import dao.FavorisDAO;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import staggers.Adresse;
import staggers.Entreprise;
import staggers.Favoris;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class annuaireController implements Initializable  {

    static Entreprise selectedEntreprise;
    private final String[] arrayChoix = {"nom", "ville", "langage"};
    List<Entreprise> listeEntreprise = EntrepriseDAO.getInstance().readAll();

    Main main = new Main();


    @FXML
    private TextField searchBox;
    @FXML
    public ImageView loupe;
    @FXML
    private ListView<?> myListView;
    @FXML
    public ChoiceBox<String> rechercheBy;
    @FXML
    private Label noResult;
    @FXML
    private Label admin;


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
        main.nextScene("profil2-view.fxml");
    }

    @FXML
    void getFavoris(MouseEvent event) {
        ObservableList<String> entrepriseInListView = (ObservableList<String>) myListView.getItems();
        List<Favoris> listeFavoris = FavorisDAO.getInstance().readAllWithId(logginController.connectedUser.getId());
        entrepriseInListView.clear();
        if (listeFavoris.isEmpty()) {
            noResult.setVisible(true);
        } else {
            entrepriseInListView.addAll(getFavoris(listeFavoris));
            noResult.setVisible(false);
        }
    }

    @FXML
    void rechercheLIKE(MouseEvent event) {
        ObservableList<String> entrepriseInListView = (ObservableList<String>) myListView.getItems();
        String dataUser = searchBox.getText();
        if (rechercheBy.getValue().equals("nom")) {
            List<Entreprise> listeEntrepriseLIKE = EntrepriseDAO.getInstance().chercherEntrepriseParNomLIKE(dataUser);
            entrepriseInListView.clear();
            if (listeEntrepriseLIKE.isEmpty()) {
                noResult.setVisible(true);
            } else {
                entrepriseInListView.addAll(getEntreprise(listeEntrepriseLIKE));
                noResult.setVisible(false);
            }

        } else if (rechercheBy.getValue().equals("ville")) {
            List<Adresse> listeAdresseLike = AdresseDAO.getInstance().chercherEntrepriseParVilleLIKE(dataUser);
            entrepriseInListView.clear();
            if (listeAdresseLike.isEmpty()) {
                noResult.setVisible(true);
            } else {
                entrepriseInListView.addAll(getAdresse(listeAdresseLike));
                noResult.setVisible(false);
            }

        } else {
            List<Entreprise> listeEntrepriseLangageLike = EntrepriseDAO.getInstance().chercherEntrepriseParLangageLIKE(dataUser);
            entrepriseInListView.clear();
            if (listeEntrepriseLangageLike.isEmpty()) {
                noResult.setVisible(true);
            } else {
                entrepriseInListView.addAll(getEntreprise(listeEntrepriseLangageLike));
                noResult.setVisible(false);
            }
        }

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

    private String[] getAdresse(List<Adresse> listeAdresse) {
        String[] adr = new String[listeAdresse.size()];
        int compteur = 0;
        String informationsEntreprise;
        String adresseEntreprise;
        for (Adresse adresse : listeAdresse) {
            Entreprise entreprise = EntrepriseDAO.getInstance().read(adresse.getId_entreprise());
            informationsEntreprise = entreprise.getId() + " - " + entreprise.getNom() + " - " + adresse.getCode_postal() + ", " + adresse.getVille() + " - " + entreprise.getLangage();;
            adr[compteur++] = informationsEntreprise;
        }
        return adr;
    }

    private String[] getFavoris(List<Favoris> listeFavoris) {
        String[] fav = new String[listeFavoris.size()];
        int compteur = 0;
        String informationsEntreprise;
        String adresseEntreprise;
        for (Favoris favoris : listeFavoris) {
            Entreprise entreprise = EntrepriseDAO.getInstance().read(favoris.getId_entreprise());
            Adresse adresse = AdresseDAO.getInstance().getAdresseWithId("id_entreprise", entreprise.getId());
            informationsEntreprise = entreprise.getId() + " - " + entreprise.getNom() + " - " + adresse.getCode_postal() + ", " + adresse.getVille() + " - " + entreprise.getLangage();;
            fav[compteur++] = informationsEntreprise;
        }
        return fav;
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> maListe = (ObservableList<String>) myListView.getItems();
        maListe.addAll(getEntreprise(listeEntreprise));
        rechercheBy.getItems().addAll(arrayChoix);
        noResult.setVisible(false);
        if (logginController.connectedUser.isEst_admin()) {
            admin.setVisible(true);
        } else {
            admin.setVisible(false);
        }


    }



}
