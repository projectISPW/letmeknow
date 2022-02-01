package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.bean.innerUsers;
import progettoispw.letmeknow.bean.lastMessage;
import progettoispw.letmeknow.controller.chat.Message;
import progettoispw.letmeknow.controller.utenti.UtenteUsr;

import java.util.Vector;
public class ISCController {
        ControllerClass factory;
        private Vector<String> founded;
        private Integer count;
        private Integer nVal;
        private Vector<Message>msgs;
        public ISCController(Integer n){
            factory=new ControllerClass();
            factory.controllerChat();
            msgs=factory.getChat().getLast();
            founded=factory.getChat().getUsers();
            nVal=n;
            count=0;
        }
         Vector<lastMessage>formatted;
        public void attach(lastMessage elem){
            formatted.add(elem);
            //elem.getStatus();
        }
        lastMessage actual;
        public Vector<lastMessage> queryUsers(){
            int indice;
            actual=null;
            formatted=new Vector<>();
            count = check(count);
            for (String usr : founded) {
                indice = founded.indexOf(usr);
                if (indice >= count && indice < count + nVal) {
                    actual = new lastMessage(usr,msgs.get(indice));
                    //System.out.println(usr.getUserid()+"nel controller");
                    actual.getStatus();
                    attach(actual);
                }
            }
            count+=nVal;
            return formatted;
        }

        private Integer check(Integer count) {
            if(count>=founded.toArray().length){
                return count=0;
            }
            return count;
        }
        public void who(String usr){
            factory.getChat().setTouched(usr);
        }

    public void  getMsgs() {
        for(Message msg:msgs){
            msg.getStatus();
        }
    }
}

