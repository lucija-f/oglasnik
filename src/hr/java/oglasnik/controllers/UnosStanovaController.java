package hr.java.oglasnik.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.List;
import java.util.OptionalLong;

import hr.java.oglasnik.entities.Artikl;
import hr.java.oglasnik.entities.Entitet;
import hr.java.oglasnik.enums.Stanje;
import hr.java.oglasnik.util.Datoteke;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class UnosStanovaController {

    @FXML
    private TextField unosNaslova;

    @FXML
    private TextField unosOpisa;

    @FXML
    private TextField unosKvadratura;

    @FXML
    private TextField unosCijene;

    @FXML
    private ComboBox<Stanje> unosStanje;

    StringBuilder sb = new StringBuilder();
    OptionalLong maxId;
    List<Artikl> listItems;
    Integer vrstaArtikla = 3; // STAN

    public int checkRequestedFields() {
        int i = 2;

        String errorText = "";

        if (unosNaslova.getText().trim().isEmpty()) {
            errorText += "Naslov je obavezan podatak!" + System.lineSeparator();
        }
        if (unosOpisa.getText().trim().isEmpty()) {
            errorText += "Opis je obavezan podatak!" + System.lineSeparator();
        }
        if (unosKvadratura.getText().trim().isEmpty()) {
            errorText += "Kvadratura je obavezan podatak!" + System.lineSeparator();
        }
        if (unosCijene.getText().trim().isEmpty()) {
            errorText += "Cijena je obavezan podatak!" + System.lineSeparator();
        }
        if (unosStanje.getSelectionModel().isEmpty()) {
            errorText += "Stanje je obavezan podatak!" + System.lineSeparator();
        }

        if (errorText != "") {

            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Error Dialog");
            alert.setContentText(errorText);
            alert.showAndWait();

            i = 0;
        } else if (errorText.equals(""))
            i = 1;

        return i;

    }

    @FXML
    public void initialize() {

        unosStanje.getItems().addAll(Stanje.values());

        listItems = Datoteke.dohvatiArtikle();
        maxId = listItems.stream().mapToLong(Entitet::getId).max();

    }

    @FXML
    void unesi(ActionEvent event) {

        if (checkRequestedFields() == 1) {


            sb.append("\n");
            sb.append(vrstaArtikla + "\n");
            sb.append((maxId.getAsLong() + 1) + "\n");
            sb.append(unosNaslova.getText().toString() + "\n");
            sb.append(unosOpisa.getText().toString() + "\n");
            sb.append(unosKvadratura.getText().toString() + "\n");
            sb.append(unosCijene.getText().toString() + "\n");
            sb.append(unosStanje.getSelectionModel().getSelectedIndex() + 1);


            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setContentText("Podaci uspje�no uneseni!");
            alert.showAndWait();

            unosNaslova.clear();
            unosOpisa.clear();
            unosKvadratura.clear();
            unosCijene.clear();
            unosStanje.getSelectionModel().clearSelection();

            try {
                OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(new File("dat//artikli.txt").getAbsoluteFile(), true), Charset.forName("UTF-8").newEncoder());

                out.write(sb.toString());
                out.close();

            } catch (Exception e) {
                e.getStackTrace();
            }

        }

    }

}
