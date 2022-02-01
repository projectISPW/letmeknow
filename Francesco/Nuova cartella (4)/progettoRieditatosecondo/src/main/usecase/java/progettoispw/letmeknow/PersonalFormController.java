package progettoispw.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class PersonalFormController {
    Factory factory=new Factory();
    Page controller = factory.createPage();

    @FXML
    protected void goToSettings(ActionEvent event) throws IOException {
        controller.switchTo("settings/interf1.fxml",event,"Settings");
    }
    @FXML
    protected void goToChat(ActionEvent event) throws IOException {
        controller.switchTo("initialSearchAndChat/interf1.fxml",event,"What do you need ? ");
    }
    @FXML
    protected void goToHome(ActionEvent event) throws IOException {
        controller.switchTo("homepage/interf1.fxml",event,"Home");
    }
    @FXML
    protected void takeTheForm(ActionEvent event) throws IOException {
        controller.switchTo("formToTake/interf1form1.fxml",event,"homepage");
    }
    @FXML
    protected void urResult(ActionEvent event) throws IOException {
       controller.switchTo("formToTake/interf1form1.fxml",event,"Your result");
    }


}



/*bean da implementare ---------
-RENDERE CLICCABILI I SOLI MODULI A CUI HO RISPOSTO
-









 */