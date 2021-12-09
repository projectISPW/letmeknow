package progettoispw.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class RecoverPswdController
{
    private Factory factory=new Factory();
    private Page controller= factory.createPageMenu();
    @FXML
    protected static void displayName(TextField username){
        System.out.println("Prompt Username: "+username.getText());
    }

    @FXML
    protected static void displayPassword(PasswordField pw){

        System.out.println("Prompt Password: "+pw.getText());
    }

    @FXML
    protected void backToLogin(ActionEvent event) throws IOException {
        //controller.switchTo("login.fxml",event,"Login");
        controller.switchTo("login/interf1.fxml",event,"Login");
    }

}
