package ihm;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class lettreMotivationController implements Initializable {

    @FXML private Label adresseInf;

    @FXML private Label adresseInfEntreprise;

    @FXML private Label adresseSup;

    @FXML private Label adresseSupEntreprise;

    @FXML private Text corpTexte;

    @FXML private Label nomEntreprise;

    @FXML private Label nomPrenom;

    @FXML private Label villeDate;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        nomPrenom.setText(logginController.connectedUser.getNom() + ' ' + logginController.connectedUser.getPrenom());
        adresseSup.setText(logginController.connectedAdresse.getNumero() + ' ' + logginController.connectedAdresse.getType_de_voie() + ' ' + logginController.connectedAdresse.getAdresse());
    }
}
