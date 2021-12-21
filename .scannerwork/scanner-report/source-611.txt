package progettoispw.letmeknow.bean;

import progettoispw.letmeknow.controller.FormToTakeStatusController;

public class FormToTakeStatusBean {
    String formid;
    FormToTakeStatusController controller;
    public FormToTakeStatusBean(String inputformid){
        formid=inputformid;
        controller=new FormToTakeStatusController(formid);
    }
    public boolean[] exitStatus(){
        return controller.getResponse();
    }
    public int[] exitValStatus(){
        return controller.getValResponse();
    }
    public void inputValStatus(int [] inputint){
        controller.setValResponse(inputint);
    }
    public int getComplete(){return controller.getValComplete();}
}
