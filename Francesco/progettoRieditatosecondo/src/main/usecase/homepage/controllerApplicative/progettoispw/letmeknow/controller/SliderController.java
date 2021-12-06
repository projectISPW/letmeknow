package progettoispw.letmeknow.controller;
import progettoispw.letmeknow.controller.utenti.*;
public class SliderController {
    private String userid;
    public SliderController(String user){
        this.userid=user;
    }
    public int tornaValoriEmpatia(){
        utente123456 user =new utente123456(userid);
        return user.getEmpatia();
    }
    public int tornaValoriUmorismo(){
       utente123456 user =new utente123456(userid);
        return user.getUmorismo();
    }
    public int tornaValoriPositivita(){
        utente123456 user =new utente123456(userid);
        return user.getPositivita();
    }
}
