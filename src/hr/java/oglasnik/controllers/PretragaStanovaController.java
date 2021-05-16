package hr.java.oglasnik.controllers;

import java.util.List;
import java.util.stream.Collectors;

import hr.java.oglasnik.entities.Stan;
import hr.java.oglasnik.util.Datoteke;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class PretragaStanovaController {

    @FXML
    private TextField unosNaslova;

    @FXML
    private TextField unosOpisa;

    @FXML
    private TextField unosKvadrature;

    @FXML
    private TextField unosCijene;

    @FXML
    private TableView<Stan> tablicaPodataka;


    @FXML
    private TableColumn<Stan, String> kolonaNaslov;

    @FXML
    private TableColumn<Stan, String> kolonaOpis;

    @FXML
    private TableColumn<Stan, String> kolonaKvadratura;

    @FXML
    private TableColumn<Stan, String> kolonaCijena;

    @FXML
    private TableColumn<Stan, String> kolonaStanje;

    List<Stan> listaStanova;

    @FXML
    public void initialize() {

        listaStanova = Datoteke.dohvatiArtikle().stream().filter(p -> p instanceof Stan).map(sc -> (Stan) sc).collect(Collectors.toList());

        tablicaPodataka.setItems(FXCollections.observableArrayList(listaStanova));

        kolonaNaslov.setCellValueFactory(new PropertyValueFactory<Stan, String>("naslov"));
        kolonaOpis.setCellValueFactory(new PropertyValueFactory<Stan, String>("opis"));
        kolonaKvadratura.setCellValueFactory(new PropertyValueFactory<Stan, String>("kvadratura"));
        kolonaCijena.setCellValueFactory(new PropertyValueFactory<Stan, String>("cijena"));
        kolonaStanje.setCellValueFactory(new PropertyValueFactory<Stan, String>("stanje"));

    }

    @FXML
    void pretrazi(ActionEvent event) {

        List<Stan> filtriranaListaStanova = listaStanova.stream()
                .filter(ob -> ob.getNaslov().toLowerCase().contains(unosNaslova.getText().toLowerCase()))
                .filter(ob -> ob.getOpis().toLowerCase().contains(unosOpisa.getText().toLowerCase()))
                .filter(ob -> String.valueOf(ob.getKvadratura()).contains(unosKvadrature.getText().toLowerCase()))
                .filter(ob -> ob.getCijena().toString().toLowerCase().contains(unosCijene.getText().toLowerCase()))
                .collect(Collectors.toList());

        tablicaPodataka.setItems(FXCollections.observableArrayList(filtriranaListaStanova));
    }

}
