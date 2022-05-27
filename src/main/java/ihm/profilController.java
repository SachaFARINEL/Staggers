package ihm;

import dao.AdresseDAO;
import dao.UtilisateurDAO;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import staggers.Adresse;
import staggers.Utilisateur;


import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import static utils.Utils.hashPass;

public class profilController implements Initializable {

    private final String[] arraySexe = {"Monsieur", "Madame", "Autre"};

    Main main = new Main();

    @FXML
    private Label admin;
    @FXML
    private Label wrongEmail;
    @FXML
    private Label wrongPassword;
    @FXML
    private TextField numero;
    @FXML
    private AnchorPane retourLoggin;
    @FXML
    private DatePicker dateNaissance;
    @FXML
    private Label wrongNom;
    @FXML
    private ImageView retourLogginArrow;
    @FXML
    private ChoiceBox<String> sexe;
    @FXML
    private TextField nom;
    @FXML
    private Label wrongDate;
    @FXML
    private PasswordField password;
    @FXML
    private Label wrongCodePostal;
    @FXML
    private Label wrongAdresse;
    @FXML
    private Label wrongPrenom;
    @FXML
    private Label wrongReponse;
    @FXML
    private TextField prenom;
    @FXML
    private TextField email;
    @FXML
    private Button valider;
    @FXML
    private TextField ville;
    @FXML
    private Label labelInscription;
    @FXML
    private TextField telephone;
    @FXML
    private TextField typeDeVoie;
    @FXML
    private TextField codePostal;
    @FXML
    private PasswordField passwordConfirmation;
    @FXML
    private TextField adresse;
    @FXML
    private Label wrongVille;
    @FXML
    private TextField reponseQuestion;
    @FXML
    private Label wrongTelephone;

    @FXML
    private Label labelMonprofil;
    @FXML
    private Label profilUpdated;

    @FXML
    void deconnexion(MouseEvent event) throws IOException {
        main.nextScene("loggin-view.fxml");
    }

    @FXML
    void versActualite(MouseEvent event) throws IOException {
        main.nextScene("accueil-view.fxml");

    }

    @FXML
    void versAnnuaire(MouseEvent event) throws IOException {
        main.nextScene("annuaire-view.fxml");

    }

    @FXML
    void versConseil(MouseEvent event) {

    }

    @FXML
    void versAdmin(MouseEvent event) throws IOException {
        main.nextScene("panneauAdmin-view.fxml");
    }

    @FXML
    void versProfil(MouseEvent event) throws IOException {

    }

    private boolean checkIfEmpty() {
        boolean isNotEmpty = true;
        String sexeSent = sexe.getValue();
        String nomSent = nom.getText();
        String prenomSent = prenom.getText();
        LocalDate dateNaissanceSent = dateNaissance.getValue();
        String emailSent = email.getText();
        String telephoneSent = telephone.getText();
        String numeroSent = numero.getText();
        String voieSent = typeDeVoie.getText();
        String adresseSent = adresse.getText();
        String codePostalSent = codePostal.getText();
        String villeSent = ville.getText();

        if (sexeSent.isEmpty()) {
            isNotEmpty = false;
        }
        if (nomSent.isEmpty()) {
            wrongNom.setText("Nom obligatoire");
            isNotEmpty = false;
        } else {
            wrongNom.setText("");
        }
        if (prenomSent.isEmpty()) {
            wrongPrenom.setText("Prenom obligatoire");
            isNotEmpty = false;
        } else {
            wrongPassword.setText("");

        }
        if (dateNaissanceSent == null) {
            wrongDate.setText("Date de naissance obligatoire");
            isNotEmpty = false;
        } else {
            wrongDate.setText("");

        }
        if (emailSent.isEmpty()) {
            wrongEmail.setText("Email obligatoire");
            isNotEmpty = false;
        } else {
            wrongEmail.setText("");
        }
        if (telephoneSent.isEmpty()) {
            wrongTelephone.setText("Téléphone obligatoire");
            isNotEmpty = false;
        } else {
            wrongTelephone.setText("");

        }
        if (numeroSent.isEmpty() || voieSent.isEmpty() || adresseSent.isEmpty()) {
            wrongAdresse.setText("Adresse complète obligatoire");
            isNotEmpty = false;
        } else {
            wrongAdresse.setText("");

        }
        if (codePostalSent.isEmpty()) {
            wrongCodePostal.setText("Code postal obligatoire");
            isNotEmpty = false;
        } else {
            wrongCodePostal.setText(null);

        }
        if (villeSent.isEmpty()) {
            wrongVille.setText("Ville obligatoire");
            isNotEmpty = false;
        } else {
            wrongVille.setText("");

        }
        return isNotEmpty;
    }

    private boolean isMotDePasseConfirmed() {
        boolean mdpConfirmed = true;
        if (!password.getText().equals(passwordConfirmation.getText())) {
            mdpConfirmed = false;
            wrongPassword.setText("Les mots de passe ne sont pas identiques");
        } else {
            wrongPassword.setText("");
        }
        return mdpConfirmed;
    }

