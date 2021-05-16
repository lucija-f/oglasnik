package hr.java.oglasnik.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import hr.java.oglasnik.entities.Artikl;
import hr.java.oglasnik.entities.Automobil;
import hr.java.oglasnik.entities.Kategorija;
import hr.java.oglasnik.entities.Korisnik;
import hr.java.oglasnik.entities.PoslovniKorisnik;
import hr.java.oglasnik.entities.PrivatniKorisnik;
import hr.java.oglasnik.entities.Prodaja;
import hr.java.oglasnik.entities.Stan;
import hr.java.oglasnik.enums.Stanje;
import hr.java.oglasnik.entities.Usluga;

public class Datoteke {

    public static Stanje odabirStanja(Integer odabir) {

        Stanje stanje = Stanje.izvrsno;

        switch (odabir) {
            case 1:
                stanje = Stanje.novo;
                break;
            case 2:
                stanje = Stanje.izvrsno;
                break;
            case 3:
                stanje = Stanje.rabljeno;
                break;
            case 4:
                stanje = Stanje.neispravno;
                break;
        }

        return stanje;
    }

    public static List<Prodaja> dohvatiProdaju(List<Korisnik> listaKorisnika, List<Kategorija<Artikl>> listaKat)
            throws IOException {

        List<Prodaja> listaPordaja = new ArrayList<Prodaja>();
        List<String> listaStringova = new ArrayList<String>();

        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream("dat//prodaja.txt"), "UTF8"));
            String red;
            while ((red = reader.readLine()) != null) {
                listaStringova.add(red);

            }
        } catch (IOException e) {

            e.printStackTrace();
        } finally {
            if (reader != null)
                reader.close();
        }

        Prodaja novaProdaja = null;

        for (int i = 0; i < listaStringova.size(); i += 5) {
            Long id = Long.parseLong(listaStringova.get(i));

            Integer brKorisnikInteger = Integer.parseInt(listaStringova.get(i + 1));
            Korisnik odabraniKorisnik = listaKorisnika.get(brKorisnikInteger - 1);

            Integer brKategorije = Integer.parseInt(listaStringova.get(i + 2));
            Kategorija<Artikl> odabranaKategorija = listaKat.get(brKategorije - 1);

            Artikl odabraniArtikl = odabranaKategorija.dohvatiArtikl(Integer.parseInt(listaStringova.get(i + 3)) - 1);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
            LocalDate datum = LocalDate.parse(listaStringova.get(i + 4), formatter);

            novaProdaja = new Prodaja(id, odabraniArtikl, odabraniKorisnik, datum);
            listaPordaja.add(novaProdaja);

        }

        return listaPordaja;

    }

    public static List<Kategorija<Artikl>> dohvatiKategorije(List<Artikl> listaA) throws IOException {

        List<Kategorija<Artikl>> listaKategorija = new ArrayList<Kategorija<Artikl>>();
        List<String> listaStringova = new ArrayList<String>();

        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream("dat//kategorije.txt"), "UTF8"));
            String red;
            while ((red = reader.readLine()) != null) {
                listaStringova.add(red);

            }
        } catch (IOException e) {

            e.printStackTrace();
        } finally {
            if (reader != null)
                reader.close();
        }
        Kategorija<Artikl> novaKat = null;

        for (int i = 0; i < listaStringova.size(); i += 3) {
            Long id = Long.parseLong(listaStringova.get(i));
            String naziv = listaStringova.get(i + 1);
            String nizId = listaStringova.get(i + 2);

            List<String> odvojeniId = new ArrayList<String>(Arrays.asList(nizId.split(" ")));
            List<Artikl> artikliZaKategoriju = new ArrayList<Artikl>();
            for (int j = 0; j < odvojeniId.size(); j++) {
                for (int j2 = 0; j2 < listaA.size(); j2++) {
                    if (odvojeniId.get(j).equals(Long.toString(listaA.get(j2).getId()))) {
                        artikliZaKategoriju.add(listaA.get(j2));
                    }
                }
            }

            novaKat = new Kategorija<Artikl>(id, naziv, artikliZaKategoriju);
            listaKategorija.add(novaKat);
        }

        return listaKategorija;

    }

    public static List<Artikl> dohvatiArtikle() {

        List<Artikl> listaArtikala = new ArrayList<Artikl>();
        List<String> listaStringova = new ArrayList<String>();

        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream("dat//artikli.txt"), "UTF8"));
            String red;
            while ((red = reader.readLine()) != null) {
                listaStringova.add(red);

            }
        } catch (IOException e) {

            e.printStackTrace();
        }

        Artikl noviArtikl = null;

        for (int i = 0; i < listaStringova.size(); i += 6) {
            if (Integer.parseInt(listaStringova.get(i)) == 1) { // Usluga
                Long id = Long.parseLong(listaStringova.get(i + 1));
                String naslov = listaStringova.get(i + 2);
                String opis = listaStringova.get(i + 3);
                String cijenaString = listaStringova.get(i + 4).replaceAll(",", "");
                BigDecimal cijena = new BigDecimal(cijenaString);
                Integer stanjeInt = Integer.parseInt(listaStringova.get(i + 5));
                Stanje stanje = odabirStanja(stanjeInt);

                noviArtikl = new Usluga(id, naslov, opis, cijena, stanje);
                listaArtikala.add(noviArtikl);
            } else if (Integer.parseInt(listaStringova.get(i)) == 2) { // Automobili
                Long id = Long.parseLong(listaStringova.get(i + 1));
                String naslov = listaStringova.get(i + 2);
                String opis = listaStringova.get(i + 3);
                String snagaString = listaStringova.get(i + 4).replaceAll(",", "");
                BigDecimal snaga = new BigDecimal(snagaString);
                String cijenaString = listaStringova.get(i + 5).replaceAll(",", "");
                BigDecimal cijena = new BigDecimal(cijenaString);
                Integer stanjeInt = Integer.parseInt(listaStringova.get(i + 6));
                Stanje stanje = odabirStanja(stanjeInt);

                noviArtikl = new Automobil(id, naslov, opis, cijena, stanje, snaga);
                listaArtikala.add(noviArtikl);
                i++;
            } else if (Integer.parseInt(listaStringova.get(i)) == 3) { // Stan
                Long id = Long.parseLong(listaStringova.get(i + 1));
                String naslov = listaStringova.get(i + 2);
                String opis = listaStringova.get(i + 3);
                int kvadratura = Integer.parseInt(listaStringova.get(i + 4));
                String cijenaString = listaStringova.get(i + 5).replaceAll(",", "");
                BigDecimal cijena = new BigDecimal(cijenaString);
                Integer stanjeInt = Integer.parseInt(listaStringova.get(i + 6));
                Stanje stanje = odabirStanja(stanjeInt);

                noviArtikl = new Stan(id, naslov, opis, cijena, stanje, kvadratura);
                listaArtikala.add(noviArtikl);
                i++;

            }
        }

        return listaArtikala;
    }

    public static List<Korisnik> dohvatiKorisnike() throws IOException {

        List<Korisnik> listaKorisnika = new ArrayList<Korisnik>();
        List<String> listaStringova = new ArrayList<String>();

        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader("dat//korisnici.txt"));
            String red;
            while ((red = reader.readLine()) != null) {
                listaStringova.add(red);

            }
        } catch (IOException e) {

            e.printStackTrace();
        } finally {
            if (reader != null)
                reader.close();
        }

        Korisnik noviKor = null;

        for (int i = 0; i < listaStringova.size(); i += 6) {
            if (Integer.parseInt(listaStringova.get(i)) == 1) {
                Long id = Long.parseLong(listaStringova.get(i + 1));
                String ime = listaStringova.get(i + 2);
                String prezime = listaStringova.get(i + 3);
                String mail = listaStringova.get(i + 4);
                String telefon = listaStringova.get(i + 5);

                noviKor = new PrivatniKorisnik(id, ime, prezime, mail, telefon);
                listaKorisnika.add(noviKor);

            } else if (Integer.parseInt(listaStringova.get(i)) == 2) {
                Long id = Long.parseLong(listaStringova.get(i + 1));
                String mail = listaStringova.get(i + 2);
                String telefon = listaStringova.get(i + 3);
                String naziv = listaStringova.get(i + 4);
                String web = listaStringova.get(i + 5);

                noviKor = new PoslovniKorisnik(id, mail, telefon, naziv, web);
                listaKorisnika.add(noviKor);
            }

        }
        return listaKorisnika;

    }

    public static void ispisSvihProdaja(List<Prodaja> listaProdaja) {
        System.out.println(ispisLinije());
        for (int i = 0; i < listaProdaja.size(); i++) {
            Artikl artikl = listaProdaja.get(i).getArtikl();

            System.out.print(artikl.tekstOglasa());

            System.out.println("Datum objave: " + listaProdaja.get(i).getDatumObjave());

            Korisnik korisnik = listaProdaja.get(i).getKorisnik();
            System.out.print(korisnik.dohvatiKontakt());
            System.out.println(ispisLinije());
        }
    }

    private static String ispisLinije() {
        String out = "";
        for (int i = 0; i < 80; i++) {
            out = out + "-";
        }

        return out;
    }

}
