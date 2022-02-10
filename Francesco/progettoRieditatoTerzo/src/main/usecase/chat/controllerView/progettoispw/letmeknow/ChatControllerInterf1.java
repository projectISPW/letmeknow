package progettoispw.letmeknow;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

import javafx.scene.text.Text;
import javafx.util.Duration;
import progettoispw.letmeknow.bean.BeanResultSearch;


import javafx.animation.Timeline;
import progettoispw.letmeknow.bean.ChatBean;
import progettoispw.letmeknow.bean.NewMessageBean;
import progettoispw.letmeknow.controller.ChatController;


public class ChatControllerInterf1 {
    @FXML
    private AnchorPane messaggi;
    @FXML
    private TextArea inputmsg;
    @FXML
    private ScrollPane scrollpane;
    @FXML
    protected Text withName;
    protected  boolean initializated;
    protected  PageMenu pageSwitch;
    protected ChatBean bean;
    protected  String [] message;
    protected Decorator graphic;
    protected Timeline timeline;
    public ChatControllerInterf1() {
        bean=new ChatBean();
        graphic=new Decorator(true);
        initializated=false;
        pageSwitch =new PageMenu();
        timeline=new Timeline(new KeyFrame(Duration.millis(5000),this::action));
        timeline.setCycleCount(Animation.INDEFINITE);//never stop
    }
    @FXML
    protected void sendMsg() {
        NewMessageBean messageBean=new NewMessageBean();
        messageBean.setText(inputmsg.getText());
        messageBean.setReciver(withName.getText());
        ChatController controller=new ChatController();
        controller.newMSG(messageBean);
        recivemsgArr();
    }
    private  void action(ActionEvent event ){
        if(initializated) {
            recivemsgArr();
        }
    }
    public void  recivemsgArr() {
        message = bean.getMSG();
        Label textmsg;
        for (int i = 0; i < message.length; i += 2) {
            graphic.setText(message[i]);
            if (message[i + 1].equals("i am the sender")) {
                textmsg = graphic.getMessageSended();
            } else {
                textmsg = graphic.getMessageRecived();
            }
            messaggi.getChildren().add(textmsg);
            messaggi.setPrefHeight(graphic.getAumenta());
            scrollpane.setVvalue(1.0);
        }
        initializated=true;
    }
    public void  initialize(){
        withName.setText("User #"+bean.getWith());
        recivemsgArr();
        timeline.play();
    }
    @FXML
    protected void goToHome(ActionEvent event){
        timeline.stop();
        pageSwitch.switchToHome(event);
    }
    @FXML
    protected void goBack(ActionEvent event) {
        timeline.stop();
        pageSwitch.switchToISC(event);
    }
    @FXML
    protected void goToPersonalForm(ActionEvent event)  {
        timeline.stop();
        pageSwitch.switchToPersonalForm(event);
    }
    @FXML
    protected void touchedHome(ActionEvent event){
        BeanResultSearch visitBean=new BeanResultSearch();
        visitBean.touched(bean.getWith());
        timeline.stop();
        pageSwitch.switchTo("homepageOthers/interf1.fxml",event,"Visit");
    }
}
