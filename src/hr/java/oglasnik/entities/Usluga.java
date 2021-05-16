package hr.java.oglasnik.entities;

import hr.java.oglasnik.enums.Stanje;

import java.math.BigDecimal;

/**
 * Predstavlja entities usluge. Klasa naslje�uje klasu Artikl te preuzima
 * sve njezine atribute koji odre�uju uslugu, naslov, opis i cijenu.
 *
 * @author Lucija
 */
public class Usluga extends Artikl {

    /**
     * Inicijalizira podatak o naslovu, opisu i cijeni usluge.
     *
     * @param naslov podatak o naslovu usluge
     * @param opis   podatak o opisu usluge
     * @param cijena podatak o cijeni usluge
     */
    public Usluga(Long id, String naslov, String opis, BigDecimal cijena, Stanje stanje) {
        super(naslov, opis, cijena, stanje, id);

    }

    /**
     * Vra�a string sa podacima o usluzi.
     * Nalje�uje se iz klase Artikl, a u klasi Usluga se implementira.
     * Metoda nema ulaznih parametara.
     *
     * @return vra�a podatke o usluzi tipa String
     */
    @Override
    public String tekstOglasa() {

        return "Naslov usluge: " + getNaslov() +
                "\nOpis usluge: " + getOpis() +
                "\nCijena usluge: " + getCijena() +
                "\nStanje: " + getStanje() + "\n";
    }


}
