package progettoispw.letmeknow.bean;

import progettoispw.letmeknow.controller.HomepageController;

public class HomepageBean {
    HomepageController controller=new HomepageController();
    public String getUserId(){
        return controller.getUserID();
    }
}
