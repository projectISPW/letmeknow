package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.controller.form.ResultForm1;

public class FormToTakeStatusController {
    String userid;
    String formid;
    ResultForm1 form;
    public FormToTakeStatusController(String inputuserid,String inputform){
        userid=inputuserid;
        formid=inputform;
        form= new ResultForm1(userid,formid);
    }
    public boolean[] getResponse(){
        return form.getRisposteDate();
    }
    public void setValResponse(int [] passaggio){
        form.setRisposte(passaggio);
    }
    public int[] getValResponse(){
        return form.getValRisposteDate();
    }
    public int getValComplete(){
        return form.getComplete();
    }
}