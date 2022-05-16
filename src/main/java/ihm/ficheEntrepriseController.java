package ihm;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ficheEntrepriseController implements Initializable {

    Main main = new Main();

    @FXML
    private Label nomEntreprise;

    @FXML
    private AnchorPane retourAnnuaire;

    @FXML
    private ImageView retourAnnuaireArrow;

    @FXML
    private ImageView nonFavoris;

    @FXML
    void changeStar(MouseEvent event) {
        nonFavoris.setImage(new Image(Objects.requireNonNull(Main.class.getResourceAsStream("img/star.png"))));
    }

    @FXML
    void retourAnnuaire(MouseEvent event) throws IOException {
        main.nextScene("annuaire-view.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    nomEntreprise.setText("Entreprise" + " " + annuaireController.selectedEntreprise.getNom());
    }
}
