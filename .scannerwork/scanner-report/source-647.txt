package progettoispw.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class SignupController {
    private Factory factory=new Factory();
    private Page controller= factory.createPage();
    @FXML
    protected void backToLogin(ActionEvent event) throws IOException {
        controller.switchTo("login/interf1.fxml",event,"Login");
    }

    @FXML
    protected void Save(ActionEvent event) throws IOException {
        backToLogin(event);
    }

}
