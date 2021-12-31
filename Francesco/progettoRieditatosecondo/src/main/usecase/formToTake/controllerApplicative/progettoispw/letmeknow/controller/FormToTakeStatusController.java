package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.controller.form.ResultForm1;
import progettoispw.letmeknow.controller.utenti.UtenteUsr;

public class FormToTakeStatusController {
    String userid;
    String formid;
    ResultForm1 form;
    ControllerClass factory;
    UtenteUsr user;
    public FormToTakeStatusController(String inputform){
        factory=new ControllerClass();
        user= factory.getUserUSR();
        formid=inputform;
        form= new ResultForm1(user.getUserid(),"form1");
    }
    public boolean[] getResponse(){
        boolean [] arr=form.getRisposteDate();
        for(boolean i : arr)System.out.println(i);
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