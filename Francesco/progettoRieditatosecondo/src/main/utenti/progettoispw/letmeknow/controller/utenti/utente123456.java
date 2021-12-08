package progettoispw.letmeknow.controller.utenti;

import java.util.Date;

public class utente123456 implements Utente{
    static Boolean i=true;
    private String numeroUtente="123456";
    static Integer empatia=5;
    static Integer umorismo=4;
    static Integer positivita=3;
    static String descrPersonale="#Calm#honest#creative";
    static ObiettivoPersonale obbPersonale=new ObiettivoPersonale();
    public utente123456(String input){
        if(input!=numeroUtente ){
            System.err.println("utente non corrispondente");
        }
        if (i == true) {
            obbPersonale.setObiettivo("I want to become a better person");
            obbPersonale.setData(new Date(2022,8,1));
            obbPersonale.setTag("#character");
            i=false;
        }

    }
    public int getEmpatia(){
        return empatia;
    }
    public int getUmorismo(){
        return umorismo;
    }
    public int getPositivita(){
        return positivita;
    }
    public String getDescrizione(){
        return descrPersonale;
    }
    public String getObiettivo(){
       // System.out.println("nel database :"+obbPersonale.getObiettivo() );
        return obbPersonale.getObiettivo();}
    public Date getData(){return obbPersonale.getData();}
    public String getTag(){return obbPersonale.getTag();}
    public void setDescrizione(String input){
        descrPersonale=input;
        //System.out.println("nuova descr personale :"+ descrPersonale);
    }
    public String setObbPersonale(String input){
        obbPersonale.setObiettivo(input);
        //System.out.println("nuovo obiettivo personale :"+ obbPersonale.getObiettivo());
        //obbPersonale.getStatus();
        return input;
    }
    public void setData(Date value){
        obbPersonale.setData(value);

    }
    public void setTag(String input){
        obbPersonale.setTag(input);
        //obbPersonale.getStatus();
    }


}
