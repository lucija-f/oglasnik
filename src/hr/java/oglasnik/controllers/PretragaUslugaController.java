package hr.java.oglasnik.controllers;

import java.util.List;
import java.util.stream.Collectors;

import hr.java.oglasnik.entities.Usluga;
import hr.java.oglasnik.util.Datoteke;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class PretragaUslugaController {

    @FXML
    private TextField unosNaslova;

    @FXML
    private TextField unosOpisa;

    @FXML
    private TextField unosCijene;

    @FXML
    private TableView<Usluga> tablicaPodataka;

    @FXML
    private TableColumn<Usluga, String> kolonaNaslov;

    @FXML
    private TableColumn<Usluga, String> kolonaOpis;

    @FXML
    private TableColumn<Usluga, String> kolonaCijena;

    @FXML
    private TableColumn<Usluga, String> kolonaStanje;

    List<Usluga> listaUsluga;

    @FXML
    public void initialize() {

        listaUsluga = Datoteke.dohvatiArtikle().stream().filter(p -> p instanceof Usluga).map(sc -> (Usluga) sc).collect(Collectors.toList());

        tablicaPodataka.setItems(FXCollections.observableArrayList(listaUsluga));

        kolonaNaslov.setCellValueFactory(new PropertyValueFactory<Usluga, String>("naslov"));
        kolonaOpis.setCellValueFactory(new PropertyValueFactory<Usluga, String>("opis"));
        kolonaCijena.setCellValueFactory(new PropertyValueFactory<Usluga, String>("cijena"));
        kolonaStanje.setCellValueFactory(new PropertyValueFactory<Usluga, String>("stanje"));

    }


    @FXML
    void pretrazi(ActionEvent event) {

        List<Usluga> filtriranaListaUsluga = listaUsluga.stream()
                .filter(ob -> ob.getNaslov().toLowerCase().contains(unosNaslova.getText().toLowerCase()))
                .filter(ob -> ob.getOpis().toLowerCase().contains(unosOpisa.getText().toLowerCase()))
                .filter(ob -> ob.getCijena().toString().toLowerCase().contains(unosCijene.getText().toLowerCase()))
                .collect(Collectors.toList());

        tablicaPodataka.setItems(FXCollections.observableArrayList(filtriranaListaUsluga));
    }

}
