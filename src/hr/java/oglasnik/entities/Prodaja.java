package hr.java.oglasnik.entities;

import java.time.LocalDate;

/**
 * Predstavlja entities prodaje. Sadr�i podatke o artiklu koji se prodaje, korisniku koji prodaje artikl te datum objave oglasa.
 *
 * @author Lucija
 * @version 1.0.
 */
public class Prodaja extends Entitet {

    Artikl artikl;
    Korisnik korisnik;
    LocalDate datumObjave;

    /**
     * Inicijalizira podatak o artiklu, korisniku i datumu objave oglasa.
     *
     * @param artikl      podatak o artiklu tipa Artikl
     * @param korisnik    podatak o korisniku tipa Korisnik
     * @param datumObjave podatak o datumu objave oglasa
     */
    public Prodaja(Long id, Artikl artikl, Korisnik korisnik, LocalDate datumObjave) {
        super(id);
        this.artikl = artikl;
        this.korisnik = korisnik;
        this.datumObjave = datumObjave;
    }

    public Artikl getArtikl() {
        return artikl;
    }

    public void setArtikl(Artikl artikl) {
        this.artikl = artikl;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public LocalDate getDatumObjave() {

        return datumObjave;
    }

    public void setDatumObjave(LocalDate datumObjave) {
        this.datumObjave = datumObjave;
    }


}
