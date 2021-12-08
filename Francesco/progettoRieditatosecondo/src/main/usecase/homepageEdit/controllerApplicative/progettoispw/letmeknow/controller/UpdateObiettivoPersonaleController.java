package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.controller.utenti.utente123456;

import java.util.Date;

public class UpdateObiettivoPersonaleController {
    private String userid;
    private utente123456 utente ;
    public UpdateObiettivoPersonaleController(String user, String obbInput , String tagInput, Integer [] scadenzaInput) {
        this.userid = user;
        utente=new utente123456(userid);
        utente.setObbPersonale(obbInput);
        utente.setTag(tagInput);
        utente.setData(scadenzaInput);
    }

}
