package progettoispw.letmeknow.bean;
import progettoispw.letmeknow.controller.*;
public class SliderBean {
    private String userid;
    private HomepageController controller;
    public Integer [] exitValue(){
        Integer valori []={0,0,0};
        controller=new HomepageController();
        //valori[0]=1;  valori[1]=1; valori[2]=1;
        valori[0]=controller.tornaValoriEmpatia();
        valori[1]=controller.tornaValoriUmorismo();
        valori[2]=controller.tornaValoriPositivita();
        for(int i =0;i<2;i++){
            if(valori[i]>5 || valori[i]<1){
            System.err.println("error occurred");
            }
        }
        return valori;
    }
}
