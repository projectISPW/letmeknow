package com.example.demo8;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    //private AnchorPane pane;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label labPassword,labUser;
    @FXML
    private Button butHello;
    @FXML
    protected void nascondilabel(ActionEvent event){
        //labPassword.setBackground(new Background(new BackgroundFill(Color.GREY , CornerRadii.EMPTY, Insets.EMPTY)));
        labPassword.setStyle("-fx-background-color: #E5E5E5 ");
        labUser.setStyle("-fx-background-color: #E5E5E5 ");
        butHello.setStyle("-fx-background-color:#377DFF");
    }
    @FXML
    protected void switchToScene1(ActionEvent event) throws IOException {
        root=FXMLLoader.load(getClass().getResource("login.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void switchToScene2(ActionEvent event) throws IOException {
        root=FXMLLoader.load(getClass().getResource("signup.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setTitle("signup");
        stage.setScene(scene);
        stage.show();
    }

}