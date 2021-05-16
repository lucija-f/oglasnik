package hr.java.oglasnik.controllers;

import hr.java.oglasnik.main.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

public class PocetnoController {

    @FXML
    void prikaziPretraguAutomobila(ActionEvent event) {
        try {
            BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("../resources/pretragaAutomobila.fxml"));

            Main.setCenterScene(root);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void prikaziPretraguPoslovnih(ActionEvent event) {
        try {
            BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("../resources/pretragaPoslovnih.fxml"));

            Main.setCenterScene(root);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void prikaziPretraguPrivatnih(ActionEvent event) {
        try {
            BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("../resources/pretragaPrivatnih.fxml"));

            Main.setCenterScene(root);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void prikaziPretraguStanova(ActionEvent event) {
        try {
            BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("../resources/pretragaStanova.fxml"));

            Main.setCenterScene(root);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void prikraziPretraguUsluga(ActionEvent event) {
        try {
            BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("../resources/pretragaUsluga.fxml"));

            Main.setCenterScene(root);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void prikaziUnosAutomobila(ActionEvent event) {
        try {
            BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("../resources/unosAutomobila.fxml"));

            Main.setCenterScene(root);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void prikaziUnosStanova(ActionEvent event) {
        try {
            BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("../resources/unosStanova.fxml"));

            Main.setCenterScene(root);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    void prikaziUnosUsluga(ActionEvent event) {
        try {
            BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("../resources/unosUsluga.fxml"));

            Main.setCenterScene(root);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void prikaziUnosPrivatnih(ActionEvent event) {
        try {
            BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("../resources/unosPrivatnih.fxml"));

            Main.setCenterScene(root);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void prikaziUnosPoslovnih(ActionEvent event) {
        try {
            BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("../resources/unosPoslovnih.fxml"));

            Main.setCenterScene(root);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
