package progettoispw.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class takeformControllerInterf1 {
    private Factory factory=new Factory();
    private PageMenu controller= factory.createPageMenu();
    @FXML
    protected void goBack(ActionEvent event) throws IOException {
        controller.switchToPersonalForm(event);
    }
    @FXML
    protected void goToHome(ActionEvent event) throws IOException {
        controller.switchToHome(event);
    }
    @FXML
    protected void goToChat(ActionEvent event) throws IOException {
       controller.switchToChat(event);
    }
}
