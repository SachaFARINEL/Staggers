package ihm;

import dao.EntrepriseDAO;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.util.Duration;
import staggers.Entreprise;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class accueilController {
    Main main = new Main();

    @FXML
    private Label annuaire;

    @FXML
    private Label conseils;

    @FXML
    private Button deco;

    @FXML
    private Label fil_actualite;

    @FXML
    private Label profil;

    @FXML
    void deconnexion(MouseEvent event) throws IOException {
        main.nextScene("loggin-view.fxml");
    }

    @FXML
    void versActualite(MouseEvent event) {

    }

    @FXML
    void versAnnuaire(MouseEvent event) throws IOException {
        main.nextScene("annuaire-view.fxml");
    }

    @FXML
    void versConseil(MouseEvent event) throws IOException {

    }

    @FXML
    void versProfil(MouseEvent event) {

    }

    @FXML
    private FlowPane container;


    List<Entreprise> listeEntreprise = EntrepriseDAO.getInstance().readAll();
    public void initialize() {

        for (Entreprise entreprise : listeEntreprise) {
            int idEntreprise = entreprise.getId();
            String nomEntreprise = entreprise.getNom();
            String emailEntreprise = entreprise.getEmail();
            Label label = new Label(nomEntreprise);
            Label label1 = new Label(emailEntreprise);

            container.getChildren().add(label);
            container.getChildren().add(label1);

        }
        }

    }

    /*
    <ImageView fx:id="img_ent_default%id%" layoutX="37.0" layoutY="22.0">
                                   <image>
                                    <Image url="@../img/entreprise_default.png" />
                                    </image>
                                  </ImageView>


    private void affichageListeEntreprise() throws IOException {
        List<Entreprise> listeEntreprise = EntrepriseDAO.getInstance().readAll();
        StringBuilder sb = new StringBuilder();

        String template =
                """
                        <AnchorPane layoutX="236.0" layoutY="%height%" prefHeight="150.0" prefWidth="533.0">
                                 <children>
                                 
                                    <Label fx:id="nomEntreprise%id%" alignment="CENTER" layoutX="260.0" prefHeight="79.0" prefWidth="254.0" text="%nomEntreprise%" textAlignment="JUSTIFY">
                                       <font>
                                          <Font size="49.0" />
                                       </font>
                                    </Label>
                                    <Button fx:id="details%id%" layoutX="526.0" layoutY="114.0" mnemonicParsing="false" text="Détails" />
                                    <Label fx:id="villeEntreprise%id%" alignment="CENTER" layoutX="303.0" layoutY="92.0" prefHeight="35.0" prefWidth="169.0" text="%villeEntreprise%" textAlignment="CENTER">
                                       <font>
                                          <Font size="24.0" />
                                       </font>
                                    </Label>
                                 </children>
                              </AnchorPane>
                        """;
        int hauteur = 140;
        for (Entreprise entreprise : listeEntreprise) {

            int idEntreprise = entreprise.getId();
            String nomEntreprise = entreprise.getNom();
            String emailEntreprise = entreprise.getEmail();

            sb.append(
                    template
                            .replaceAll("%height%", String.valueOf(hauteur))
                            .replaceAll("%id%", String.valueOf(idEntreprise))
                            .replaceAll("%nomEntreprise%", nomEntreprise)
                            .replaceAll("%villeEntreprise%", emailEntreprise)
            );
            hauteur += 185;

        }

        String outer =
                """
                        <?xml version="1.0" encoding="UTF-8"?>             
                        <?import javafx.scene.control.Button?>
                        <?import javafx.scene.control.Label?>
                        <?import javafx.scene.control.ListView?>
                        <?import javafx.scene.image.Image?>
                        <?import javafx.scene.image.ImageView?>
                        <?import javafx.scene.layout.AnchorPane?>
                        <?import javafx.scene.layout.Pane?>
                        <?import javafx.scene.text.Font?>
                                       
                        <Pane maxHeight="-Infinity" maxWidth="-Infinity" minHeight="-Infinity" minWidth="-Infinity" prefHeight="600.0" prefWidth="1064.0" xmlns="http://javafx.com/javafx/17" xmlns:fx="http://javafx.com/fxml/1" fx:controller="ihm.annuaireController">
                            <children>
                                <AnchorPane prefHeight="81.0" prefWidth="1064.0" style="-fx-background-color: #4C6B77;">
                                    <children>
                                        <Label fx:id="fil_actualite" layoutX="163.0" layoutY="27.0" onMouseClicked="#versActualite" style="-fx-cursor: hand;" text="Fil d'actualité" textFill="WHITE">
                                            <font>
                                                <Font name="System Bold Italic" size="20.0" />
                                            </font>
                                        </Label>
                                        <Label fx:id="conseils" layoutX="612.0" layoutY="26.0" onMouseClicked="#versConseil" style="-fx-cursor: hand;" text="Conseils" textFill="WHITE">
                                            <font>
                                                <Font name="System Bold Italic" size="20.0" />
                                            </font>
                                        </Label>
                                        <Label fx:id="profil" layoutX="736.0" layoutY="26.0" onMouseClicked="#versProfil" style="-fx-cursor: hand;" text="Mon profil" textFill="WHITE">
                                            <font>
                                                <Font name="System Bold Italic" size="20.0" />
                                            </font>
                                        </Label>
                                        <Label fx:id="annuaire" layoutX="337.0" layoutY="26.0" onMouseClicked="#versAnnuaire" style="-fx-cursor: hand;" text="Annuaire" textFill="#20df7f">
                                            <font>
                                                <Font name="System Bold Italic" size="20.0" />
                                            </font>
                                       </Label>
                                       <Button fx:id="deco" layoutX="934.0" layoutY="26.0" mnemonicParsing="false" onMouseClicked="#deconnexion" style="-fx-background-color: #20DF7F; -fx-cursor: hand;" text="Se déconnecter" textFill="WHITE">
                                            <font>
                                                <Font name="System Bold Italic" size="14.0" />
                                            </font>
                                       </Button>
                                    </children>
                                </AnchorPane>
                                 %content%
                            </children>
                        </Pane>
                                """;
        String done = outer.replaceAll("%content%", sb.toString());
        FileOutputStream out = new FileOutputStream("src/main/resources/ihm/annuaire-view2.fxml");

        out.write(done.getBytes());
        out.close();
        FXMLLoader loader = new FXMLLoader();
        try {
            loader.load(new FileInputStream("src/main/resources/ihm/annuaire-view2.fxml"));

        } catch (FileNotFoundException ex) {
            System.out.println(" INPUT File not found !");
        }
    }

}
*/