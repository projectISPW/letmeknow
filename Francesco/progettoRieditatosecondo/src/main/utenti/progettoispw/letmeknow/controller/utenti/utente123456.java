package progettoispw.letmeknow.controller.utenti;

public class utente123456 implements Utente{
    private String numeroUtente="123456";
    private Integer empatia=5;
    private Integer umorismo=4;
    private Integer positivita=3;
    private String descrPersonale="#Calm#honest#creative";
    private ObiettivoPersonale obbPersonale=new ObiettivoPersonale("i want to be\n a better person ");
    public utente123456(String input){
        if(input!=numeroUtente ){
            System.err.println("utente non corrispondente");
        }
        obbPersonale.setData(new Integer[]{1,1,2022});
        obbPersonale.setTag("#character");
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
    public String getObiettivo(){return obbPersonale.getObiettivo();}
    public Integer [] getData(){return obbPersonale.getData();}
    public String getTag(){return obbPersonale.getTag();}
    public void setDescrizione(String input){
        System.out.println("homepage recived:"+input);
        descrPersonale=input;
    }

}
