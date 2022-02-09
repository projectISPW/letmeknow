package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.controller.chat.Messages;
import progettoispw.letmeknow.controller.form.ResultForm;
import progettoispw.letmeknow.controller.search.Search;
import progettoispw.letmeknow.controller.usruser.UsrUser;

public class ConcreteUsrUser {
    static UsrUser user;
    static Search search;
    static Messages  chat;
    static ResultForm form;
    private ConcreteUsrUser(){
        reset();
    }
    private static void reset() {
        user=null;
        search = null;
        chat = null;
        form = null;
    }
    public static boolean checkCredentials(String userid,String password){
        reset();
        boolean bool;
        user=new UsrUser(userid);
        bool=user.confirmCredentials(password);
        if(bool)bool=user.getType().equals("usr");
        else{reset();}
        return bool;
    }
    public static void setAll(String userid){
        reset();
        user = new UsrUser(userid);
        search=new Search(userid);
        chat=new Messages(userid);
    }
    public static UsrUser getUser(){ return user;}
    public static Search getSearch(){
        return search;
    }
    public static Messages getChat(){
        return chat;
    }
    public static void setResultForm(){
        form=new ResultForm(user.getUserid());
    }
    public static void setResultForm(int formid){
        form=new ResultForm(user.getUserid(),formid);
    }
    public static ResultForm getResultForm(){
        return form;
    }
}
