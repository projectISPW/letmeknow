package progettoispw.letmeknow.controller;
import progettoispw.letmeknow.controller.utenti.*;
public class SliderController {
    private String userid;
    private SalvaUtente user ;
    public SliderController(String inputUser){
        this.userid=inputUser;
        user =new SalvaUtente(userid);
        user.dataHomeUsr();
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
}
