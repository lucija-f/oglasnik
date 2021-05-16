package hr.java.oglasnik.entities;

import java.math.BigDecimal;

import hr.java.oglasnik.exceptions.NemoguceOdreditiGrupuOsiguranjaException;

/**
 * Su�elje odre�eno trima metodama, dvijema defaultnim i jednom bez tijala.
 *
 * @author Lucija
 * @version 1.0
 */
public interface Vozilo {
    /**
     * Izra�unava kW vozila.
     * defaultna metoda koja sadr�i tijelo. Prima konjsku snagu vozila
     * i izracunava Kw.
     *
     * @param ks konjska snaga vozila
     * @return metoda vraca izracunat kW vozila tipa BigDecimal
     */
    default public BigDecimal izracunajKw(BigDecimal ks) {

        BigDecimal koefUmnoska = new BigDecimal(1.341);
        BigDecimal kw = new BigDecimal(0);

        kw = koefUmnoska.multiply(ks);

        return kw;
    }

    /**
     * Ra�una grupu osiguranja u koju spada vozilo. Metoda u su�elju nije defaultna pa iz tog razloga ne sadr�i tijelo. Metoda se dovr�ava u klasi koja implementira su�elje Vozilo
     *
     * @return vra�a grupu kao broj (BigDecimal)
     * @throws NemoguceOdreditiGrupuOsiguranjaException metoda omogu�uje bacanje exceptions NemoguceOdreditiGrupuOsiguranjaException
     */

    public BigDecimal izracunajGrupuOsiguranja() throws NemoguceOdreditiGrupuOsiguranjaException;

    /**
     * Ra�una cijenu osiguranja vozila. Unutar metode poziva se
     * metoda izracunajGrupuOsiguranja koja vra�a grupu i pomo�u grupe
     * metoda svrstava vozilo u odre�eni slu�aj (postoji 5 slu�ajeva/grupa) odre�en cijenom osiguranja
     *
     * @return vra�a cijenu osiguranja tipa BigDecimal
     * @throws NemoguceOdreditiGrupuOsiguranjaException metoda omogu�uje bacanje exceptions NemoguceOdreditiGrupuOsiguranjaException
     */
    default public BigDecimal izracunajCijenuOsiguranja() throws NemoguceOdreditiGrupuOsiguranjaException {

        BigDecimal cijenaOsiguranja = new BigDecimal(0);
        BigDecimal pom = izracunajGrupuOsiguranja();

        switch (pom.intValue()) {  // switch ne radi s BigDecimal pa pretvaramo u int
            case 1:
                cijenaOsiguranja = new BigDecimal(200);
                break;
            case 2:
                cijenaOsiguranja = new BigDecimal(400);
                break;
            case 3:
                cijenaOsiguranja = new BigDecimal(600);
                break;
            case 4:
                cijenaOsiguranja = new BigDecimal(900);
                break;
            case 5:
                cijenaOsiguranja = new BigDecimal(1500);
                break;

        }

        return cijenaOsiguranja;
    }
}
