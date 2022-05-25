package ihm;

import dao.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import staggers.Adresse;
import staggers.Commentaire;
import staggers.Entreprise;
import staggers.Favoris;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class ficheEntrepriseController implements Initializable {

    private final int id_utilisateur = logginController.connectedUser.getId();
    private final int id_selectedEntreprise = annuaireController.selectedEntreprise.getId();

    static Adresse adresseSelectEntreprise = AdresseDAO.getInstance().getAdresseWithId("id_entreprise",annuaireController.selectedEntreprise.getId());
    List<Commentaire> listeCommentaire = CommentaireDAO.getInstance().readAll(id_selectedEntreprise);

    Main main = new Main();

    @FXML
    private Label nomEntreprise;
    @FXML
    private ImageView isFavoris;
    @FXML
    public TextArea commentaire;
    @FXML
    public Button buttonSendCommentaire;
    @FXML
    private Label commentaireIsSent;
    @FXML
    public Label telEntreprise;
    @FXML
    public Label debutAdresseEntreprise;
    @FXML
    public Label finAdresseEntreprise;
    @FXML
    public Label nomContact;
    @FXML
    public Label telContact;
    @FXML
    public Label mailContact;
    @FXML
    public Label mailEntreprise;
    @FXML
    public Label tailleEntreprise;
    @FXML
    public Label nbStagiaireMax;
    @FXML
    public Label langageEntreprise;
    @FXML
    private TextArea description;
    @FXML
    private AnchorPane mainAnchor;
    @FXML
    private ListView<?> listViewCommentaire;
    @FXML
    public Button buttonCommentaire;
    @FXML private ImageView letter;

    @FXML
    void changeStar(MouseEvent event) {
        Favoris favoris = new Favoris(id_utilisateur,id_selectedEntreprise);
        if (FavorisDAO.getInstance().isFavoris(logginController.connectedUser.getId(), annuaireController.selectedEntreprise.getId())) {
            isFavoris.setImage(new Image(Objects.requireNonNull(Main.class.getResourceAsStream("img/emptyStar.png"))));
            FavorisDAO.getInstance().delete(favoris);
        } else {
            isFavoris.setImage(new Image(Objects.requireNonNull(Main.class.getResourceAsStream("img/star.png"))));
            FavorisDAO.getInstance().create(favoris);
        }
    }

    @FXML
    void retourAnnuaire(MouseEvent event) throws IOException {
        main.nextScene("annuaire-view.fxml");
    }

    @FXML
    public void sendCommentaire(MouseEvent mouseEvent) {
        if (!commentaire.getText().isEmpty()) {
            Commentaire com = new Commentaire(id_utilisateur, id_selectedEntreprise, commentaire.getText(), LocalDateTime.now());
            CommentaireDAO.getInstance().create(com);
            listeCommentaire.add(com);
            ObservableList<String> maListe = (ObservableList<String>) listViewCommentaire.getItems();
            maListe.clear();
            maListe.addAll(printACommentaire(listeCommentaire));
            commentaire.setText("");
            commentaireIsSent.setVisible(true);

            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.millis(1500),
                    ae -> {
                        commentaireIsSent.setVisible(false);
                    }));
            timeline.play();

        }
    }

    private String[] printACommentaire(List<Commentaire> listeCommentaire) {
        String[] printCom = new String[listeCommentaire.size()];
        int compteur = 0;
        String concatenationCommentaire;
        String nomAuteurCommentaire;
        String prenomAuteurCommentaire;
        String[] dateAmericainCommentaire;
        String dateCommentaire;

        for (Commentaire commentaire : listeCommentaire) {
            dateAmericainCommentaire = ((String.valueOf(commentaire.getDate())).split("T")[0]).split("-");
            dateCommentaire = dateAmericainCommentaire[2] + "/" + dateAmericainCommentaire[1] + "/" + dateAmericainCommentaire[0];

            nomAuteurCommentaire = (UtilisateurDAO.getInstance().read(commentaire.getId_utilisateur())).getNom();
            prenomAuteurCommentaire = (UtilisateurDAO.getInstance().read(commentaire.getId_utilisateur())).getPrenom();
            concatenationCommentaire = prenomAuteurCommentaire + " " + nomAuteurCommentaire + ", le " + dateCommentaire + " : " + commentaire.getCom();
            printCom[compteur++] = concatenationCommentaire;
        }
        return printCom;
    }

    public void switchView(MouseEvent mouseEvent) {
        if (mainAnchor.isVisible()) {
            mainAnchor.setVisible(false);
            listViewCommentaire.setVisible(true);
            buttonCommentaire.setText("Voir la fiche");
        } else {
            mainAnchor.setVisible(true);
            listViewCommentaire.setVisible(false);
            buttonCommentaire.setText("Voir les commentaires");
        }

    }

    @FXML
    void doLetter(MouseEvent event) throws IOException {
        main.nextScene("lettreMotivation-view.fxml");
    }


        @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        nomEntreprise.setText(annuaireController.selectedEntreprise.getNom());
        telEntreprise.setText(annuaireController.selectedEntreprise.getNum_tel());
        mailEntreprise.setText(annuaireController.selectedEntreprise.getEmail());
        debutAdresseEntreprise.setText(adresseSelectEntreprise.getNumero() + " " + adresseSelectEntreprise.getType_de_voie() + " " + adresseSelectEntreprise.getAdresse());
        finAdresseEntreprise.setText(adresseSelectEntreprise.getCode_postal() + ", " + adresseSelectEntreprise.getVille());
        nomContact.setText(annuaireController.selectedEntreprise.getnom_contact());
        telContact.setText(annuaireController.selectedEntreprise.getNum_contact());
        mailContact.setText(annuaireController.selectedEntreprise.getEmail_contact());

        String affichageNbSalaries = "Taille de l'entreprise : " + annuaireController.selectedEntreprise.getNb_salarie() + " salariés";
        String affichageNbStagiaireMax = "Capacité d'accueil : " + annuaireController.selectedEntreprise.getnb_stagiaire_max() + " stagiaire";


            if (!Objects.equals(annuaireController.selectedEntreprise.getnb_stagiaire_max(), "1")) {
                affichageNbStagiaireMax += "s";
            }

        tailleEntreprise.setText(affichageNbSalaries);
        nbStagiaireMax.setText(affichageNbStagiaireMax);


            String langage = annuaireController.selectedEntreprise.getLangage();
            String[] splitedLangage = (langage.split(","));
            String lan = "Langage";
            if (splitedLangage.length > 1) {
                lan += "s";
            }

        langageEntreprise.setText(lan +" : "  + annuaireController.selectedEntreprise.getLangage());
        description.setText(annuaireController.selectedEntreprise.getDescription());
        commentaireIsSent.setVisible(false);
        listViewCommentaire.setVisible(false);

        if (FavorisDAO.getInstance().isFavoris(id_utilisateur, id_selectedEntreprise)) {
            isFavoris.setImage(new Image(Objects.requireNonNull(Main.class.getResourceAsStream("img/star.png"))));
        } else {
            isFavoris.setImage(new Image(Objects.requireNonNull(Main.class.getResourceAsStream("img/emptyStar.png"))));
        }

        ObservableList<String> maListe = (ObservableList<String>) listViewCommentaire.getItems();
        maListe.addAll(printACommentaire(listeCommentaire));



        }





}
