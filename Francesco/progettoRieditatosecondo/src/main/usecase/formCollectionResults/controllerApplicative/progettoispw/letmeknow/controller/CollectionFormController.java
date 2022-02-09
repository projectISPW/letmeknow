package progettoispw.letmeknow.controller;

import progettoispw.controller.ConcreteUsrUser;

public class CollectionFormController {
   public void setTouched(int formid){
       ConcreteUsrUser.setResultForm(formid);
   }
    public void  takeForm(){
       ConcreteUsrUser.setResultForm();
    }
    public String getUserid(){return ConcreteUsrUser.getUser().getUserid();}
}
