package progettoispw.letmeknow.controller.utenti;

import java.util.Date;

public class ObiettivoPersonale {
    static String obiettivo;
    static  String tag;
    static Date data;
    public void setObiettivo(String string){
        this.obiettivo=string;
    }
    public void setData(Date dataInp){
       data=dataInp;
    }
    public void setTag(String string){
        tag=string;
    }
    public String getObiettivo(){
        return obiettivo;
    }
    public Date getData(){
        return data;
    }
    public String getTag(){
        return tag;
    }
    public void getStatus(){
        System.out.println("il tuo obiettivo personale:"+obiettivo+"\ni tuoi tag:"+tag+"\nla tua scadenza:"+data.getYear()+"/"+data.getMonth()+"/"+data.getDay());
    }
}
