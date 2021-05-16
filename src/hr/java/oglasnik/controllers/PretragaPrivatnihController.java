package hr.java.oglasnik.controllers;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import hr.java.oglasnik.entities.PrivatniKorisnik;
import hr.java.oglasnik.util.Datoteke;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class PretragaPrivatnihController {

    @FXML
    private TextField unosIme;

    @FXML
    private TextField unosPrezime;

    @FXML
    private TextField unosMaila;

    @FXML
    private TextField unosTelefon;

    @FXML
    private TableView<PrivatniKorisnik> tablicaPodataka;

    @FXML
    private TableColumn<PrivatniKorisnik, String> kolonaIme;

    @FXML
    private TableColumn<PrivatniKorisnik, String> kolonaPrezime;

    @FXML
    private TableColumn<PrivatniKorisnik, String> kolonaMaila;

    @FXML
    private TableColumn<PrivatniKorisnik, String> kolonaTelefon;


    List<PrivatniKorisnik> listaPrivatnih;

    @FXML
    public void initialize() throws IOException {

        listaPrivatnih = Datoteke.dohvatiKorisnike().stream().filter(p -> p instanceof PrivatniKorisnik).map(sc -> (PrivatniKorisnik) sc).collect(Collectors.toList());

        tablicaPodataka.setItems(FXCollections.observableArrayList(listaPrivatnih));

        kolonaIme.setCellValueFactory(new PropertyValueFactory<PrivatniKorisnik, String>("ime"));
        kolonaPrezime.setCellValueFactory(new PropertyValueFactory<PrivatniKorisnik, String>("prezime"));
        kolonaMaila.setCellValueFactory(new PropertyValueFactory<PrivatniKorisnik, String>("email"));
        kolonaTelefon.setCellValueFactory(new PropertyValueFactory<PrivatniKorisnik, String>("telefon"));


    }


    @FXML
    void pretrazi(ActionEvent event) {

        List<PrivatniKorisnik> filtriranaListaPrivatnih = listaPrivatnih.stream()
                .filter(ob -> ob.getIme().toLowerCase().contains(unosIme.getText().toLowerCase()))
                .filter(ob -> ob.getTelefon().toLowerCase().contains(unosTelefon.getText().toLowerCase()))
                .filter(ob -> ob.getEmail().toString().toLowerCase().contains(unosMaila.getText().toLowerCase()))
                .filter(ob -> ob.getPrezime().toString().toLowerCase().contains(unosPrezime.getText().toLowerCase()))
                .collect(Collectors.toList());

        tablicaPodataka.setItems(FXCollections.observableArrayList(filtriranaListaPrivatnih));
    }

}