    @FXML
    void updateProfil(ActionEvent event) throws NoSuchAlgorithmException, InvalidKeySpecException {
        if (checkIfEmpty()) {
            wrongPassword.setVisible(false);

            LocalDate dateNaissanceSent = dateNaissance.getValue();
            LocalDateTime dateNaiss = dateNaissanceSent.atTime(0, 0);
            String MDP;
            if (password.getText().isEmpty() && passwordConfirmation.getText().isEmpty()) {
                MDP = logginController.connectedUser.getMot_de_passe();
            } else {
                MDP = hashPass(password.getText());
            }

            if (password.getText().equals(passwordConfirmation.getText())) {
                Utilisateur changedUtilisateur = new Utilisateur(logginController.connectedUser.getId(), logginController.connectedUser.getPromo(), nom.getText(), prenom.getText(),
                        dateNaiss, email.getText(), telephone.getText(), logginController.connectedUser.isAdmis_stage(), sexe.getValue(), MDP,
                        logginController.connectedUser.isEst_admin(), logginController.connectedUser.getRole(), logginController.connectedUser.getQuestion_secrete());

                Adresse changedAdresse = new Adresse(logginController.connectedAdresse.getId(), numero.getText(), typeDeVoie.getText(),
                        adresse.getText(), ville.getText(), codePostal.getText(), logginController.connectedUser.getId());
                if (AdresseDAO.getInstance().updateWithoutIdEntreprise(changedAdresse) && UtilisateurDAO.getInstance().update(changedUtilisateur)) {
                    labelMonprofil.setVisible(false);
                    profilUpdated.setVisible(true);
                    logginController.connectedUser = changedUtilisateur;
                    logginController.connectedAdresse = changedAdresse;
                    Timeline timeline = new Timeline(new KeyFrame(
                            Duration.millis(1000),
                            ae -> {
                                labelMonprofil.setVisible(true);
                                profilUpdated.setVisible(false);
                            }));
                    timeline.play();
                }

            } else {
                wrongPassword.setVisible(true);
                wrongPassword.setText("Les deux mots de passe ne sont pas identiques");
            }
        }
    }


//            if (password.getText().isEmpty() && passwordConfirmation.getText().isEmpty()) {
//
//                Utilisateur changedUtilisateur = new Utilisateur(logginController.connectedUser.getId(), logginController.connectedUser.getPromo(), nom.getText(), prenom.getText(),
//                        dateNaiss, email.getText(), telephone.getText(), logginController.connectedUser.isAdmis_stage(), sexe.getValue(), logginController.connectedUser.getMot_de_passe(),
//                        logginController.connectedUser.isEst_admin(), logginController.connectedUser.getRole(), logginController.connectedUser.getQuestion_secrete());
//
//                Adresse changedAdresse = new Adresse(logginController.connectedAdresse.getId(), numero.getText(), typeDeVoie.getText(),
//                        adresse.getText(), ville.getText(), codePostal.getText(), logginController.connectedUser.getId());
//
//                if (AdresseDAO.getInstance().updateWithoutIdEntreprise(changedAdresse) && UtilisateurDAO.getInstance().updateProfilUtilisateurWithoutPassword(changedUtilisateur)) {
//                    labelMonprofil.setVisible(false);
//                    profilUpdated.setVisible(true);
//                    logginController.connectedUser = changedUtilisateur;
//                    logginController.connectedAdresse = changedAdresse;
//                }
//                Timeline timeline = new Timeline(new KeyFrame(
//                        Duration.millis(1000),
//                        ae -> {
//                            labelMonprofil.setVisible(true);
//                            profilUpdated.setVisible(false);
//                        }));
//                timeline.play();
//            } else if (isMotDePasseConfirmed()) {
//                Utilisateur changedUtilisateur = new Utilisateur(logginController.connectedUser.getId(), nom.getText(), prenom.getText(),
//                        dateNaiss, email.getText(), telephone.getText(), sexe.getValue(), password.getText());
//                Adresse changedAdresse = new Adresse(logginController.connectedAdresse.getId(), numero.getText(), typeDeVoie.getText(),
//                        adresse.getText(), ville.getText(), codePostal.getText(), logginController.connectedUser.getId());
//                if (AdresseDAO.getInstance().updateWithoutIdEntreprise(changedAdresse) && UtilisateurDAO.getInstance().updateProfilUtilisateurWithPassword(changedUtilisateur)) {
//                    labelMonprofil.setVisible(false);
//                    profilUpdated.setVisible(true);
//                    logginController.connectedUser = changedUtilisateur;
//                    logginController.connectedAdresse = changedAdresse;
//                }
//                Timeline timeline = new Timeline(new KeyFrame(
//                        Duration.millis(1000),
//                        ae -> {
//                            labelMonprofil.setVisible(true);
//                            profilUpdated.setVisible(false);
//                        }));
//                timeline.play();
//            } else {
//                wrongPassword.setVisible(true);
//                wrongPassword.setText("Les deux mots de passe ne sont pas identiques");
//            }
//        }


//    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        profilUpdated.setVisible(false);
        admin.setVisible(logginController.connectedUser.isEst_admin());

        nom.setText(logginController.connectedUser.getNom());
        prenom.setText(logginController.connectedUser.getPrenom());
        email.setText(logginController.connectedUser.getEmail());
        numero.setText(logginController.connectedAdresse.getNumero());
        typeDeVoie.setText(logginController.connectedAdresse.getType_de_voie());
        adresse.setText(logginController.connectedAdresse.getAdresse());
        ville.setText(logginController.connectedAdresse.getVille());
        codePostal.setText(logginController.connectedAdresse.getCode_postal());
        telephone.setText(logginController.connectedUser.getNum_tel());
        LocalDate dateNaiss = logginController.connectedUser.getDate_naissance().toLocalDate();
        dateNaissance.setValue(dateNaiss);
        sexe.setValue(logginController.connectedUser.getSexe());
        sexe.getItems().addAll(arraySexe);
    }

}


