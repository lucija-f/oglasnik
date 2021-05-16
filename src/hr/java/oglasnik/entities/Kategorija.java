package hr.java.oglasnik.entities;

import java.lang.String;
import java.util.List;

/**
 * Odre�ena je nazivom i poljem artikala koji se nalaze u toj kategoriji
 *
 * @author Lucija
 * @version 1.0
 */
public class Kategorija<T extends Artikl> extends Entitet {

    private String naziv;
    private List<T> setArtikala;

    /**
     * Inicijalizira podatak o nazivu kategorije i artiklu
     *
     * @param naziv       podatak o nazivu kategorije
     * @param setArtikala
     */

    public Kategorija(Long id, String naziv, List<T> setArtikala) {
        super(id);
        this.naziv = naziv;
        this.setArtikala = setArtikala;

    }


    public void dodajArtikl(T objekt) {
        setArtikala.add(objekt);
    }

    public T dohvatiArtikl(int index) {

        return setArtikala.get(index);
    }

    public List<T> dohvatiListuArtikala() {
        return setArtikala;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }


}
