package hr.java.oglasnik.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.List;
import java.util.OptionalLong;

import hr.java.oglasnik.entities.Entitet;
import hr.java.oglasnik.entities.Korisnik;
import hr.java.oglasnik.util.Datoteke;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class UnosPrivatnihController {

    @FXML
    private TextField unosIme;

    @FXML
    private TextField unosPrezime;

    @FXML
    private TextField unosEmail;

    @FXML
    private TextField unosTelefon;

    StringBuilder sb = new StringBuilder();
    OptionalLong maxId;
    List<Korisnik> listItems;
    Integer vrstaKorisnika = 1; // PRIVATNI KORISNIK

    public int checkRequestedFields() {
        int i = 2;

        String errorText = "";

        if (unosIme.getText().trim().isEmpty()) {
            errorText += "Ime je obavezan podatak!" + System.lineSeparator();
        }
        if (unosPrezime.getText().trim().isEmpty()) {
            errorText += "Prezime je obavezan podatak!" + System.lineSeparator();
        }
        if (unosEmail.getText().trim().isEmpty()) {
            errorText += "E-mail je obavezan podatak!" + System.lineSeparator();
        }
        if (unosTelefon.getText().trim().isEmpty()) {
            errorText += "Telefon je obavezan podatak!" + System.lineSeparator();
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
    public void initialize() throws IOException {

        listItems = Datoteke.dohvatiKorisnike();
        maxId = listItems.stream().mapToLong(Entitet::getId).max();

    }

    @FXML
    void unesi(ActionEvent event) {

        if (checkRequestedFields() == 1) {

            sb.append("\n");
            sb.append(vrstaKorisnika + "\n");
            sb.append((maxId.getAsLong() + 1) + "\n");
            sb.append(unosIme.getText().toString() + "\n");
            sb.append(unosPrezime.getText().toString() + "\n");
            sb.append(unosEmail.getText().toString() + "\n");
            sb.append(unosTelefon.getText().toString() + "\n");

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setContentText("Podaci uspje�no uneseni!");
            alert.showAndWait();

            unosIme.clear();
            unosPrezime.clear();
            unosEmail.clear();
            unosTelefon.clear();

            try {
                OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(new File("dat//korisnici.txt").getAbsoluteFile(), true), Charset.forName("UTF-8").newEncoder());

                out.write(sb.toString());
                out.close();

            } catch (Exception e) {
                e.getStackTrace();
            }

        }

    }

}
