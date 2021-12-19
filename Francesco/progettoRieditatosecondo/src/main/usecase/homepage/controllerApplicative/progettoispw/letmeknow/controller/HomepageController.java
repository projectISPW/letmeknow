package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.controller.utenti.UtenteUsr;

public class HomepageController {
    ControllerClass factory=new ControllerClass();
    UtenteUsr user= factory.getUserUSR();
    public String getUserID(){
        return user.getUserid();
    }
    public int tornaValoriEmpatia(){
        return user.getEmp();
    }
    public int tornaValoriUmorismo(){
        return user.getHum();
    }
    public int tornaValoriPositivita(){
        return user.getPos();
    }
    public String tornaObiettivo(){
        return user.getObiettivo();
    }
    public Integer[] tornaData(){
        return user.getData();
    }
    public String tornaTag(){
        return user.getTag();
    }
    public String tornaDescrizione(){
        return user.getDescrizione();
    }
}