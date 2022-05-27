package ihm;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class lettreMotivationController implements Initializable {

    Main main = new Main();

    @FXML
    private Label adresseInf;
    @FXML
    private Label adresseInfEntreprise;
    @FXML
    private Label adresseSup;
    @FXML
    private Label adresseSupEntreprise;
    @FXML
    private Text corpTexte;
    @FXML
    private Label nomEntreprise;
    @FXML
    private Label nomPrenom;
    @FXML
    private Label villeDate;
    @FXML
    private AnchorPane anchorScroll;
    @FXML
    private TextField nombreDeSemaine;
    @FXML
    private TextField debutStage;
    @FXML
    private TextField premiereQualite;
    @FXML
    private TextField deuxiemeQualite;
    @FXML
    private Text emptyTextfield;
    @FXML
    private ImageView saveIcon;
    @FXML
    private Label objet;
    @FXML
    private Label madameMonsieur;
    @FXML
    private Label wrongPath;
    @FXML
    private TextField pathToFile;
    @FXML
    private Label indicationPath;
    @FXML
    private Label downloadDone;

    @FXML
    void retourAnnuaire(MouseEvent event) throws IOException {
        main.nextScene("ficheEntreprise-view.fxml");
    }

    @FXML
    void save(MouseEvent event) {
        if (!nombreDeSemaine.getText().isEmpty() && !debutStage.getText().isEmpty() && !premiereQualite.getText().isEmpty() && !deuxiemeQualite.getText().isEmpty()) {
            emptyTextfield.setVisible(false);
            wrongPath.setVisible(false);
            indicationPath.setVisible(true);


            String path = pathToFile.getText() + "/";
            String LMForSave = (
                    nomPrenom.getText() + "\n" + adresseSup.getText() + "\n" + adresseInf.getText() + "\n" + "\n"
                            + nomEntreprise.getText() + "\n" + adresseSupEntreprise.getText() + "\n"
                            + adresseInfEntreprise.getText() + "\n" + "\n" + villeDate.getText() + "\n" + "\n"
                            + objet.getText() + "\n" + "\n" + madameMonsieur.getText() + "\n" + corpTexte.getText()
            );
            try {
                String name = path + "LM-" + logginController.connectedUser.getNom()
                        + "-" + annuaireController.selectedEntreprise.getNom() + ".doc";
                FileOutputStream fos = new FileOutputStream(name, true);
                // true for append mode

                //str stores the string which we have entered
                byte[] b = LMForSave.getBytes(); //converts string into bytes
                fos.write(b); //writes bytes into file
                fos.close(); //close the file
                downloadDone.setVisible(true);
            } catch (Exception e) {
                System.out.println("Exception Occurred:");
                e.printStackTrace();
                wrongPath.setVisible(true);
                indicationPath.setVisible(false);

            }
        } else {
            emptyTextfield.setVisible(true);
        }
    }

    @FXML
    void genererLettre(MouseEvent event) {

        if (!nombreDeSemaine.getText().isEmpty() && !debutStage.getText().isEmpty() && !premiereQualite.getText().isEmpty() && !deuxiemeQualite.getText().isEmpty()) {
            emptyTextfield.setVisible(false);
            pathToFile.setVisible(true);
            saveIcon.setVisible(true);
            indicationPath.setVisible(!wrongPath.isVisible());
            String corpLettreMotivation = corpTexte.getText();
            String tourne = "tourné";
            String honore = "honoré";
            String ravi = "ravi";
            String sexe = logginController.connectedUser.getSexe();
            if (sexe.equals("Madame")) {
                tourne += "e";
                honore += "e";
                ravi += "e";
            } else if (sexe.equals("Autre")) {
                tourne += "·e";
                honore += "·e";
                ravi += "·e";
            }
            String nbSemaine = nombreDeSemaine.getText().toLowerCase();
            String debutStg = debutStage.getText().toLowerCase();
            String firstPerk = premiereQualite.getText().substring(0, 1).toUpperCase() + premiereQualite.getText().substring(1).toLowerCase();
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
                    .replaceAll("%NOMPRENOM%", nomPrenom);
            corpTexte.setText(corp);
            anchorScroll.setVisible(true);
        } else {
            emptyTextfield.setVisible(true);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        wrongPath.setVisible(false);
        emptyTextfield.setVisible(false);
        pathToFile.setVisible(false);
        saveIcon.setVisible(false);
        anchorScroll.setVisible(false);
        indicationPath.setVisible(false);
        downloadDone.setVisible(false);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        LocalDateTime now = LocalDateTime.now();

        nomPrenom.setText(logginController.connectedUser.getNom() + ' ' + logginController.connectedUser.getPrenom());
        adresseSup.setText(logginController.connectedAdresse.getNumero() + ' ' + logginController.connectedAdresse.getType_de_voie() + ' ' + logginController.connectedAdresse.getAdresse());
        adresseInf.setText(logginController.connectedAdresse.getCode_postal() + ", " + logginController.connectedAdresse.getVille());

        nomEntreprise.setText(annuaireController.selectedEntreprise.getNom());
        adresseSupEntreprise.setText(annuaireController.adresseSelectEntreprise.getNumero() + " " + annuaireController.adresseSelectEntreprise.getType_de_voie() + " " + annuaireController.adresseSelectEntreprise.getAdresse());
        adresseInfEntreprise.setText(annuaireController.adresseSelectEntreprise.getCode_postal() + ", " + annuaireController.adresseSelectEntreprise.getVille());

        villeDate.setText("Fait à Vannes, le " + dtf.format(now));

    }
}
