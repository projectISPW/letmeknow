package progettoispw.letmeknow.bean;
import progettoispw.letmeknow.controller.HomepageController;

public class DescrizionePersonaleBean {
    private String userid;
    private HomepageController controller=new HomepageController();;
    public DescrizionePersonaleBean (String user){
        this.userid=user;
    }
    public String exitValue(){
        String output= controller.tornaDescrizione();
        return output;
    }
}
