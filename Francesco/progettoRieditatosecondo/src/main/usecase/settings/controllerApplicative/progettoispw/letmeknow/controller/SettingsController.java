package progettoispw.letmeknow.controller;


import progettoispw.letmeknow.controller.user.InitialUser;

public class SettingsController {
    InitialUser user;
    public SettingsController(){
        user=new InitialUser(Factory.getUser().getUserid());
    }
    public void closeConnection(){
        ConnectionDBMS.closeConn();
    }
    public boolean setPassword(String input){
       return user.setPassword(input);
    }
    public boolean setEmail(String input){
        return user.setEmail(input);
    }
    public boolean feed(String input){
       return user.setFeed(input);
    }
}
