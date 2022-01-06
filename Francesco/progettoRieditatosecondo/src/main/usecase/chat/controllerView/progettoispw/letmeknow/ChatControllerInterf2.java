package progettoispw.letmeknow;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Duration;
import progettoispw.letmeknow.bean.ChatBean;
import progettoispw.letmeknow.bean.ISCBean;
import progettoispw.letmeknow.bean.beanResultSearch;

import java.io.IOException;
import java.util.Date;

public class ChatControllerInterf2 {
    @FXML
    AnchorPane messaggi;
    @FXML
    TextArea inputmsg;
    @FXML
    ScrollPane scrollpane;
    @FXML
    Text withName;
    @FXML
    AnchorPane listUtenti;
    @FXML
    Group groupStd;
    boolean initializated;
    private PageMenu controller= new PageMenu();
    ChatBean bean;
    ISCBean iscBean;
    beanResultSearch visitBean;
    private String [] message;
    private CSS graphic;
    Label textmsg;
    Timeline timeline;
    public ChatControllerInterf2(){
        bean=new ChatBean();
        iscBean=new ISCBean();
        visitBean=new beanResultSearch();
        graphic=new CSS(false);
        initializated=false;
        timeline=new Timeline(new KeyFrame(Duration.millis(15000),this::recivemsgArr));
        timeline.setCycleCount(Timeline.INDEFINITE);//never stop
    }

    @FXML
    protected void sendMsg() {
        bean.newMsg(inputmsg.getText());
        recivemsgArr();
        inputmsg.setText("");
    }
    public void recivemsgArr(ActionEvent event){
        if(initializated) recivemsgArr();
    }
    public void  recivemsgArr() {
        bean.getChat();
        message = bean.getMSG();
        System.out.println("*******inizioscansione + *********"+new Date().toString());
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
        System.out.println("*********finescansione********"+new Date().toString());
        initializated=true;
    }
    public void  initialize() throws InterruptedException {
        withName.setText("User #"+bean.getWith());
        System.out.println("stage inizializzato");
        recivemsgArr();
        addUser();
        this.timeline.play();
    }
    private int high=200;
    public  void addUser(){
        String [] uid= iscBean.exitUid();
        String [] msg=iscBean.exitMsg();
        Button [] add;
        for(int i=0;i< uid.length;i++){
            add=graphic.getUsersButton(uid[i],msg[i]);
            listUtenti.getChildren().addAll(add[0],add[1]);
            listUtenti.setPrefHeight(graphic.getHlist());
        }

    }
    @FXML
    protected void goToHome(ActionEvent event) throws IOException {
        timeline.stop();
        controller.switchToHome(event);
    }
    @FXML
    protected void goBack(ActionEvent event) throws IOException {
        timeline.stop();
        controller.switchTo("initialSearchAndChat/interf1.fxml",event,"Your chat");
    }
    @FXML
    protected void goToPersonalForm(ActionEvent event) throws IOException {
        timeline.stop();
        controller.switchToPersonalForm(event);
    }
    @FXML
    private void touchedHome(ActionEvent event){
        visitBean.touched(bean.getWith());
        timeline.stop();
        controller.switchTo("homepageOthers/interf1.fxml",event,"Visit");
    }
}
