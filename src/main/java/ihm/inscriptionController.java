package ihm;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class inscriptionController implements Initializable {


    private final String[] arraySexe = {"M", "Mme", "Autre"};

    @FXML
    private ChoiceBox<String> sexe;

    @FXML
    private AnchorPane retourLoggin;

    @FXML
    private ImageView retourLogginArrow;


    @FXML
    void sendLoggin(MouseEvent event) throws IOException {
        Main main = new Main();
        main.nextScene("loggin-view.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sexe.getItems().addAll(arraySexe);
    }

}
