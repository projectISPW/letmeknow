package progettoispw.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpPsychController {
    Factory factory= new Factory();
    Page controller= factory.createPage();
    @FXML
    protected void backToLogin(ActionEvent event) throws IOException {
        controller.switchTo("login/interf1.fxml",event,"Login");
    }
    @FXML
    protected void Save(ActionEvent event) throws IOException {
        backToLogin(event);
    }
}
