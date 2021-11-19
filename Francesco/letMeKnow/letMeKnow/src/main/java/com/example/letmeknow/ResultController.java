package com.example.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ResultController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    protected void goBack(ActionEvent event) throws IOException {
        root=FXMLLoader.load(getClass().getResource("search.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void goHomeOtr(ActionEvent event) throws IOException {
        root=FXMLLoader.load(getClass().getResource("homepageOther.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Visit");
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void goChat(ActionEvent event) throws IOException {
        root=FXMLLoader.load(getClass().getResource("chat.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Chat");
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void goToHome(ActionEvent event) throws IOException {
        root= FXMLLoader.load(getClass().getResource("homepage.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Homepage");
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
