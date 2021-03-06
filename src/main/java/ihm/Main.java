package ihm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    private static Stage stg;


    @Override
    public void start(Stage stage) throws IOException {
        stg = stage;
        stage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("loggin-view.fxml"));
        System.out.println(Main.class.getResource("loggin-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1064, 600);
        scene.getStylesheets().add("styles.css");
        stage.setTitle("Staggers");
        stage.getIcons().add(new Image(Objects.requireNonNull(Main.class.getResourceAsStream("img/favico.png"))));
        stage.setScene(scene);
        stage.show();
    }

    public void nextScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxml)));
        stg.getScene().setRoot(pane);
    }

    public static void main(String[] args) {
        launch();
    }

}
