package ihm;

import dao.UtilisateurDAO;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import staggers.Utilisateur;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class voirUserController implements Initializable {

    private Utilisateur selectedUser;

    Main main = new Main();

    @FXML
    private Label changeStage;

    @FXML
    private Label utilisateurUpdated;

    @FXML
    private Label labelStage;

    @FXML
    private Button validateButton;

    @FXML
    private TableColumn<Utilisateur, Boolean> isAdmis;

    @FXML
    private TableColumn<Utilisateur, String> mail;

    @FXML
    private TableColumn<Utilisateur, String> nom;

    @FXML
    private TableColumn<Utilisateur, String> numTel;

    @FXML
    private TableColumn<Utilisateur, String> prenom;

    @FXML
    private TableView<Utilisateur> table;

    @FXML
    void backPanneau(MouseEvent event) throws IOException {
        main.nextScene("panneauAdmin-view.fxml");
    }

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
    void getSelectedRow(MouseEvent event) {
        selectedUser = table.getSelectionModel().getSelectedItem();
        validateButton.setVisible(true);
        if (selectedUser.isAdmis_stage()) {
            changeStage.setText("Voulez vous annuler l'obtention de stage du l'élève ?");
        } else {
            changeStage.setText("Voulez vous confirmer l'obtention du stage de l'élève ?");
        }
    }

    private void setColumnValue() {
        ObservableList<Utilisateur> data = FXCollections.observableArrayList(UtilisateurDAO.getInstance().readAll());
        isAdmis.setCellValueFactory(new PropertyValueFactory<>("admis_stage"));
        mail.setCellValueFactory(new PropertyValueFactory<>("email"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        numTel.setCellValueFactory(new PropertyValueFactory<>("num_tel"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        table.setItems(data);
    }


    @FXML
    void valider(MouseEvent event) {
        Utilisateur changedUtilisateurStage = new Utilisateur(selectedUser.getId(), selectedUser.getPromo(), selectedUser.getNom(),
                selectedUser.getPrenom(), selectedUser.getDate_naissance(), selectedUser.getEmail(), selectedUser.getNum_tel(),
                !selectedUser.isAdmis_stage(), selectedUser.getSexe(), selectedUser.getMot_de_passe(), selectedUser.isEst_admin(),
                selectedUser.getRole(), selectedUser.getQuestion_secrete());
        UtilisateurDAO.getInstance().update(changedUtilisateurStage);
        setColumnValue();
        selectedUser = changedUtilisateurStage;
        labelStage.setVisible(false);
        utilisateurUpdated.setVisible(true);
        String pronom = "Le";
        String trouve = "trouvé";
        if (selectedUser.getSexe().equals("Madame")) {
            pronom = "La";
            trouve = "e";
        } else if (selectedUser.getSexe().equals("Autre")) {
            pronom += "/la";
            trouve = "⸱e";
        }
        if (selectedUser.isAdmis_stage()) {
            utilisateurUpdated.setText(pronom + " stagiaire a " + trouve + " un stage !");
        } else {
            utilisateurUpdated.setText(pronom + " stagiaire n'a plus de stage");
        }
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(1000),
                ae -> {
                    labelStage.setVisible(true);
                    utilisateurUpdated.setVisible(false);
                }));
        timeline.play();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setColumnValue();

        validateButton.setVisible(false);
    }
}
