package ihm;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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

    private String sexe() {
        return logginController.connectedUser.getSexe();
    }

    @FXML void genererLettre(MouseEvent event) {

        String corpLettreMotivation = corpTexte.getText();
        String tourne="tourné";
        String honore="honoré";
        String ravi="ravi";
        System.out.println(sexe());
        if (sexe().equals("Madame")) {
            tourne += "e";
            honore += "e";
            ravi += "e";
        } else if (sexe().equals("Autre")){
            tourne += "·e";
            honore += "·e";
            ravi += "·e";
        }
        String corp = corpLettreMotivation
                .replaceAll("%tourne%", tourne)
                .replaceAll("%honore%", honore)
                .replaceAll("%ravi%", ravi)
                .replaceAll("%nombreSemaines%", nombreDeSemaine.getText())

                ;
        corpTexte.setText(corp);
        anchorScroll.setVisible(true);
    }

    @FXML
    void retourAnnuaire(MouseEvent event) throws IOException {
        main.nextScene("ficheEntreprise-view.fxml");
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

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
