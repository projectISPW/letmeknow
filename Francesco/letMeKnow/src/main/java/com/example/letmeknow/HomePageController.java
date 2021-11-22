package com.example.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class HomePageController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    //Image im1= new Image(getClass().getResourceAsStream("val0.png"));
    @FXML
    private ImageView Sl3;
    @FXML
    private ImageView Sl2;
    @FXML
    private ImageView Sl1;
    /*
    @FXML
    protected void  sl(ActionEvent event) throws IOException {
        System.out.println(Sl1.getImage());
        //Sl1.setImage(im1);
        //Sl3.setImage(com.example.letmeknow.Photo.homepage.val0.png);
    }*/
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
    protected void goToPersonalForm(ActionEvent event) throws IOException {
        root= FXMLLoader.load(getClass().getResource("personalForm.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Yor form");
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
        root=FXMLLoader.load(getClass().getResource("settings.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Settings");
        stage.show();
    }
}
