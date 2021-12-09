package progettoispw.letmeknow.bean;
import progettoispw.letmeknow.WordCheck;
import progettoispw.letmeknow.controller.ObiettivoPersonaleController;

import java.util.Calendar;
import java.util.Date;


public class ObiettivoPersonaleBean {
    protected String userid;
    private ObiettivoPersonaleController controller;
    private WordCheck checkStr=new WordCheck(3,20);
    public ObiettivoPersonaleBean (String user){
        this.userid=user;
    }
    public String exitObiettivo(){
        controller=new ObiettivoPersonaleController(userid);
        String obiettivo= controller.tornaObiettivo();
        //System.out.println("nel bean dell homepage:"+obiettivo);
        if(checkStr.checkString(obiettivo)==false){
             System.err.println("è possibile che vada fuori la label ");
        }
        return obiettivo=checkStr.check(obiettivo);
    }public Integer[] exitData(){
        //possibile controllo con la data giornaliera
        controller=new ObiettivoPersonaleController(userid);
        Integer [] data=controller.tornaData();
        //if(data.getYear()<Calendar.YEAR){
        if(data[2]<Calendar.getInstance().get(Calendar.YEAR)){
            System.err.println("Obiettivo scaduto, da piu di un anno, aggiorna il tuo obiettivo ");
        }
        if(data[1]>Calendar.getInstance().get(Calendar.MONTH) && data[2]==Calendar.getInstance().get(Calendar.YEAR)){
            System.err.println("Obiettivo scaduto, da piu di un mese, aggiorna il tuo obiettivo");
        }
        return data;
    }public String exitTag(){
        controller=new ObiettivoPersonaleController(userid);
        String tag=controller.tornaTag();
        return tag;
    }
}
