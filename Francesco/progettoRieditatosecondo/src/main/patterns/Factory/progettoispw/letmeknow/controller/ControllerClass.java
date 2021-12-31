package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.controller.chat.Messages;
import progettoispw.letmeknow.controller.search.Search;
import progettoispw.letmeknow.controller.utenti.SalvaUtente;
import progettoispw.letmeknow.controller.utenti.UtentePsy;
import progettoispw.letmeknow.controller.utenti.UtenteUsr;

public class ControllerClass {
    static   UtenteUsr userU;
    static  UtentePsy userP;
    static Search userRes;
    static Messages  chat;
    private String userID;
    public void  controllerUser(String userid){//la istanzia il controller della login
        userU=null;
        userP=null;
        userID=userid;
        SalvaUtente actual =new SalvaUtente(userid);
        switch(actual.getType()){
            case "usr":{
                userU=new UtenteUsr(userid);
            }
            case "psy":{
                userP= new UtentePsy(userid);
            }
        }
    }
    public  UtenteUsr getUserUSR(){
        return  userU=new UtenteUsr("1234567");
    }
    public void  controllerUsers(){//la istanzia il controller della login
        userRes =new Search("1234567");
    }
    public  Search getSearch(){
        return  userRes;
    }
    public void controllerChat(){
        chat=new Messages("1234567");
    }
    public Messages getChat(){
        return chat;
    }
}
