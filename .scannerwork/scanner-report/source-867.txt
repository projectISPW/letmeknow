package controller;

import com.example.letmeknow.Factory;
import com.example.letmeknow.PageMenu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;

import java.io.IOException;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ChatController {
    @FXML
    AnchorPane messaggi;
    @FXML
    Label lastmsg;
    @FXML
    TextArea inputmsg;
    @FXML
    ScrollPane scrollpane;
    String wordTemp;
    int goAhead=30;
    private Double ystart ;
    private wordCheck ciao=new wordCheck(goAhead);
    private int high;

    private Label textmsg;
    private Factory factory=new Factory();
    private PageMenu controller= factory.createPageMenu();
    @FXML
    protected void goToHome(ActionEvent event) throws IOException {
        controller.switchToHome(event);
    }
    @FXML
    protected void goBack(ActionEvent event) throws IOException {
        controller.switchToChat(event);
    }
    @FXML
    protected void goToPersonalForm(ActionEvent event) throws IOException {
        controller.switchToPersonalForm(event);
    }
    @FXML
    protected void sendMSG(){
        ystart = lastmsg.getTranslateY()+89+high*18;
        wordTemp=wordCheck.check(inputmsg.getText());
        textmsg=new Label(wordTemp);
        inputmsg.setText("");
        textmsg.setTextFill(Color.WHITE);
        textmsg.setFont(Font.font("Gill Sans MT",FontWeight.BOLD,18));
        textmsg.setTranslateX(100);
        textmsg.setTranslateY(ystart);
        textmsg.setMinWidth(500);
        textmsg.setMaxWidth(300);
        textmsg.setMinHeight(58);
        textmsg.setBackground(new Background(new BackgroundFill(Color.rgb(55, 125, 255, 0.69),new CornerRadii(18.0),new Insets(-5.0))));
        messaggi.getChildren().add(textmsg);
        lastmsg=textmsg;
        high=wordCheck.contaInvio(wordTemp);
        messaggi.setPrefHeight(textmsg.getTranslateY()+high*18+89);
    }
}
