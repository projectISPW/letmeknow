package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.bean.NewMessageBean;
import progettoispw.letmeknow.controller.chat.Message;
import progettoispw.letmeknow.controller.chat.Messages;

import java.util.ArrayList;
import java.util.List;

public class ChatController {
    private Messages actChat;
    public void  newMSG(NewMessageBean newMessage){
        actChat=ConcreteUsrUser.getChat();
        actChat.newMessage(newMessage.getReciver(),newMessage.getReciver());
    }
}
