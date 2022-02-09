package progettoispw.letmeknow.controller;

import progettoispw.controller.ClassController;
public class LoginController {
    public boolean getLog(String userid, String password){
        return ClassController.concreteUser(userid,password);
    }
    public String getType(){
        return ClassController.getUser().getType();
    }
}
