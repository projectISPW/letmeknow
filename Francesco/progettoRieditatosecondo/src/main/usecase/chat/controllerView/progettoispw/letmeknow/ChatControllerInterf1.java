package progettoispw.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

import javafx.scene.text.Text;
import progettoispw.letmeknow.bean.ChatBean;
import progettoispw.letmeknow.bean.SignupBean;
import progettoispw.letmeknow.bean.beanResultSearch;

import java.io.IOException;

import static java.lang.Thread.sleep;

public class ChatControllerInterf1 extends Thread {
    @FXML
    AnchorPane messaggi;
    @FXML
    TextArea inputmsg;
    @FXML
    ScrollPane scrollpane;
    @FXML
    Text withName;
    private PageMenu controller= new PageMenu();

    ChatBean bean;
    beanResultSearch visitBean;
    private String [] message;
    private CSS graphic;
    Label textmsg;
    public ChatControllerInterf1() throws InterruptedException {
        bean=new ChatBean();
        visitBean=new beanResultSearch();
        graphic=new CSS();
    }
    @FXML
    protected void sendMsg() throws InterruptedException {
        bean.newMsg(inputmsg.getText());
        recivemsgArr();
        inputmsg.setText("");
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
                scrollpane.setVvalue(1.0);
            }
            System.out.println("*********************************");

    }
    public void  initialize() throws InterruptedException {
           withName.setText("User #"+bean.getWith());
           recivemsgArr();

    }

    @FXML
    protected void goToHome(ActionEvent event) throws IOException {
        controller.switchToHome(event);
    }
    @FXML
    protected void goBack(ActionEvent event) throws IOException {
       controller.switchTo("initialSearchAndChat/interf1.fxml",event,"Your chat");
    }
    @FXML
    protected void goToPersonalForm(ActionEvent event) throws IOException {
        controller.switchToPersonalForm(event);
    }
    @FXML
    private void touchedHome(ActionEvent event){
        visitBean.touched(bean.getWith());
        controller.switchTo("homepageOthers/interf1.fxml",event,"Visit");
    }
}
