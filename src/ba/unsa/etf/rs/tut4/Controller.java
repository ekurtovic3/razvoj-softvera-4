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
    public String racun=new String();



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
        String value = (String) choicebox.getValue();
     String kol=  kolicina.getValue().toString();
        int i = Integer.parseInt(kol.trim());
        Artikal artikal = new Artikal(value);

        double iznos=i*artikal.getCijena();
       // System.out.printf(kol+" "+artikal.getCijena());
         racun=racun+" "+artikal.getSifra()+" "+kol+" "+iznos+"\n";
aktuelniracun.setText(racun);
    }
}
