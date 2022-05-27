package ihm;

import dao.AdresseDAO;
import dao.EntrepriseDAO;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import staggers.Adresse;
import staggers.Entreprise;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class editEntrepriseController<AnchorPane> implements Initializable {

    static Entreprise adminSelectedEntreprise;
    static Adresse adminSelectedEntrepriseAdresse;
    public javafx.scene.layout.AnchorPane anchorEdit;

    Main main = new Main();

    @FXML
    private Label modificationDone;
    @FXML
    private Label modifierUneEntreprise;

    @FXML
    private TextField textfieldNom;
    @FXML
    private TextArea textAreaDescription;
    @FXML
    private TextField textfieldEmail;
    @FXML
    private TextField textfieldEmailMailContact;
    @FXML
    private TextField textfieldNomContact;
    @FXML
    private TextField textfieldNumContact;
    @FXML
    private TextField textfieldTel;

    @FXML
    private ChoiceBox<String> choiceBoxLangage;
    @FXML
    private ChoiceBox<String> choiceBoxNbSalarie;
    @FXML
    private ChoiceBox<String> choiceBoxNbStagiaire;

    @FXML
    private TextField adresseAdresse;
    @FXML
    private TextField adresseCodePostal;
    @FXML
    private TextField adresseNumero;
    @FXML
    private TextField adresseTypeDeVoie;
    @FXML
    private TextField adresseVille;


    @FXML
    private TableView<Entreprise> table;
    @FXML
    private TableColumn<Entreprise, String> id;
    @FXML
    private TableColumn<Entreprise, String> nom;
    @FXML
    private TableColumn<Entreprise, String> mail;
    @FXML
    private TableColumn<Entreprise, String> tel;

    @FXML
    private TableColumn<Adresse, String> adresse;


    @FXML
    void deconnexion(MouseEvent event) throws IOException {
        main.nextScene("loggin-view.fxml");
    }

    @FXML
    void versActualite(MouseEvent event) throws IOException {
        main.nextScene("annuaire-view.fxml");
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
    void backPanneau(MouseEvent event) throws IOException {
        main.nextScene("panneauAdmin-view.fxml");
    }

    @FXML
    void getSelectedRow(MouseEvent event) {
        adminSelectedEntreprise = table.getSelectionModel().getSelectedItem();
        adminSelectedEntrepriseAdresse = AdresseDAO.getInstance().readWithId("id_entreprise", adminSelectedEntreprise.getId());
        anchorEdit.setVisible(true);
        textfieldNom.setText(adminSelectedEntreprise.getNom());
        textAreaDescription.setText(adminSelectedEntreprise.getDescription());
        textfieldEmail.setText(adminSelectedEntreprise.getEmail());
        textfieldEmailMailContact.setText(adminSelectedEntreprise.getEmail_contact());
        textfieldNomContact.setText(adminSelectedEntreprise.getnom_contact());
        textfieldNumContact.setText(adminSelectedEntreprise.getNum_contact());
        textfieldTel.setText(adminSelectedEntreprise.getNum_tel());
        choiceBoxLangage.setValue(adminSelectedEntreprise.getLangage());
        choiceBoxNbSalarie.setValue(adminSelectedEntreprise.getNb_salarie());
        choiceBoxNbStagiaire.setValue(adminSelectedEntreprise.getnb_stagiaire_max());

        adresseAdresse.setText(adminSelectedEntrepriseAdresse.getAdresse());
        adresseCodePostal.setText(adminSelectedEntrepriseAdresse.getCode_postal());
        adresseNumero.setText(adminSelectedEntrepriseAdresse.getNumero());
        adresseTypeDeVoie.setText(adminSelectedEntrepriseAdresse.getType_de_voie());
        adresseVille.setText(adminSelectedEntrepriseAdresse.getVille());


    }

    @FXML
    void updateEntreprise(MouseEvent event) {
        Entreprise updatedEntreprise = new Entreprise(adminSelectedEntreprise.getId(), textfieldNom.getText(), textfieldEmail.getText(), textfieldTel.getText(), textfieldNomContact.getText(),
                textfieldEmailMailContact.getText(), textfieldNumContact.getText(), choiceBoxNbSalarie.getValue(),
                choiceBoxNbStagiaire.getValue(), textAreaDescription.getText(), choiceBoxLangage.getValue());

        Adresse updatedAdresse = new Adresse(adminSelectedEntrepriseAdresse.getId(), adresseNumero.getText(), adresseTypeDeVoie.getText(), adresseAdresse.getText(), adresseVille.getText(),
                adresseCodePostal.getText(), adminSelectedEntreprise.getId());

        if (AdresseDAO.getInstance().updateWithoutIdUtilisateur(updatedAdresse) && EntrepriseDAO.getInstance().update(updatedEntreprise)
        ) {
            ObservableList<Entreprise> data = FXCollections.observableArrayList(EntrepriseDAO.getInstance().readAll());
            id.setCellValueFactory(new PropertyValueFactory<Entreprise, String>("id"));
            nom.setCellValueFactory(new PropertyValueFactory<Entreprise, String>("nom"));
            mail.setCellValueFactory(new PropertyValueFactory<Entreprise, String>("email"));
            tel.setCellValueFactory(new PropertyValueFactory<Entreprise, String>("num_tel"));
            table.setItems((ObservableList<Entreprise>) data);
            modifierUneEntreprise.setVisible(false);
            modificationDone.setVisible(true);
            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.millis(1000),
                    ae -> {
                        modificationDone.setVisible(false);
                        modifierUneEntreprise.setVisible(true);
                    }));
            timeline.play();

        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        modificationDone.setVisible(false);
        ObservableList<Entreprise> data = FXCollections.observableArrayList(EntrepriseDAO.getInstance().readAll());
        id.setCellValueFactory(new PropertyValueFactory<Entreprise, String>("id"));
        nom.setCellValueFactory(new PropertyValueFactory<Entreprise, String>("nom"));
        mail.setCellValueFactory(new PropertyValueFactory<Entreprise, String>("email"));
        tel.setCellValueFactory(new PropertyValueFactory<Entreprise, String>("num_tel"));
        table.setItems((ObservableList<Entreprise>) data);

        anchorEdit.setVisible(false);
        ObservableList<String> selectNbSalarie = (ObservableList<String>) choiceBoxNbSalarie.getItems();
        ObservableList<String> selectNbStagiaire = (ObservableList<String>) choiceBoxNbStagiaire.getItems();
        ObservableList<String> selectLangage = (ObservableList<String>) choiceBoxLangage.getItems();
        selectNbSalarie.addAll(creaEntrepriseController.arrayNbSalarie);
        selectNbStagiaire.addAll(creaEntrepriseController.arrayNbStagiaire);
        selectLangage.addAll(creaEntrepriseController.arrayLangage);

    }
}
