package hr.java.oglasnik.controllers;

import java.util.List;
import java.util.stream.Collectors;

import hr.java.oglasnik.entities.Automobil;
import hr.java.oglasnik.util.Datoteke;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class PretragaAutomobilaController {

    @FXML
    private TextField unosNaslova;

    @FXML
    private TextField unosOpisa;

    @FXML
    private TextField unosSnage;

    @FXML
    private TextField unosCijene;

    @FXML
    private TableView<Automobil> tablicaPodataka;


    @FXML
    private TableColumn<Automobil, String> kolonaNaslov;

    @FXML
    private TableColumn<Automobil, String> kolonaOpis;

    @FXML
    private TableColumn<Automobil, String> kolonaSnaga;

    @FXML
    private TableColumn<Automobil, String> kolonaCijena;

    @FXML
    private TableColumn<Automobil, String> kolonaStanje;

    List<Automobil> listaAutomobila;

    @FXML
    public void initialize() {

        listaAutomobila = Datoteke.dohvatiArtikle().stream().filter(p -> p instanceof Automobil).map(sc -> (Automobil) sc).collect(Collectors.toList());

        tablicaPodataka.setItems(FXCollections.observableArrayList(listaAutomobila));

        kolonaNaslov.setCellValueFactory(new PropertyValueFactory<Automobil, String>("naslov"));
        kolonaOpis.setCellValueFactory(new PropertyValueFactory<Automobil, String>("opis"));
        kolonaSnaga.setCellValueFactory(new PropertyValueFactory<Automobil, String>("snagaKs"));
        kolonaCijena.setCellValueFactory(new PropertyValueFactory<Automobil, String>("cijena"));
        kolonaStanje.setCellValueFactory(new PropertyValueFactory<Automobil, String>("stanje"));

    }


    @FXML
    void pretrazi(ActionEvent event) {

        List<Automobil> filtriranaListaAutomobila = listaAutomobila.stream()
                .filter(ob -> ob.getNaslov().toLowerCase().contains(unosNaslova.getText().toLowerCase()))
                .filter(ob -> ob.getOpis().toLowerCase().contains(unosOpisa.getText().toLowerCase()))
                .filter(ob -> ob.getSnagaKs().toString().toLowerCase().contains(unosSnage.getText().toLowerCase()))
                .filter(ob -> ob.getCijena().toString().toLowerCase().contains(unosCijene.getText().toLowerCase()))
                .collect(Collectors.toList());

        tablicaPodataka.setItems(FXCollections.observableArrayList(filtriranaListaAutomobila));
    }

}
