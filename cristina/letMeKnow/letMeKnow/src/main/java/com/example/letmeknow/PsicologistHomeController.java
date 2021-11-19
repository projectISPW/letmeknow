package com.example.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PsicologistHomeController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    protected void backToLogin(ActionEvent event) throws IOException {
        root= FXMLLoader.load(getClass().getResource("login.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Login");
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
