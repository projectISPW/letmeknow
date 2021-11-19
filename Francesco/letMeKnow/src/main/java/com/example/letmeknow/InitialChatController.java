package com.example.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class InitialChatController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    protected void goToHome(ActionEvent event) throws IOException {
        root= FXMLLoader.load(getClass().getResource("homepage.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Homepage ");
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void goToChat(ActionEvent event) throws IOException {
        root= FXMLLoader.load(getClass().getResource("chat.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setTitle("Chat");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void goToSearch(ActionEvent event) throws IOException {
        root= FXMLLoader.load(getClass().getResource("search.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setTitle("Search");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void goToSettings(ActionEvent event) throws IOException {
        root=FXMLLoader.load(getClass().getResource("settings1.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.setTitle("settings");
        stage.show();
    }

}
