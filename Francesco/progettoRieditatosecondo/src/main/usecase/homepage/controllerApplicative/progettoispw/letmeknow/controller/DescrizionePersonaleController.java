package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.controller.utenti.utente123456;

public class DescrizionePersonaleController {
    private String userid;
    private utente123456 utente ;
    public DescrizionePersonaleController(String user){
        this.userid=user;
        utente=new utente123456(userid);
    }
    public String tornaDescrizione(){
        String exit;
        exit= utente.getDescrizione();
        return exit;
    }
}
