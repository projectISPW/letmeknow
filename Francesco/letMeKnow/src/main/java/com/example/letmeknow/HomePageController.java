package com.example.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HomePageController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    protected void goToChat(ActionEvent event) throws IOException {
        root= FXMLLoader.load(getClass().getResource("InitialSearchAndChat.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.setTitle("What you need ? ");
        stage.show();
    }
    @FXML
    protected void editProfile(ActionEvent event) throws IOException {
        root=FXMLLoader.load(getClass().getResource("editProfile.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Edit Profile");
        stage.show();
    }
    @FXML
    protected void goToSettings(ActionEvent event) throws IOException {
        root=FXMLLoader.load(getClass().getResource("settings1.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Settings");
        stage.show();
    }
}
