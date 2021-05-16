package hr.java.oglasnik.entities;

import java.math.BigDecimal;
import java.math.RoundingMode;

import hr.java.oglasnik.exceptions.CijenaJePreniskaException;

/**
 * Sadr�i defaultnu metodu izracunajPorez koja odre�uje ovo su�elje
 *
 * @author Lucija
 */
public interface Nekretnina {

    /**
     * Ra�una porez na nekretninu. Metoda prima cijenu nekretnine te provjerava je li
     * cijena manja od 10.000 HRK. Ako je manja, baca iznimku. Ako je ve�a, izra�unava i
     * vra�a porez.
     *
     * @param cijenaNekretnine prima cijenu nekretnine
     * @return vra�a izra�unati porez
     * @throws CijenaJePreniskaException baca iznimku ako je cijena nekretnine preniska
     */
    default public BigDecimal izracunajPorez(BigDecimal cijenaNekretnine) throws CijenaJePreniskaException {

        BigDecimal porez = new BigDecimal(0);
        BigDecimal donjaGranica = new BigDecimal(10000);

        if (cijenaNekretnine.compareTo(donjaGranica) == -1) {
            throw new CijenaJePreniskaException();
        } else {
            BigDecimal triPosto = new BigDecimal(0.03);
            porez = cijenaNekretnine.multiply(triPosto);
            porez = porez.setScale(2, RoundingMode.HALF_EVEN);
        }

        return porez;
    }

}
