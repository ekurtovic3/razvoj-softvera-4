import static javafx.application.Application.launch;
import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;
import static org.junit.jupiter.api.Assertions.*;

import ba.unsa.etf.rs.tut4.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
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
    public void start (Stage stage) throws Exception {
        Parent root = (Parent) FXMLLoader.load(this.getClass().getResource("/fxml/sample.fxml"));
        stage.setTitle("Kasa");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.show();
        stage.toFront();
    }

    @Test
    public void DodajArtikalTest (FxRobot robot) {
        TextArea dodaj = robot.lookup("#unosArtikla").queryAs(TextArea.class);
        robot.clickOn("#unosArtikla");
        robot.write("SB,Proizvod,38");
        robot.clickOn("#dodaj");
        assertEquals("SB,Proizvod,38", dodaj.getText());

    }



}