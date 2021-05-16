package hr.java.oglasnik.entities;

import java.lang.String;


/**
 * Predstavlja korisnike koji mogu biti privatni ili poslovni
 *
 * @author Lucija
 * @version 1.0
 */

public abstract class Korisnik extends Entitet {

    private String email;
    private String telefon;


    /**
     * Inicijalizira parametre email i telefon.
     * Atributi koji obilje�uju sve korisnike.
     *
     * @param email   podatak o emailu korisnika
     * @param telefon posatak o telefonu korisnika
     */
    public Korisnik(String email, String telefon, Long id) {
        super(id);
        this.email = email;
        this.telefon = telefon;
    }


    /**
     * @return Dohvaca email korisnika
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email Postavlja email korisnika
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return Dohvaca telefon korisnika
     */
    public String getTelefon() {
        return telefon;
    }

    /**
     * @param telefon Postavlja telefon korisnika
     */
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    /**
     * Dohva�a korisnika. Apstraktna metoda koja u klasi Korisnik nema tijela
     *
     * @return vraca objekt tipa String
     */
    public abstract String dohvatiKontakt();


}
