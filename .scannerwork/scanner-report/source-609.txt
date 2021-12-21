package progettoispw.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

import progettoispw.letmeknow.bean.ChatBean;

import java.io.IOException;

import static java.lang.Thread.sleep;

public class ChatControllerInterf1 extends Thread {
    @FXML
    AnchorPane messaggi;
    @FXML
    TextArea inputmsg;
    @FXML
    ScrollPane scrollpane;
    private PageMenu controller= new PageMenu();

    ChatBean bean;
    private String [] message;
    private CSS graphic;
    Label textmsg;
    public ChatControllerInterf1() throws InterruptedException {
        bean=new ChatBean();
        graphic=new CSS();
    }
    @FXML
    protected void sendMsg() throws InterruptedException {
        bean.newMsg(inputmsg.getText());
        recivemsgArr();
    }

    public void  recivemsgArr() throws InterruptedException {
            bean.getChat();
            message = bean.getMSG();
            System.out.println("*********************************");
            for (int i = 0; i < message.length; i += 2) {
                graphic.setText(message[i]);
                System.out.println(message[i]);
                if (message[i + 1].equals("i am the sender")) {
                    textmsg = graphic.getMessageSended();
                } else {
                    textmsg = graphic.getMessageRecived();
                }

                messaggi.getChildren().add(textmsg);
                messaggi.setPrefHeight(graphic.getAumenta());
            }
            System.out.println("*********************************");

    }
    public void  initialize() throws InterruptedException {
           recivemsgArr();
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
