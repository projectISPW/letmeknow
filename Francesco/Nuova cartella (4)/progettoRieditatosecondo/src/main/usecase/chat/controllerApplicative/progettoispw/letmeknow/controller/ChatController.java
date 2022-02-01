package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.controller.chat.Message;
import progettoispw.letmeknow.controller.chat.Messages;

import java.util.Vector;

public class ChatController {
    private ControllerClass factory;
    private Messages actChat;
    private Vector<Message> chat;
    private String with;
    public ChatController(){
        factory =new ControllerClass();
        factory.controllerChat();
        actChat= factory.getChat();
        with=actChat.getTouched();
        chat=actChat.chat(with);
    }
    public void  newMSG(String text){
        actChat.newMessage(text,with);
    }

    public Vector<Message> getChat() {

        return chat;
    }

    public String getWith() {
        return with;
    }
}
