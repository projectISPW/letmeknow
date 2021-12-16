package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.controller.utenti.SalvaUtente;

public class LoginController {
    private String userid;
    private SalvaUtente utente ;
    private String password;
    public LoginController(String user,String password){
        this.userid=user;
        this.password=password;
        utente=new SalvaUtente(userid);
    }
    public String tornaLog(){
        return utente.abscessType(password);
    }
}
