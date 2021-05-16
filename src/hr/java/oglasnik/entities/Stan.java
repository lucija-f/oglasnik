package hr.java.oglasnik.entities;

import java.math.BigDecimal;

import hr.java.oglasnik.enums.Stanje;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hr.java.oglasnik.exceptions.CijenaJePreniskaException;

/**
 * Predstavlja entities stana koji je definiram kvadraturom, naslovom, opisom i cijenom.
 * Metoda naslje�uje  apstraktnu klasu Artikl i implementira su�elje Nekretnina.
 *
 * @author Lucija
 * @version 1.0.
 */
public class Stan extends Artikl implements Nekretnina {

    private static final Logger logger = LoggerFactory.getLogger(Stan.class);

    int kvadratura;

    /**
     * Inicijalizira podatak o naslovu stana, opisu, cijeni i kvadraturi.
     *
     * @param naslov     podatak o naslovu oglasa stana
     * @param opis       podatak o opisu stana
     * @param cijena     podatak o cijeni stana
     * @param kvadratura podatak o kvadraturi stana
     */
    public Stan(Long id, String naslov, String opis, BigDecimal cijena, Stanje stanje, int kvadratura) {
        super(naslov, opis, cijena, stanje, id);
        this.kvadratura = kvadratura;
    }


    public int getKvadratura() {
        return kvadratura;
    }

    public void setKvadratura(int kvadratura) {
        this.kvadratura = kvadratura;
    }

    /**
     * Vra�a podatke o stanu. Metoda vra�a podatke u tipu String. Naslje�uje se iz klase Artikl i overrida se.
     * Sadr�i try-catch blok gdje u try dijelu poziva metodu izracunajPorez koja prima cijenu stana.
     * U metodi izracunajPorez se procjerava je li cijena stana ve�a ili manja od 10.000 HRK. Ako je manja, baca izmiku koja
     * se ovdje u catch dijelu lovi, ispisuje poruka u logger te se tako�er sprema u varijablu.
     *
     * @return Vra�a String sa podacima o stanu.
     */

    @Override
    public String tekstOglasa() {

        String porez;
        try {
            porez = izracunajPorez(getCijena()).toString();

        } catch (CijenaJePreniskaException ex) {
            logger.error("Pogre�ka prilikom odre�ivanja iznosa poreza!");
            logger.error(ex.getMessage(), ex);
            porez = ex.getMessage();

        }

        return "Naslov nekretnine: " + getNaslov() +
                "\nOpis nekretnine: " + getOpis() +
                "\nKvadratura nekretnine: " + kvadratura +
                "\nStanje nekretnine: " + getStanje() +
                "\nPorez na nekretnine: " + porez +
                "\nCijena nekretnine: " + getCijena() + "\n";
    }


}
