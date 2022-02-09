package progettoispw.letmeknow.controller;

import progettoispw.controller.ClassController;

public class CollectionFormController {
   public void setTouched(int formid){
       ClassController.setResultForm(formid);
   }
    public void  takeForm(){
       ClassController.setResultForm();
    }
    public String getUserid(){return ClassController.getUserUSR().getUserid();}
}
