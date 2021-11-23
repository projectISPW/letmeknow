package com.example.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
    private PasswordField labPassword;
    @FXML
    private TextField labUser;
    @FXML
    protected void switchToSignup(ActionEvent event) throws IOException {
        root=FXMLLoader.load(getClass().getResource("signup.fxml"));
        //stage.setTitle("Signup");
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void switchToRecoverPswd(ActionEvent event) throws IOException {
        root=FXMLLoader.load(getClass().getResource("recoverpassword.fxml"));
        //stage.setTitle("RecoverPassword");
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void switchToHome(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("homepage.fxml"));
        root=loader.load();
        if(labUser.getText().equals("") || labPassword.getText().equals(""))
        {
            System.out.println("inserisci una stringa ");
            event.consume();
        }else {            RecoverPswdController.displayName(labUser);
            RecoverPswdController.displayPassword(labPassword);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            //stage.setTitle("Home");
            stage.setScene(scene);
            stage.show();
        }
    }}
