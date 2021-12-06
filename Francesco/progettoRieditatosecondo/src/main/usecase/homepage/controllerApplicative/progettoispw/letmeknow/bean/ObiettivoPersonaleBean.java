package progettoispw.letmeknow.bean;
import progettoispw.letmeknow.controller.ObiettivoPersonaleController;

import java.util.Calendar;


public class ObiettivoPersonaleBean {
    private String userid;
    private ObiettivoPersonaleController controller;
    public ObiettivoPersonaleBean (String user){
        this.userid=user;
    }
    public String exitObiettivo(){
        controller=new ObiettivoPersonaleController(userid);
        String obiettivo= controller.tornaObiettivo();
        return obiettivo;
    }public Integer[] exitData(){
        //possibile controllo con la data giornaliera
        controller=new ObiettivoPersonaleController(userid);
        Integer [] data=controller.tornaData();
        if(data[0]+1<Calendar.getInstance().YEAR){
            System.err.println("Non puoi tornare indietro nel tempo ");
        }
        if(data[1]>12 || data[1]<0){
            System.out.println(data[0]+"mese "+data[1]+"giorno "+data[2]);
            System.err.println("hai inserito un mese sbagliato");
        }else if(data[1]>(Calendar.getInstance().MONTH+6)%12){
            System.err.println("hai immesso un periodo troppo lungo");
        }
        if(data[1]>31 || data[1]<0){
            System.err.println("hai inserito un giorno sbagliato");
        }
        return data;
    }public String exitTag(){
        controller=new ObiettivoPersonaleController(userid);
        String tag=controller.tornaTag();
        if(tag.toCharArray()[0]!='#'){
            System.err.println("this is nont a tag");
        }
        return tag;
    }
}
