package ba.unsa.etf.rs.tut4;

import java.util.ArrayList;

public class Racun {
    ArrayList<Artikal> artikli = new ArrayList<>();
    ArrayList<Double> kolicine  = new ArrayList<>();


    public void dodajStavku(Artikal art, double kolicina) {
artikli.add(art);
kolicine.add(kolicina);
    }

    public double ukupanIznos(){
        double suma=0;
        for(int i=0;i<artikli.size();i++){
            suma=suma+artikli.get(i).getCijena()*kolicine.get(i);
        }
        return suma;
    }
}
