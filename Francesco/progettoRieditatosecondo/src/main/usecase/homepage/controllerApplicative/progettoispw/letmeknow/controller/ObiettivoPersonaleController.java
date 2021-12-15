package progettoispw.letmeknow.controller;
import progettoispw.letmeknow.controller.utenti.SalvaUtente;
import progettoispw.letmeknow.controller.utenti.Utente;

import java.util.Date;

public class ObiettivoPersonaleController {
    private String userid;
    SalvaUtente user;
    public ObiettivoPersonaleController(String userInput){
        this.userid=userInput;
        user=new SalvaUtente(userid);
        user.dataHomeUsr();
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
}
