package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.controller.utenti.SalvaUtente;
import progettoispw.letmeknow.controller.utenti.Utente;

public class DescrizionePersonaleController {
    private String userid;
    private SalvaUtente utente ;
    public DescrizionePersonaleController(String user){
        this.userid=user;
        utente=new SalvaUtente(userid);
        utente.dataHomeUsr();
    }
    public String tornaDescrizione(){
        return utente.getDescrizione();
    }
}
