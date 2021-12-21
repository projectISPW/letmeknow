package progettoispw.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.IOException;

public class ChatController {
    @FXML
    AnchorPane messaggi;
    @FXML
    Label lastmsg;
    @FXML
    TextArea inputmsg;
    @FXML
    ScrollPane scrollpane;
    private Factory factory=new Factory();
    private PageMenu controller= factory.createPageMenu();
    @FXML
    protected void goToHome(ActionEvent event) throws IOException {
        controller.switchToHome(event);
    }
    @FXML
    protected void goBack(ActionEvent event) throws IOException {
        controller.backTo(event);
    }
    @FXML
    protected void goToPersonalForm(ActionEvent event) throws IOException {
        controller.switchToPersonalForm(event);
    }
    double hmsg=58;//altezza ultimo messaggio
    String wordTemp;
    int goAhead=30;
    int delta=10;
    WordCheck textBean=new WordCheck(delta,goAhead);
    Double ystart ;

    double hspacing= 30 ;
    Label textmsg;
    @FXML
    protected void sendMSG(){
        //messaggi.fitToHeightProperty().set(true);
        ystart = lastmsg.getTranslateY()+hmsg+hspacing;
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
        //fine design

        messaggi.getChildren().add(textmsg);
        String altezza= lastmsg.heightProperty().toString();
        /*int indice =altezza.indexOf("]");
        textmsg.getBoundsInParent();
        indice =altezza.length();
        String altezzaSub=altezza.substring(indice-5,indice-3);
        f= Integer.parseInt(altezzaSub);*/
       // System.out.println(altezza);
        lastmsg=textmsg;
        System.out.println(altezza);
        hmsg=textBean.highText(wordTemp);
        messaggi.setPrefHeight(textmsg.getTranslateY()+hmsg+hspacing);
        scrollpane.setVvalue(1.0);
    }
}
