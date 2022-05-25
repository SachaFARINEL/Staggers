package ihm;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class lettreMotivationController implements Initializable {

    Main main = new Main();

    @FXML private Label adresseInf;

    @FXML private Label adresseInfEntreprise;

    @FXML private Label adresseSup;

    @FXML private Label adresseSupEntreprise;

    @FXML private Text corpTexte;

    @FXML private Label nomEntreprise;

    @FXML private Label nomPrenom;

    @FXML private Label villeDate;

    @FXML private AnchorPane anchorScroll;

    @FXML private TextField nombreDeSemaine;

    @FXML private TextField debutStage;

    @FXML private TextField premiereQualite;

    @FXML private TextField deuxiemeQualite;

    @FXML private Text emptyTextfield;

    @FXML private ImageView beforeLetter;


    private String sexe() {
        return logginController.connectedUser.getSexe();
    }

    @FXML void genererLettre(MouseEvent event) {

        if (!nombreDeSemaine.getText().isEmpty() && !debutStage.getText().isEmpty() && !premiereQualite.getText().isEmpty() && !deuxiemeQualite.getText().isEmpty()) {
            emptyTextfield.setVisible(false);
            String corpLettreMotivation = corpTexte.getText();
            String tourne="tourné";
            String honore="honoré";
            String ravi="ravi";
            if (sexe().equals("Madame")) {
                tourne += "e";
                honore += "e";
                ravi += "e";
            } else if (sexe().equals("Autre")){
                tourne += "·e";
                honore += "·e";
                ravi += "·e";
            }
            String nbSemaine = nombreDeSemaine.getText().toLowerCase();
            String debutStg = debutStage.getText().toLowerCase();
            String firstPerk = premiereQualite.getText().substring(0,1).toUpperCase() + premiereQualite.getText().substring(1).toLowerCase();
            String secondPerk = deuxiemeQualite.getText().toLowerCase();
            String nomPrenom = logginController.connectedUser.getNom() + " " + logginController.connectedUser.getPrenom();
            String corp = corpLettreMotivation
                    .replaceAll("%tourne%", tourne)
                    .replaceAll("%honore%", honore)
                    .replaceAll("%ravi%", ravi)
                    .replaceAll("%nombreSemaines%", nbSemaine)
                    .replaceAll("%dateDebut%", debutStg)
                    .replaceAll("%premiereQualite%", firstPerk)
                    .replaceAll("%deuxiemeQualite%", secondPerk)
                    .replaceAll("%NOMPRENOM%", nomPrenom )
                    ;
            corpTexte.setText(corp);
            anchorScroll.setVisible(true);
        } else {
            emptyTextfield.setVisible(true);
        }

    }

    @FXML
    void retourAnnuaire(MouseEvent event) throws IOException {
        main.nextScene("ficheEntreprise-view.fxml");
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        emptyTextfield.setVisible(false);
        anchorScroll.setVisible(false);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        LocalDateTime now = LocalDateTime.now();

        nomPrenom.setText(logginController.connectedUser.getNom() + ' ' + logginController.connectedUser.getPrenom());
        adresseSup.setText(logginController.connectedAdresse.getNumero() + ' ' + logginController.connectedAdresse.getType_de_voie() + ' ' + logginController.connectedAdresse.getAdresse());
        adresseInf.setText(logginController.connectedAdresse.getCode_postal() + ", " + logginController.connectedAdresse.getVille());

        nomEntreprise.setText(annuaireController.selectedEntreprise.getNom());
        adresseSupEntreprise.setText(ficheEntrepriseController.adresseSelectEntreprise.getNumero() + " " + ficheEntrepriseController.adresseSelectEntreprise.getType_de_voie() + " " + ficheEntrepriseController.adresseSelectEntreprise.getAdresse());
        adresseInfEntreprise.setText(ficheEntrepriseController.adresseSelectEntreprise.getCode_postal() + ", " + ficheEntrepriseController.adresseSelectEntreprise.getVille());

        villeDate.setText("Fait à Vannes, le " + dtf.format(now));

    }
}
