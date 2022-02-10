package progettoispw.letmeknow.bean;

import progettoispw.letmeknow.controller.ConcreteUsrUser;
import progettoispw.letmeknow.controller.chat.Message;
import progettoispw.letmeknow.controller.chat.Messages;

import java.util.ArrayList;
import java.util.List;

public class ChatBean {
    private Messages actChat;
    private ArrayList<Message>lastChat;
    //his functional is to store the last messages that were stored in the chat so that in the next scan of messages the
    //bean return only new messages
    private String with;
    public ChatBean(){
        actChat= ConcreteUsrUser.getChat();
        with=actChat.getTouched();
    }
    public String  newMSG(String text){
        return actChat.newMessage(text,with);
    }
    public String getUID(){
        return actChat.getUserid();
    }
    private List<Message> getChat() {
        ArrayList<Message> chat;
        ArrayList<Message> newChat;
        chat= (ArrayList<Message>) actChat.chat(with,false);
        if(lastChat!=null){
            newChat=new ArrayList<>();
            for(int i= lastChat.size();i< chat.size();i++){
                newChat.add(chat.get(i));
            }
            lastChat=chat;
        }
        else {
            lastChat=chat;
            newChat=chat;
        }
        return newChat;
    }
    public String[]getMSG(){
        ArrayList<Message> chat= (ArrayList<Message>) getChat();
        String [] returnStr =new String[chat.size()*2];
        int index=0;
        for(Message msg:chat){
            returnStr[index++]= msg.getText();
            if(msg.getReciver().equals(with))returnStr[index++]="i am the sender";
            else returnStr[index++]="i am the receiver";
        }
        return returnStr;
    }
    public String getWith() {
        return with;
    }
}
