package ihm;

import dao.EntrepriseDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import staggers.Entreprise;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class accueilController implements Initializable {

    Main main = new Main();

    @FXML private Label admin;
    @FXML private Label bienvenue;
    @FXML private TableView <Entreprise> tableauEntreprise;

    @FXML void deconnexion(MouseEvent event) throws IOException {
        main.nextScene("loggin-view.fxml");
    }

    @FXML void versActualite(MouseEvent event) throws IOException {
        main.nextScene("accueil-view.fxml");
    }

    @FXML void versAnnuaire(MouseEvent event) throws IOException {
        main.nextScene("annuaire-view.fxml");
    }

    @FXML void versConseil(MouseEvent event) {
    }

    @FXML void versProfil(MouseEvent event) throws IOException {
        main.nextScene("profil-view.fxml");
    }
    @FXML void versAdmin(MouseEvent event) throws IOException {
        main.nextScene("panneauAdmin-view.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bienvenue.setText("Hey, " + logginController.connectedUser.getPrenom());
        admin.setVisible(logginController.connectedUser.isEst_admin());

        TableColumn<Entreprise, String> entrepriseName = new TableColumn<Entreprise, String>("Nom");
//        TableColumn<Entreprise, String> entrepriseAdresse = new TableColumn<Entreprise, String>("Adresse");
//        TableColumn<Entreprise, String> entrepriseCodePostal = new TableColumn<Entreprise, String>("Code postal");
//        TableColumn<Entreprise, String> entrepriseVille = new TableColumn<Entreprise, String>("Ville");
//        TableColumn<Entreprise, String> entrepriseLangage = new TableColumn<Entreprise, String>("Langage");
//        TableColumn<Entreprise, String> entrepriseFavoris = new TableColumn<Entreprise, String>("Favoris");
//
//        entrepriseAdresse.getColumns().addAll(entrepriseCodePostal, entrepriseVille);
        tableauEntreprise.getColumns().addAll(entrepriseName
////                , entrepriseAdresse, entrepriseLangage, entrepriseFavoris
        );
        ObservableList<Entreprise> data = FXCollections.observableArrayList(EntrepriseDAO.getInstance().readAll());
//        entrepriseName.setCellValueFactory(new PropertyValueFactory<Entreprise, String>("nom"));
//        tableauEntreprise.setItems((ObservableList<Entreprise>) data);
//        entrepriseCodePostal.setCellValueFactory(new PropertyValueFactory<Entreprise, String>("nom"));
//        entrepriseVille.setCellValueFactory(new PropertyValueFactory<Entreprise, String>("nom"));
//        entrepriseLangage.setCellValueFactory(new PropertyValueFactory<Entreprise, String>("nom"));
//        entrepriseFavoris.setCellValueFactory(new PropertyValueFactory<Entreprise, String>("nom"));




    }



}
