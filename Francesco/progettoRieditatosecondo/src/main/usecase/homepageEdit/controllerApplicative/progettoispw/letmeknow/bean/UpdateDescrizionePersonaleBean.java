package progettoispw.letmeknow.bean;

import progettoispw.letmeknow.controller.UpdateDescrizionePersonaleController;

public class UpdateDescrizionePersonaleBean {
    private String userid;
    private String newStr;
    private UpdateDescrizionePersonaleController controller;
    public UpdateDescrizionePersonaleBean (String user){
        userid=user;
    }
    public void entryValue(String Value){
        if(Value!=""){
            if(Value.toCharArray()[0]=='#'){
            newStr=Value;
            controller= new UpdateDescrizionePersonaleController(userid,newStr);
        }}
    }
}
