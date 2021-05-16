package hr.java.oglasnik.controllers;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import hr.java.oglasnik.entities.PoslovniKorisnik;
import hr.java.oglasnik.util.Datoteke;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class PretragaPoslovnihController {

    @FXML
    private TextField unosNaziva;

    @FXML
    private TextField unosTelefona;

    @FXML
    private TextField unosMaila;

    @FXML
    private TextField unosWeba;

    @FXML
    private TableView<PoslovniKorisnik> tablicaPodataka;

    @FXML
    private TableColumn<PoslovniKorisnik, String> kolonaNaziva;

    @FXML
    private TableColumn<PoslovniKorisnik, String> kolonaTelefona;

    @FXML
    private TableColumn<PoslovniKorisnik, String> kolonaMaila;

    @FXML
    private TableColumn<PoslovniKorisnik, String> kolonaWeba;


    List<PoslovniKorisnik> listaPoslovnih;

    @FXML
    public void initialize() throws IOException {

        listaPoslovnih = Datoteke.dohvatiKorisnike().stream().filter(p -> p instanceof PoslovniKorisnik).map(sc -> (PoslovniKorisnik) sc).collect(Collectors.toList());

        tablicaPodataka.setItems(FXCollections.observableArrayList(listaPoslovnih));

        kolonaNaziva.setCellValueFactory(new PropertyValueFactory<PoslovniKorisnik, String>("naziv"));
        kolonaTelefona.setCellValueFactory(new PropertyValueFactory<PoslovniKorisnik, String>("telefon"));
        kolonaMaila.setCellValueFactory(new PropertyValueFactory<PoslovniKorisnik, String>("email"));
        kolonaWeba.setCellValueFactory(new PropertyValueFactory<PoslovniKorisnik, String>("web"));


    }


    @FXML
    void pretrazi(ActionEvent event) {

        List<PoslovniKorisnik> filtriranaListaPoslovnih = listaPoslovnih.stream()
                .filter(ob -> ob.getNaziv().toLowerCase().contains(unosNaziva.getText().toLowerCase()))
                .filter(ob -> ob.getTelefon().toLowerCase().contains(unosTelefona.getText().toLowerCase()))
                .filter(ob -> ob.getEmail().toString().toLowerCase().contains(unosMaila.getText().toLowerCase()))
                .filter(ob -> ob.getWeb().toString().toLowerCase().contains(unosWeba.getText().toLowerCase()))
                .collect(Collectors.toList());

        tablicaPodataka.setItems(FXCollections.observableArrayList(filtriranaListaPoslovnih));
    }

}
