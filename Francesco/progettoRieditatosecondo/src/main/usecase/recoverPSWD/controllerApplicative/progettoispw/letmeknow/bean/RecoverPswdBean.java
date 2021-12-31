package progettoispw.letmeknow.bean;


import progettoispw.letmeknow.controller.RecoverPswdController;

import static java.lang.Thread.sleep;

public class RecoverPswdBean {
    RecoverPswdController controller;
    public  RecoverPswdBean(){
        controller=new RecoverPswdController();
    }
    public boolean sendMail(String input){
        if(input.contains("@"))
        {
            return controller.sendMail(input);
        }
        return false;
    }
}
