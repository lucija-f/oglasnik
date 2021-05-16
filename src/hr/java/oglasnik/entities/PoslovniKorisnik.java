package hr.java.oglasnik.entities;

/**
 * Predstavlja entities poslovnog korisnika. Naslje�uje klasu Korisnik pa osim
 * naslje�enih atributa iz Korisnika ima i svoje, naziv i web tvrtke (poslovnog korisnika)
 *
 * @author Lucija
 * @version 1.0
 */
public class PoslovniKorisnik extends Korisnik {

    private String naziv;
    private String web;

    /**
     * Inicijalizira podatak o emailu, telefonu, nazivu tvrtke i webu
     *
     * @param email   podatak o emailu poslovnog korisnika
     * @param telefon podatak o telefonu poslovnog korisnika
     * @param naziv   podatak o nazivu tvtke
     * @param web     podatak o web stranici tvrtke
     */
    public PoslovniKorisnik(Long id, String email, String telefon, String naziv, String web) {
        super(email, telefon, id);
        this.naziv = naziv;
        this.web = web;
    }


    public String getNaziv() {
        return naziv;
    }


    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }


    public String getWeb() {
        return web;
    }


    public void setWeb(String web) {
        this.web = web;
    }

    /**
     * Vra�a string sa podacima o poslovnom korisniku.
     * Nalje�uje se iz klase Korisnik, a u klasi PoslovniKorisnik se implementira. Metoda nema ulaznih parametara.
     */

    @Override
    public String dohvatiKontakt() {

        return "Naziv tvrtke: " + naziv + ", mail: " + super.getEmail() + ", tel: " + super.getTelefon() + ", web: " + web + "\n";
    }


}
