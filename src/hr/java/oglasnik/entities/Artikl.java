package hr.java.oglasnik.entities;

import hr.java.oglasnik.enums.Stanje;

import java.math.BigDecimal;

/**
 * Predstavlja artikl kojeg opisuje naslov, opis artikla i cijena artikla
 *
 * @author Lucija
 * @version 1.0
 */
public abstract class Artikl extends Entitet {

    private String naslov;
    private String opis;
    private BigDecimal cijena;
    private Stanje stanje;

    /**
     * Konstruktor klase Artikl inicijalizira posatke o naslovu, opisu i cijeni
     *
     * @param naslov naziv artikla
     * @param opis   opisuje artikl
     * @param cijena sadr�i cijenu artikla
     * @param stanje podatak o stanju stana
     */
    public Artikl(String naslov, String opis, BigDecimal cijena, Stanje stanje, Long id) {
        super(id);
        this.naslov = naslov;
        this.opis = opis;
        this.cijena = cijena;
        this.stanje = stanje;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cijena == null) ? 0 : cijena.hashCode());
        result = prime * result + ((naslov == null) ? 0 : naslov.hashCode());
        result = prime * result + ((opis == null) ? 0 : opis.hashCode());
        result = prime * result + ((stanje == null) ? 0 : stanje.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Artikl other = (Artikl) obj;
        if (cijena == null) {
            if (other.cijena != null)
                return false;
        } else if (!cijena.equals(other.cijena))
            return false;
        if (naslov == null) {
            if (other.naslov != null)
                return false;
        } else if (!naslov.equals(other.naslov))
            return false;
        if (opis == null) {
            if (other.opis != null)
                return false;
        } else if (!opis.equals(other.opis))
            return false;
        if (stanje != other.stanje)
            return false;
        return true;
    }

    /**
     * Dobivanje naslova artikla
     *
     * @return vraca naslov artikla tipa String
     */
    public String getNaslov() {
        return naslov;
    }

    /**
     * Postavljanje naslova artikla
     *
     * @param naslov unos naslova artikla
     */
    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    /**
     * Dohvaca opis artikla
     *
     * @return vraca opis tipa String
     */
    public String getOpis() {
        return opis;
    }

    /**
     * Postavljanje opisa artikla
     *
     * @param opis postavlja opis artikla
     */
    public void setOpis(String opis) {
        this.opis = opis;
    }

    /**
     * Dohvaca cijenu artikla
     *
     * @return vraca cijenu artikla tipa BigDecimal
     */
    public BigDecimal getCijena() {
        return cijena;
    }

    /**
     * Postavlja cijenu artikla
     *
     * @param cijena postavlja cijenu artikla tipa BigDecimal
     */
    public void setCijena(BigDecimal cijena) {
        this.cijena = cijena;
    }

    /**
     * Apstraktna metoda
     *
     * @return vraca tip String
     */
    public abstract String tekstOglasa();

    public Stanje getStanje() {
        return stanje;
    }

    public void setStanje(Stanje stanje) {
        this.stanje = stanje;
    }


}
