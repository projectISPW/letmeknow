package com.example.letmeknow ;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RecoverPswdController
{
    private Stage stage;
    private Scene scene;
    private Parent root;

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
        root= FXMLLoader.load(getClass().getResource("login.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.show();
    }

}
