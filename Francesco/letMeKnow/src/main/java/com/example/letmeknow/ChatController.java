package com.example.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ChatController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    protected void goToHome(ActionEvent event) throws IOException {
        root= FXMLLoader.load(getClass().getResource("homepage.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Home");
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void goBack(ActionEvent event) throws IOException {
        root= FXMLLoader.load(getClass().getResource("initialSearchAndChat.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("What you want to do ? ");
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void goToPersonalForm(ActionEvent event) throws IOException {
        root= FXMLLoader.load(getClass().getResource("personalForm.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Yor result");
        stage.show();
    }

}
