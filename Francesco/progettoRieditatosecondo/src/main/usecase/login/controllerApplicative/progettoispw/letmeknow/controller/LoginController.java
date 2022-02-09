package progettoispw.letmeknow.controller;

public class LoginController {
    public boolean getLog(String userid, String password){
        return Factory.tryLog(userid,password);
    }
    public String getType(){
        return Factory.getUser().getType();
    }
}
