package hr.java.oglasnik.entities;

import java.math.BigDecimal;

import hr.java.oglasnik.enums.Stanje;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hr.java.oglasnik.exceptions.NemoguceOdreditiGrupuOsiguranjaException;

/**
 * Predstavlja entities automobila kojeg definira konjska snaga te naslov, opis i cijena
 * Naslje�uje klasu Artikl i implementira su�elje Vozilo
 *
 * @author Lucija
 * @version 1.0
 */
public class Automobil extends Artikl implements Vozilo {


    BigDecimal snagaKs;

    private static final Logger logger = LoggerFactory.getLogger(Automobil.class);


    /**
     * Konstruktor klase Automobil osim naslova, opisa i cijene koje prima iz Artikla prima i konjsku snagu automobila
     *
     * @param naslov  podatak o nazivu automobila
     * @param opis    podaci o automobilu (opis automobila)
     * @param cijena  podatak o cijeni automobila
     * @param stanje  podatak o stanju automobila
     * @param snagaKs podatak o snazi automobila (konjska snaga)
     */
    public Automobil(Long id, String naslov, String opis, BigDecimal cijena, Stanje stanje, BigDecimal snagaKs) {
        super(naslov, opis, cijena, stanje, id);
        this.snagaKs = snagaKs;
    }

    public BigDecimal getSnagaKs() {
        return snagaKs;
    }

    public void setSnagaKs(BigDecimal snagaKs) {
        this.snagaKs = snagaKs;
    }

    /**
     * Naslje�uje se iz Artikla i overridea implementacijom u kasi Automobil.
     * Nema ulaznih parametara, a vra�a tip podatka BigDecimal.
     * U metodi imamo poziv defaultne metode iz su�elja vozilo izracunajKw koja vra�a kW te se
     * prema izra�unatim kW vozilo smje�ta u odre�enu grupu osiguranja.
     * Ukoliko je kW ve�i od 160 metoda baca exception kojeg prima metoda tekstOglasa
     */
    @Override
    public BigDecimal izracunajGrupuOsiguranja() throws NemoguceOdreditiGrupuOsiguranjaException {

        BigDecimal pKw = izracunajKw(snagaKs);
        BigDecimal grupa = new BigDecimal(0);

        if (pKw.doubleValue() > 0 && pKw.doubleValue() <= 55) {
            grupa = BigDecimal.valueOf(1);
        } else if (pKw.doubleValue() > 55 && pKw.doubleValue() <= 70) {
            grupa = BigDecimal.valueOf(2);
        } else if (pKw.doubleValue() > 70 && pKw.doubleValue() <= 100) {
            grupa = BigDecimal.valueOf(3);
        } else if (pKw.doubleValue() > 100 && pKw.doubleValue() <= 130) {
            grupa = BigDecimal.valueOf(4);
        } else if (pKw.doubleValue() > 130 && pKw.doubleValue() <= 250) {
            grupa = BigDecimal.valueOf(5);
        } else if (pKw.doubleValue() > 250) {
            throw new NemoguceOdreditiGrupuOsiguranjaException();
        }
        return grupa;
    }

    /**
     * Vra�a podatke o automobilu.
     * Naslje�uje se iz klase Artikl te overridea.
     * Ne prima parametre, a vra�a podatak tipa String.
     * Metoda sadr�i try-catch koji lovi exception iz metode izracunajGrupuOsiguranja,
     * zapisuje poruku u logger i na ekran.
     */

    @Override
    public String tekstOglasa() {

        String cOsiguranja;

        try {
            cOsiguranja = izracunajCijenuOsiguranja().toString();
        } catch (NemoguceOdreditiGrupuOsiguranjaException ex) {
            logger.error("Pogre�ka prilikom odre�ivanja odre�ivanja cijene osiguranja!");
            logger.error(ex.getMessage(), ex);
            cOsiguranja = ex.getMessage();
        }
        return "Naslov automobila: " + getNaslov() +
                "\nOpis automobila: " + getOpis() +
                "\nSnaga automobila: " + snagaKs +
                "\nStanje automobila: " + getStanje() +
                "\nIzra�un osiguranja automobila: " + cOsiguranja +
                "\nCijena automobila: " + getCijena() + "\n";
    }

}
