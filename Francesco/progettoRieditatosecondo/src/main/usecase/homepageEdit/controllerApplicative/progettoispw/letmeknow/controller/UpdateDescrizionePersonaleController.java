package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.bean.UpdateDescrizionePersonaleBean;
import progettoispw.letmeknow.controller.utenti.utente123456;

public class UpdateDescrizionePersonaleController {
    private String userid;
    private utente123456 utente ;
    private UpdateDescrizionePersonaleBean bean;
    private String newStr;
    public UpdateDescrizionePersonaleController(String user,String input) {
        this.userid = user;
        this.newStr = input;
        utente=new utente123456(userid);
        utente.setDescrizione(newStr);
    }
}
