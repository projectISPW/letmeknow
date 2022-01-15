package progettoispw.letmeknow.controller.form;

import progettoispw.letmeknow.controller.ControllerClass;
import progettoispw.letmeknow.controller.utenti.UtenteUsr;

public class ResultForm {
    private String userid;
    private int formid;
    private FormSQL formData;
    private int[] answers;
    private int complete;
    private int [] param;
    private String date;
    public ResultForm(String useridinp,int formidinp){
        formData=new FormSQL();
        userid=useridinp;
        formid=formidinp;
        answers= formData.queryResult(userid,formid);
        System.out.println("utente.:"+useridinp+"form.:"+formidinp);
        for(int i:answers){
            System.out.println("valore nell array" + i);
            if (i>=1){
                ++complete;
            }
        }
        if(complete==6){
            queryComplete();
        }
    }
    private void queryComplete(){
        ControllerClass factory=new ControllerClass();
        UtenteUsr user= factory.getUserUSR();
        date=formData.queryData(userid,formid);
        if(date ==null){
            formData.setCalculated(userid,formid);
            user.setParams();
            formData.close(userid,formid);
            date=formData.queryData(userid,formid);
        }
        param= formData.queryParamForm(userid,formid);
        System.out.println("DATA DEL FORM RESULT"+date);
    }
    public boolean setRisposte(int[] input){
        complete=0;
        for(int i=0;i<input.length;i++)System.out.println(input[i]);
        for(int i:input)if(i!=-1)++complete;
        return formData.setAnswer(userid,formid,input);
    }
    public int[] getRisposte(){
        return answers;
    }
    public int getComplete() {
        return complete;
    }
    public int[] getParam() {
        return param;
    }
    public String getDate() {
        return date;
    }
}
