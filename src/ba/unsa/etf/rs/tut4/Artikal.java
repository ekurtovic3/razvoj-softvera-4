package ba.unsa.etf.rs.tut4;

import java.util.ArrayList;

public class Artikal {
    private double Cijena;
    private String Sifra, Naziv;

    public void setCijena(double cijena) {
        if (cijena <= 0) throw new IllegalArgumentException("Cijena je negativna");
        Cijena = cijena;
    }

    public void setSifra(String sifra) {
        if (sifra.isEmpty()) throw new IllegalArgumentException("Šifra je prazna");
        Sifra = sifra;
    }

    public void setNaziv(String naziv) {
        if (naziv.isEmpty()) throw new IllegalArgumentException("Naziv je prazan");
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
        String pom[] = JedanArtikal.split(",");
        double a = Double.parseDouble(pom[2]);
        Artikal artikal = new Artikal(pom[0], pom[1], a);
        this.setCijena(artikal.getCijena());
        this.setNaziv(artikal.getNaziv());
        this.setSifra(artikal.getSifra());
    }


    public Artikal(String sifra, String naziv, double cijena) {
        setCijena(cijena);
        setSifra(sifra);
        setNaziv(naziv);
    }

    public static void izbaciDuplikate(ArrayList<Artikal> Lista) {

        ArrayList<Artikal> pomLista = new ArrayList<>();
        for (Artikal element : Lista) {
            pomLista.add(element);
        }
        Lista.removeAll(pomLista);
        for (Artikal element : pomLista) {
            if (!Lista.contains(element)) {

                Lista.add(element);

            }
        }


    }

    @Override
    public String toString() {
        return Sifra + "," + Naziv + "," + Cijena;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Artikal)) return false;
        Artikal artikal = (Artikal) o;
        return (this.Cijena == artikal.Cijena && this.Naziv == artikal.Naziv && this.Sifra == artikal.Sifra);
    }

}