package ba.unsa.etf.rs.tut4;

import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;

import java.awt.*;
import java.util.ArrayList;

import static ba.unsa.etf.rs.tut4.Artikal.izbaciDuplikate;

public class Controller {


    public TextArea unosArtikla;
    public TextArea ispisArtikla;

    public void dodajArtikle(ActionEvent actionEvent) {
        String spisak=new String();
        spisak=unosArtikla.getText();
        ArrayList<Artikal> lista =new ArrayList<>();
        for(String jedan: spisak.split("\n")){
            Artikal pom=new Artikal(jedan);
            lista.add(pom);
        }
        izbaciDuplikate(lista);
        for(Artikal pom: lista){
            ispisArtikla.setText(pom.toString()+"\n");
        }




    }


}
