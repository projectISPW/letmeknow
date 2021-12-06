package progettoispw.letmeknow.controller;
import progettoispw.letmeknow.controller.utenti.utente123456;
public class ObiettivoPersonaleController {
    private String userid;
    public ObiettivoPersonaleController(String user){
        this.userid=user;
    }
    public String tornaObiettivo(){
        utente123456 user =new utente123456(userid);
        return user.getObiettivo();
    }
    public Integer [] tornaData(){
        utente123456 user =new utente123456(userid);
        return user.getData();
    }
    public String tornaTag(){
        utente123456 user =new utente123456(userid);
        return user.getTag();
    }
}
