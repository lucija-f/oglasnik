package hr.java.oglasnik.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage window;
    private static BorderPane root;


    @Override
    public void start(Stage primaryStage) {

        window = primaryStage;

        try {
            root = (BorderPane) FXMLLoader.load(getClass().getResource("../resources/pocetno.fxml"));
            Scene scene = new Scene(root, 600, 500);
            scene.getStylesheets().add(getClass().getResource("../resources/application.css").toExternalForm());
            window.setScene(scene);
            window.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void setCenterScene(BorderPane sredina) {

        root.setCenter(sredina);
    }

}
