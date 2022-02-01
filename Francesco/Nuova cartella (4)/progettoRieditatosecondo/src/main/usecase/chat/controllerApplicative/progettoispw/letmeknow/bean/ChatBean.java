package progettoispw.letmeknow.bean;

import progettoispw.letmeknow.controller.ChatController;
import progettoispw.letmeknow.controller.chat.Message;

import java.util.Vector;

public class ChatBean {
    private ChatController controller;
    private Vector<Message> chat;
    private Integer index;
    private String with;

    public ChatBean(){
        controller=new ChatController();
        with= controller.getWith();
        index=0;
    }
    public String getWith(){
        return with;
    }
    public void getChat(){
        chat=controller.getChat();
    }
    public String [] getMsg(){
        Message msg=chat.get(index);
       // System.out.println(index);
        String [] returnstr =new String[2];
        returnstr[0]=msg.getText();
        if(msg.getReciver().equals(with))returnstr[1]="i am the sender";
        else returnstr[1]="i am the reciver";
        index++;
        if(index>=chat.size()){
            index=0;
            return null;
        }
        return returnstr;
    }
    public void newMsg(String input){
        controller.newMSG(input);
    }
}
