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
import progettoispw.letmeknow.bean.ChatBean;

import java.io.IOException;

public class ChatControllerInterf1  {
    @FXML
    AnchorPane messaggi;
    @FXML
    Label lastmsg;
    @FXML
    TextArea inputmsg;
    @FXML
    ScrollPane scrollpane;
    private PageMenu controller= new PageMenu();

    ChatBean bean;
    private String [] message;
    private CSS graphic;
    Label textmsg;
    boolean alive;
    public ChatControllerInterf1(){
        graphic=new CSS();
        bean=new ChatBean();
        alive=true;
    }
    private void  recivemsg(){
        bean.getChat();
        message=bean.getMsg() ;
        while(message!=null){
            graphic.setText(message[0]);
            if(message[1].equals("i am the sender")){
                textmsg=graphic.getMessageSended();
            }
            else{
                textmsg=graphic.getMessageRecived();
            }
            System.out.println("nuovo messaggio"+message[0]+"  "+message[1]);
            messaggi.getChildren().add(textmsg);
            messaggi.setPrefHeight(graphic.getAumenta());
        }
        return ;
    }

    public void  initialize() throws InterruptedException {
        while(alive){
            recivemsg();
            Thread.sleep(1000);
        }
    }
    @FXML
    protected void sendMsg(){
        bean.newMsg(inputmsg.getText());
        inputmsg.setText("");
    }
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


}
