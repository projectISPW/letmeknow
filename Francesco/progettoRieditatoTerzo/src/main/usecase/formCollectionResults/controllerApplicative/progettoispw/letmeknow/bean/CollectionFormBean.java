//took out unused libraries

package progettoispw.letmeknow.bean;

import progettoispw.letmeknow.controller.CollectionFormController;
import progettoispw.letmeknow.controller.chat.Message;
import java.util.ArrayList;

public class CollectionFormBean {
    private CollectionFormController controller;
    public CollectionFormBean() {
        controller=new CollectionFormController();
    }
    public void setTouched(int formid){

    }
    public void takeForm(){
        controller.takeForm();
    }
    public String getUid(){return controller.getUserid();}
}
