package progettoispw.letmeknow.controller.utenti;

import java.util.Date;

public class ObiettivoPersonale {
    static String obiettivo;
    static  String tag;
    //static Date data;
    static Integer[] data;
    public void setObiettivo(String string){
        this.obiettivo=string;
    }
    //public void setData(Date dataInp){       data=dataInp;    }
    public void setData(Integer [] arr){
        data=arr;
    }
    public void setTag(String string){
        tag=string;
    }
    public String getObiettivo(){
        return obiettivo;
    }
    //public Date getData(){        return data;    }
    public Integer[] getData(){return data;}
    public String getTag(){
        return tag;
    }
    public void getStatus(){
        System.out.println("il tuo obiettivo personale:"+obiettivo+"\ni tuoi tag:"+tag+"\nla tua scadenza:"+data[0]+"/"+data[1]+"/"+data[2]);
    }
}
