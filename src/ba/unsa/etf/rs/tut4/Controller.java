package ba.unsa.etf.rs.tut4;

import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;


import javax.print.DocFlavor;
import java.util.ArrayList;


public class Controller {

    public TextArea unosArtikla;
    public TextArea ispisArtikla;
    public ChoiceBox choicebox;
    public Spinner kolicina;
    public TextArea aktuelniracun;
    public String racun = new String();


    public void dodajArtikle(ActionEvent actionEvent) {
        String spisak = new String();
        spisak = unosArtikla.getText();
        ArrayList<Artikal> lista = new ArrayList<>();
        for (String jedan : spisak.split("\n")) {
            Artikal pom = new Artikal(jedan);
            lista.add(pom);
        }
        Artikal.izbaciDuplikate(lista);
        String string = new String();
        for (Artikal pom : lista) {
            string = string + pom.toString() + "\n";
            choicebox.getItems().add(pom.toString() + "\n");
        }
        ispisArtikla.setText(string);
    }

    public void Dodaj(ActionEvent actionEvent) {
        Racun trenutniracun = new Racun();
        String value = (String) choicebox.getValue();
        String kol = kolicina.getValue().toString();
        int i = Integer.parseInt(kol.trim());
        Artikal artikal = new Artikal(value);
        trenutniracun.dodajStavku(artikal, 5);
        double suma = trenutniracun.ukupanIznos();
        double iznos = i * artikal.getCijena();
        // System.out.printf(kol+" "+artikal.getCijena());
        racun = racun + " " + artikal.getSifra() + " " + kol + " " + iznos + "\n";
        aktuelniracun.setText(racun);

    }

}

/*
public void Dodaj(ActionEvent actionEvent) {
  aktuelniracun.clear();
    for(int i=0; i<listaArtikala.size(); i++){
        if(listaArtikala.get(i).getSifra().equals(choicebox.getValue())){
            sadasnjiRacun.dodajStavku(listaArtikala.get(i),(Integer)kolicina.getValue());
        }
    }
    String string = new String();
    for(int i=0; i<sadasnjiRacun.getSviArtikli().size(); i++){
        string = string + String.format("%-12s %-4s %.2f\n",sadasnjiRacun.getSviArtikli().get(i).getSifra(),sadasnjiRacun.getKolicinaArtikala().get(i).toString(),sadasnjiRacun.getSviArtikli().get(i).getCijena());
    }
    string = string + String.format("UKUPNO %13.2f",sadasnjiRacun.ukupanIznos());
    aktuelniracun.setText(string);
}
}
*/