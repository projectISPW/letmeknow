package progettoispw.controller;

import progettoispw.letmeknow.controller.chat.Messages;
import progettoispw.letmeknow.controller.form.ResultForm;
import progettoispw.letmeknow.controller.search.Search;
import progettoispw.letmeknow.controller.user.InitialUser;
import progettoispw.letmeknow.controller.psyuser.PsyUser;
import progettoispw.letmeknow.controller.usruser.UsrUser;

public class ClassController {
    static User user;
    static Search search;
    static Messages  chat;
    static ResultForm form;
    private static void reset() {
        user=null;
        search = null;
        chat = null;
        form = null;
    }
    private static void concreteUsrUser(){
        String userid=user.getUserid();
        search=new Search(userid);
        chat=new Messages(userid);
    }
    public static boolean concreteUser(String userid, String password){
        user = new InitialUser(userid);
        boolean bool=true;
        if (user.confirmCredentials(password)){
            switch(user.getType()){
                case "usr":{
                    user=new UsrUser(userid);
                    concreteUsrUser();
                    break;
                }
                case "psy":user=new PsyUser(userid);break;
                default:
                    bool=false;
                    reset();
            }
        }
        return bool;
    }
    public static User getUser(){return user;}
    public static UsrUser getUserUSR(){
        return (UsrUser) user;
    }
    public static PsyUser getUserPsy(){return (PsyUser) user;}
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
