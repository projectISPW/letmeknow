package com.example.letmeknow;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import java.net.URL;



import java.io.IOException;
import java.util.ResourceBundle;

public class Settings1Controller implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

   @FXML
   private ComboBox<String> comb;



    @FXML
    protected void goEditProf(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("editProfile.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Home");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    protected void goToLogin(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Home");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void goToHome(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("homepage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Home");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
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
    protected void switchToRecoverPswd(ActionEvent event) throws IOException {
        root=FXMLLoader.load(getClass().getResource("recoverpassword.fxml"));

        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setTitle("RecoverPassword");
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

        @Override
        public void initialize(URL url, ResourceBundle rb){
            comb.setItems(FXCollections.observableArrayList("Italiano", "Inglese"));
    }}

