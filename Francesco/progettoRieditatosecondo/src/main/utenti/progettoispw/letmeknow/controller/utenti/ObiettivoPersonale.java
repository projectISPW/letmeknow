package progettoispw.letmeknow.controller.utenti;

public class ObiettivoPersonale {
    private String obiettivo;
    private Integer giorno;
    private Integer mese;
    private Integer anno;
    private  String tag;
    private Integer [] Data={0,0,0};
    public ObiettivoPersonale(String string){
        obiettivo=string;
    }
    public void setData(Integer data[]){
        //costruttore prende data da formato italiano e porta a inglese
        Data[2]=giorno=data[2];
        Data[1]=mese=data[1];
        Data[0]=anno=data[0];

    }
    public void setTag(String string){
        tag=string;
    }
    public String getObiettivo(){
        return obiettivo;
    }
    public Integer[] getData(){
        return Data;
    }
    public String getTag(){
        return tag;
    }

}
