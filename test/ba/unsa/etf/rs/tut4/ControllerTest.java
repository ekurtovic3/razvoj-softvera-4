import static javafx.application.Application.launch;
import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;
import static org.junit.jupiter.api.Assertions.*;

import ba.unsa.etf.rs.tut4.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import javax.swing.*;

@ExtendWith(ApplicationExtension.class)
class ControllerTest {


    @Start
    public void start(Stage stage) throws Exception {
        Parent root = (Parent) FXMLLoader.load(this.getClass().getResource("/fxml/sample.fxml"));
        stage.setTitle("Kasa");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.show();
        stage.toFront();
    }

    @Test
    public void DodajArtikalTest(FxRobot robot) {
        TextArea dodaj = robot.lookup("#unosArtikla").queryAs(TextArea.class);
        robot.clickOn("#unosArtikla");
        robot.write("SB,Proizvod,38");
        robot.clickOn("#dodaj");
        assertEquals("SB,Proizvod,38", dodaj.getText());

    }


    @Test
    void TestArtikalTabTest(FxRobot robot) {
        Button dodajArt = robot.lookup("#dodaj").queryAs(Button.class);
        TextArea textArea1 = robot.lookup("#unosArtikla").queryAs(TextArea.class);
        TextArea textArea2 = robot.lookup("#ispisArtikla").queryAs(TextArea.class);
        assertNotNull(dodajArt);
        assertNotNull(textArea1);
        assertNotNull(textArea2);
    }

    @Test
    void TestRacunTabTest(FxRobot robot) {
        robot.clickOn("#TabRacun");
        Button dodajArt = robot.lookup("#dodajArtikle").queryAs(Button.class);
        TextArea artikli = robot.lookup("#aktuelniracun").queryAs(TextArea.class);
        Spinner spin = robot.lookup("#kolicina").queryAs(Spinner.class);
        ChoiceBox choices = robot.lookup("#choicebox").queryAs(ChoiceBox.class);
        assertNotNull(dodajArt);
        assertNotNull(artikli);
        assertNotNull(spin);
        assertNotNull(choices);
    }

    @Test
    void ViseArtikalaTest(FxRobot robot) {
        TextArea area2 = robot.lookup("#unosArtikla").queryAs(TextArea.class);
        TextArea area1 = robot.lookup("#unosArtikla").queryAs(TextArea.class);
        Button dodajArt = robot.lookup("#dodaj").queryAs(Button.class);
        robot.clickOn(area1);
        robot.write("ABC,Proizvod,1\n");
        robot.clickOn("#dodaj");
        String inArea = area2.getText();
        assertEquals("ABC,Proizvod,1\n", inArea);
        robot.clickOn(area1);
        robot.press(KeyCode.CONTROL).press(KeyCode.A).release(KeyCode.A).release(KeyCode.CONTROL);
        robot.write("ABC,Proizvod,2");
        robot.clickOn(dodajArt);
        String inArea2 = area2.getText();
        assertEquals("ABC,Proizvod,2", inArea2);
    }

    @Test
    void dodavanjeArtiklaNaRacunTest(FxRobot robot) {
        TextArea area2 = robot.lookup("#unosArtikla").queryAs(TextArea.class);
        TextArea area1 = robot.lookup("#unosArtikla").queryAs(TextArea.class);
        Button dodajArt = robot.lookup("#dodaj").queryAs(Button.class);
        robot.clickOn(area1);
        robot.write("ABC,Proizvod,1\nDEF,Proizvod,1\nHFG,Proizvod,1");
        robot.clickOn(dodajArt);
        String inArea = area2.getText();
        assertEquals("ABC,Proizvod,1\nDEF,Proizvod,1\nHFG,Proizvod,1", inArea);
        robot.clickOn("#TabRacun");
        robot.clickOn("#choicebox");
        robot.type(KeyCode.DOWN).type(KeyCode.ENTER);
        robot.clickOn("#kolicina");
        robot.press(KeyCode.CONTROL).press(KeyCode.A).release(KeyCode.A).release(KeyCode.CONTROL);
        robot.type(KeyCode.DIGIT4);
        robot.clickOn("#dodajArtikle");
        TextArea area3 = robot.lookup("#aktuelniracun").queryAs(TextArea.class);
        String area3Str = area3.getText();
        assertEquals(" DEF 4 4.0\nUkupno: 4.0", area3Str);
    }
@Test
    void dodavanje2ArtiklaNaRacunTest(FxRobot robot) {
        TextArea area2 = robot.lookup("#unosArtikla").queryAs(TextArea.class);
        TextArea area1 = robot.lookup("#unosArtikla").queryAs(TextArea.class);
        Button dodajArt = robot.lookup("#dodaj").queryAs(Button.class);
        robot.clickOn(area1);
        robot.write("ABC,Proizvod,1\nDEF,Proizvod,1\nHFG,Proizvod,1");
        robot.clickOn(dodajArt);
        String inArea = area2.getText();
        assertEquals("ABC,Proizvod,1\nDEF,Proizvod,1\nHFG,Proizvod,1", inArea);
        robot.clickOn("#TabRacun");
        robot.clickOn("#choicebox");
        robot.type(KeyCode.DOWN).type(KeyCode.ENTER);
        robot.clickOn("#kolicina");
        robot.press(KeyCode.CONTROL).press(KeyCode.A).release(KeyCode.A).release(KeyCode.CONTROL);
        robot.type(KeyCode.DIGIT4);
        robot.clickOn("#dodajArtikle");
        robot.clickOn("#choicebox");
        robot.type(KeyCode.ENTER);
        robot.clickOn("#kolicina");
        robot.press(KeyCode.CONTROL).press(KeyCode.A).release(KeyCode.A).release(KeyCode.CONTROL);
        robot.type(KeyCode.DIGIT4);
        robot.clickOn("#dodajArtikle");
        TextArea area3 = robot.lookup("#aktuelniracun").queryAs(TextArea.class);
        String area3Str = area3.getText();
        assertEquals(" DEF 4 4.0\n DEF 4 4.0\nUkupno: 8.0", area3Str);
    }


}