package progettoispw.letmeknow.controller;
import progettoispw.letmeknow.controller.utenti.SalvaUtente;
import progettoispw.letmeknow.controller.utenti.Utente;

import static java.lang.Thread.sleep;

public class UpdateDescrizionePersonaleController implements Runnable{
    private String userid;
    private SalvaUtente utente;
    private String newStr;
    private boolean alive=false;
    public UpdateDescrizionePersonaleController(String user,String input) {
        this.userid = user;
        this.newStr = input;
        utente=new SalvaUtente(userid);
        utente.setPersonalDes(newStr);
    }
    public UpdateDescrizionePersonaleController(String user){

        userid=user;
        utente=new SalvaUtente(userid);
    }
    public void On(){
        alive=true;
    }
    public void Off(){
        alive=false;
    }
    public void setString(String input){
        newStr=input;
    }
    @Override
    public void run(){
        alive=true;
        while(alive){
            //System.out.println("i am alive");
            if(newStr!=null && newStr!=utente.getDescrizione())utente.setPersonalDes(newStr);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
