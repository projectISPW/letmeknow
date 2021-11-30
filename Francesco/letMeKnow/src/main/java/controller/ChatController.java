package controller;

import com.example.letmeknow.Factory;
import com.example.letmeknow.PageMenu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

import java.io.IOException;

public class ChatController {
    @FXML
    AnchorPane messaggi;
    @FXML
    Label lastmsg;
    @FXML
    TextArea inputmsg;

    private Double hpane;
    int i=0;
    static Double ystart;
    private Scene scene;

    private Label textmsg,nextmsg;
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
    protected void sendMSG(ActionEvent event )throws IOException{
        if(i==0){
            ystart = lastmsg.getLayoutY();
        }
        i=i+1;
        ystart = ystart +89;//altezza ultimo messaggio
        textmsg=new Label(inputmsg.getText());
        nextmsg=new Label();
        textmsg.setTextFill(Color.WHITE);
        textmsg.setFont(Font.font("Gill Sans MT",FontWeight.BOLD,18));
        textmsg.setTranslateX(125);
        textmsg.setTranslateY(ystart);
        nextmsg.setPrefHeight(2000);
        nextmsg.setPrefWidth(20);
        textmsg.setMinWidth(256);
        textmsg.setMaxWidth(380);
        textmsg.setMinHeight(58);
        textmsg.setBackground(new Background(new BackgroundFill(Color.rgb(55, 125, 255, 0.69),new CornerRadii(18.0),new Insets(-5.0))));
        nextmsg.setBackground(new Background(new BackgroundFill(Color.BLACK,new CornerRadii(18.0),new Insets(-5.0))));
        hpane = messaggi.getHeight();
        messaggi.getChildren().addAll(textmsg,nextmsg);
        //scene = messaggi.getScene();
        //messaggi.prefHeightProperty().bind(scene.heightProperty());
        System.out.println(textmsg.getBorder() );//
        messaggi.setPrefHeight(textmsg.getTranslateY()+100);//al massimo supporta 4 linee
    }
}
