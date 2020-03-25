package ba.unsa.etf.rs.tut4;

import java.util.ArrayList;

public class Artikal {
    private double Cijena;
    private String Sifra, Naziv;

    public void setCijena(double cijena) {
        Cijena = cijena;
    }

    public void setSifra(String sifra) {
        Sifra = sifra;
    }

    public void setNaziv(String naziv) {
        Naziv = naziv;
    }

    public double getCijena() {
        return Cijena;
    }

    public String getSifra() {
        return Sifra;
    }

    public String getNaziv() {
        return Naziv;
    }

    public Artikal(String JedanArtikal) {
        String pom[]=JedanArtikal.split(",");
        Sifra=pom[0];
        Naziv=pom[1];
        Cijena=Double.parseDouble(pom[2]);

    }

    public Artikal() {

    }

    public Artikal(String sifra, String naziv, double cijena) {
       setCijena(cijena);
       setSifra(sifra);
       setNaziv(naziv);
    }
    @Override
    public String toString(){
        return Sifra + "," + Naziv + "," + Cijena;
    }

}
