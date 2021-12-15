package progettoispw.letmeknow.controller.utenti;

public class Utente implements Utente1 {
    static Boolean i=true;
    private String numeroUtente="123456";
    static Integer empatia;
    static Integer umorismo;
    static Integer positivita;
    static String descrPersonale;
    static Goal obbPersonale=new Goal();
    public Utente(String input){
        if(input!=numeroUtente ){
            System.err.println("utente non corrispondente");
        }
        if ((input == numeroUtente && i)) {
            empatia=5;
            umorismo=4;
            positivita=3;
            descrPersonale="#Calm#honest#creative";
            /*obbPersonale.setObiettivo("I want to become a better person");
            //obbPersonale.setData(new Date(2022,8,1));
            obbPersonale.setData(new Integer[]{1,8,2020});
            obbPersonale.setTag("#character");
            i=false;*/
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
    public String getObiettivo(){ return obbPersonale.getObiettivo();}
    public Integer[] getData(){return obbPersonale.getData();}
    public String getTag(){return obbPersonale.getTag();}
    public void setDescrizione(String input){
        descrPersonale=input;
    }
    public String setObbPersonale(String input){
        obbPersonale.setObiettivo(input);
        return input;
    }
    public void setData(Integer [] value){
        obbPersonale.setData(value);
    }
    public void setTag(String input){
        obbPersonale.setTag(input);
    }
    int somma=0,indice=0;
    public void setEmpatia(double ...input){
        for(double f :input){
            ++indice;
            somma+=f;
        }
        empatia=(int)(somma+empatia)/indice+1;
    }
    public void setUmorismo(double ... input){
        somma=0;indice=0;
        for(double f :input){
            ++indice;
            somma+=f;
        }
        umorismo=(int)(somma+umorismo)/indice+1;
    }
    public void setPositivita(double ... input){
        somma=0;indice=0;
        for(double f :input){
            ++indice;
            somma+=f;
        }
        umorismo=(int)(somma+positivita)/indice+1;
    }
}
