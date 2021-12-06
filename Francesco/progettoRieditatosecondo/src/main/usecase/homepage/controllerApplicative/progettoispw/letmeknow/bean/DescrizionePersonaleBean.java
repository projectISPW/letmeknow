package progettoispw.letmeknow.bean;

import progettoispw.letmeknow.controller.DescrizionePersonaleController;

public class DescrizionePersonaleBean {
    private String userid;
    private DescrizionePersonaleController controller;
    public DescrizionePersonaleBean (String user){
        this.userid=user;
    }
    public String exitValue(){
        controller=new DescrizionePersonaleController(userid);
        String output= controller.tornaDescrizione();
        return output;
    }
}
