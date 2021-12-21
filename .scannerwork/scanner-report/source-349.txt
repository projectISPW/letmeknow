package controller;

import com.example.letmeknow.Factory;
import com.example.letmeknow.Page;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class SignupController {
    private Factory factory=new Factory();
    private Page controller= factory.createPage();
    @FXML
    protected void backToLogin(ActionEvent event) throws IOException {
        controller.switchTo("login.fxml",event,"Login");
    }

    @FXML
    protected void Save(ActionEvent event) throws IOException {
        backToLogin(event);
    }

}
