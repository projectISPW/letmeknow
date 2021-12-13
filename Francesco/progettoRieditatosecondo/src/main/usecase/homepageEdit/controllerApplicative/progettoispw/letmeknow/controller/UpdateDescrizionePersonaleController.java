package progettoispw.letmeknow.controller;
import progettoispw.letmeknow.controller.utenti.utente123456;

import static java.lang.Thread.sleep;

public class UpdateDescrizionePersonaleController implements Runnable{
    private String userid;
    private utente123456 utente=new utente123456(userid);
    private String newStr;
    private boolean alive=false;
    public UpdateDescrizionePersonaleController(String user,String input) {
        this.userid = user;
        this.newStr = input;
        utente=new utente123456(userid);
        utente.setDescrizione(newStr);
    }
    public UpdateDescrizionePersonaleController(String user){
        userid=user;
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
            if(newStr!=null && newStr!=utente.getDescrizione())utente.setDescrizione(newStr);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
