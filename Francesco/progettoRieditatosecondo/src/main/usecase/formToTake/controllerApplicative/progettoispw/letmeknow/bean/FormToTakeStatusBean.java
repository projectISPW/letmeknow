package progettoispw.letmeknow.bean;

import progettoispw.letmeknow.controller.FormToTakeStatusController;

public class FormToTakeStatusBean {
    String userid;
    String formid;
    FormToTakeStatusController controller;
    public FormToTakeStatusBean(String inputuserid,String inputformid){
        userid=inputuserid;
        formid=inputformid;
        controller=new FormToTakeStatusController(userid,formid);
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
