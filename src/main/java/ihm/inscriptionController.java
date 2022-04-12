package ihm;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ResourceBundle;

public class inscriptionController implements Initializable {

    private final String[] arraySexe = {"M", "Mme", "Autre"};

    @FXML
    private ChoiceBox<String> sexe;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sexe.getItems().addAll(arraySexe);

    }
}
