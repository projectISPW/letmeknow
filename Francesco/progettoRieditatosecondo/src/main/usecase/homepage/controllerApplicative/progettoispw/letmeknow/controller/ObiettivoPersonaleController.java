package progettoispw.letmeknow.controller;
import progettoispw.letmeknow.controller.utenti.utente123456;

import java.util.Date;

public class ObiettivoPersonaleController {
    private String userid;
    public ObiettivoPersonaleController(String user){
        this.userid=user;
    }

    public String tornaObiettivo(){
        utente123456 user =new utente123456(userid);
        //System.out.println("nel controller dell homepage:"+user.getObiettivo());
        return user.getObiettivo();
    }
    public Date tornaData(){
        utente123456 user =new utente123456(userid);
        return user.getData();
    }
    public String tornaTag(){
        utente123456 user =new utente123456(userid);
        return user.getTag();
    }
}
