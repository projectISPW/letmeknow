package progettoispw.letmeknow.bean;

import progettoispw.letmeknow.controller.UpdateDescrizionePersonaleController;

import static java.lang.Thread.sleep;

public class UpdateDescrizionePersonaleBean {
    private String userid;
    private UpdateDescrizionePersonaleController controller=new UpdateDescrizionePersonaleController(userid);;
    Thread tUp=new Thread(controller);
    public UpdateDescrizionePersonaleBean (String user){
        tUp.start();
        userid=user;
    }
    public void setOff(){
        controller.Off();
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
