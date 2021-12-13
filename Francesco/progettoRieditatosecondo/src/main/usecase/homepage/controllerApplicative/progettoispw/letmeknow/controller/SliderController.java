package progettoispw.letmeknow.controller;
import progettoispw.letmeknow.controller.utenti.*;
public class SliderController {
    private String userid;
    private utente123456 User ;
    public SliderController(String user){
        this.userid=user;
        User =new utente123456(userid);
    }
    public int tornaValoriEmpatia(){
        //System.out.println(User.getEmpatia());
        return User.getEmpatia();
    }
    public int tornaValoriUmorismo(){
        return User.getUmorismo();
    }
    public int tornaValoriPositivita(){
        return User.getPositivita();
    }
}
