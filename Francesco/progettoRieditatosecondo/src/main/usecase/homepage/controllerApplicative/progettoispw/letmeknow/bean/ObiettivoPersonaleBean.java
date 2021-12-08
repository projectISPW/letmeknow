package progettoispw.letmeknow.bean;
import progettoispw.letmeknow.controller.ObiettivoPersonaleController;

import java.util.Calendar;
import java.util.Date;


public class ObiettivoPersonaleBean {
    protected String userid;
    private ObiettivoPersonaleController controller;
    private UpdateObiettivoPersonaleBean controllerUpdate;
    public ObiettivoPersonaleBean (String user){
        this.userid=user;
    }
    public String exitObiettivo(){
        controller=new ObiettivoPersonaleController(userid);
        String obiettivo= controller.tornaObiettivo();
        //System.out.println("nel bean dell homepage:"+obiettivo);
        return obiettivo;
    }public Date exitData(){
        //possibile controllo con la data giornaliera
        controller=new ObiettivoPersonaleController(userid);
        Date data=controller.tornaData();
        if(data.getYear()<Calendar.YEAR){
            System.err.println("Obiettivo scaduto, da piu di un anno, aggiorna il tuo obiettivo ");
        }
        if(data.getMonth()>Calendar.MONTH && data.getYear()==Calendar.YEAR){
            System.err.println("Obiettivo scaduto, da piu di un mese, aggiorna il tuo obiettivo");
        }
        return data;
    }public String exitTag(){
        controller=new ObiettivoPersonaleController(userid);
        String tag=controller.tornaTag();
        return tag;
    }
}
