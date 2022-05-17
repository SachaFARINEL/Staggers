package ihm;

import dao.FavorisDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import staggers.Favoris;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ficheEntrepriseController implements Initializable {

    private int id_utilisateur = logginController.connectedUser.getId();
    private int id_selectedEntreprise = annuaireController.selectedEntreprise.getId();

    Main main = new Main();

    @FXML
    private Label nomEntreprise;

    @FXML
    private AnchorPane retourAnnuaire;

    @FXML
    private ImageView retourAnnuaireArrow;

    @FXML
    private ImageView isFavoris;

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



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    nomEntreprise.setText(annuaireController.selectedEntreprise.getNom());

    if (FavorisDAO.getInstance().isFavoris(id_utilisateur, id_selectedEntreprise)) {
        isFavoris.setImage(new Image(Objects.requireNonNull(Main.class.getResourceAsStream("img/star.png"))));
    } else {
        isFavoris.setImage(new Image(Objects.requireNonNull(Main.class.getResourceAsStream("img/emptyStar.png"))));
    }
    }
}
