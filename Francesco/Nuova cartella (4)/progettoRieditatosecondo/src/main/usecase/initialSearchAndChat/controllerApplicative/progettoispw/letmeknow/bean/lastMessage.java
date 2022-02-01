package progettoispw.letmeknow.bean;

import progettoispw.letmeknow.controller.chat.Message;
import progettoispw.letmeknow.controller.utenti.UtenteUsr;

public class lastMessage {
    private String userid;
    private String lastmsg;
    public lastMessage(String elem, Message message){
        userid=elem;
        lastmsg=message.getText();
    }
    public String getUserid() {
        return userid;
    }
    public String getLastmsg() {
        return lastmsg;
    }
    public void getStatus(){
        System.out.println("ultimo messaggio nella chat con .:  " +userid+ "pari a .:  "+lastmsg);
    }
}
