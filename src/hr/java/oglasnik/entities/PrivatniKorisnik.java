package hr.java.oglasnik.entities;

/**
 * Predstavlja entities privatnog korisnika. Naslje�uje klasu Korisnik pa osim
 * naslje�enih atributa iz Korisnika ima i svoje, ime i prezime privatnog korisnika
 *
 * @author Lucija
 * @version 1.0
 */
public class PrivatniKorisnik extends Korisnik {

    private String ime;
    private String prezime;

    /**
     * Inicijalizira podatak o imenu, prezimenu, emailu i telefonu privatnog korisnika
     *
     * @param ime     podatak o imenu korisnika
     * @param prezime podatak o prezimenu korisnika
     * @param email   podatak o emailu korisnika
     * @param telefon podatak o telefonu korisnika
     */

    public PrivatniKorisnik(Long id, String ime, String prezime, String email, String telefon) {
        super(email, telefon, id);
        this.ime = ime;
        this.prezime = prezime;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    /**
     * Vra�a string sa podacima o privatnom korisniku.
     * Nalje�uje se iz klase Korisnik, a u klasi PrivatniKorisnik se implementira. Metoda nema ulaznih parametara.
     */
    @Override
    public String dohvatiKontakt() {

        return "Osobni podaci prodavatelja: " + ime + " " + prezime + ", mail: " + super.getEmail() + ", tel: " + super.getTelefon() + "\n";
    }


}
