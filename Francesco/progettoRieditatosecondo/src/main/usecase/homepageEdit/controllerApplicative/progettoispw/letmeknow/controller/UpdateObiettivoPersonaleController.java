package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.controller.utenti.SalvaUtente;
public class UpdateObiettivoPersonaleController {
    private String userid;
    private SalvaUtente utente ;
    public UpdateObiettivoPersonaleController(String user, String obbInput , String tagInput, Integer [] scadenzaInput) {
        this.userid = user;
        utente=new SalvaUtente(userid);
        utente.setPersonalGoal(obbInput);
        utente.setPersonalTag(tagInput);
        utente.setPersonalData(scadenzaInput);
    }

}
