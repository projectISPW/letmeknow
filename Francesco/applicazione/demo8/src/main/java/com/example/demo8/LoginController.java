package com.example.demo8;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class LoginController {
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

}