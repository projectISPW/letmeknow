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
    WordCheck textBean=new WordCheck(goAhead);
    Double ystart ;
    int htext;
    Integer hspacing= 80;
    int high=1;//ultimo messaggio altezza 1

    Label textmsg;
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
        scrollpane.fitToHeightProperty().set(true);
        ystart = lastmsg.getTranslateY()+hspacing+htext*high;
        hspacing=80;
        //25 padding superiore |high numero linee testo | 25 padding inferiore | 30 spaziatura
        wordTemp=textBean.check(inputmsg.getText());
        textmsg=new Label(wordTemp);// prende il testo con gli invio
        inputmsg.setText("");//resetto la textField
        //design
        textmsg.setTextFill(Color.WHITE);
        textmsg.setFont(Font.font("Gill Sans MT",FontWeight.BOLD,18));
        textmsg.setTranslateX(100);
        textmsg.setTranslateY(ystart);
        textmsg.setMinWidth(500);
        textmsg.setMaxWidth(300);
        textmsg.setMinHeight(60);
        textmsg.setBackground(new Background(new BackgroundFill(Color.rgb(55, 125, 255, 0.69),new CornerRadii(18.0),new Insets(-5.0))));
        messaggi.getChildren().add(textmsg);
        lastmsg=textmsg;
        high=textBean.contaInvio(wordTemp);
        hspacing=textBean.highText(wordTemp);
        System.out.println("high space:"+hspacing);
        messaggi.setPrefHeight(textmsg.getTranslateY()+high*htext+hspacing);
        scrollpane.setVvalue(1.0);
    }
}
