package progettoispw.letmeknow.bean;

import progettoispw.letmeknow.controller.HomepagePsicologistController;

public class HomepagePsicologistBean {
    HomepagePsicologistController controller;
    public HomepagePsicologistBean(){
        controller=new HomepagePsicologistController();
    }
    public float [] getForms(){
        try {
            controller.getLists(1, 2022);
            return controller.getList();
        }catch(NullPointerException e ){
            return new float[]{0};
        }
    }
}
