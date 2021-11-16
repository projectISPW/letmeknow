package com.example.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Popup;
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

        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setTitle("Signup");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void switchToRecoverPswd(ActionEvent event) throws IOException {
        root=FXMLLoader.load(getClass().getResource("recoverpassword.fxml"));

        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setTitle("RecoverPassword");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void switchToHome(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("homepage.fxml"));
        root=loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();


        if(labUser.getText().equals("") || labPassword.getText().equals(""))
        {
            //Alert Dialog Message per campi email e password vuoti
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Empty Fields!");
            alert.setHeaderText("Empty Email / Password Field");
            alert.setContentText("Please, fill Email and Password Fields. They cannot be empty.");

            if(alert.showAndWait().get()==ButtonType.OK){
                System.out.println("Prompt: Empty Fields Alert");
                event.consume();
            }


        }else {
            RecoverPswdController.displayName(labUser);
            RecoverPswdController.displayPassword(labPassword);

            scene = new Scene(root);
            stage.setTitle("Home");
            stage.setScene(scene);
            stage.show();
        }
    }}
