package com.example.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EditProfileController {
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
    }}
