package progettoispw.letmeknow.bean;

import progettoispw.letmeknow.controller.UpdateDescrizionePersonaleController;

import static java.lang.Thread.sleep;

public class UpdateDescrizionePersonaleBean {
    private String userid;
    private UpdateDescrizionePersonaleController controller;
    Thread tUp;
    public UpdateDescrizionePersonaleBean (String user){

        userid=user;
        controller=new UpdateDescrizionePersonaleController(userid);
        tUp=new Thread(controller);
        tUp.start();
    }
    public void setOff(){
        controller.Off();
        tUp.stop();
    }
    public void entryValue(String Value){
        if(Value!=""){
            //if(Value.toCharArray()[0]=='#'){
            try {
                controller.setString(Value);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
