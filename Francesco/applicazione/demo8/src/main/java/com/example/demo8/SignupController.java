package com.example.demo8;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SignupController
{
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    protected static void displayName(String username){

        System.out.println("Prompt Username: "+username);
    }

    @FXML
    protected void switchToScene1(ActionEvent event) throws IOException {
        root= FXMLLoader.load(getClass().getResource("login.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
