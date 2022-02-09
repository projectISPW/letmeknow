package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.controller.psyuser.PsyUser;

public class ConcretePsyUser {
    static PsyUser user;
    private ConcretePsyUser(){
        user=null;
    }
    public static boolean checkCredentials(String userid,String password){
        boolean bool;
        user=new PsyUser(userid);
        bool=user.confirmCredentials(password);
        if(bool)bool=user.getType().equals("psy");
        if(!bool)user=null;
        return bool;
    }
    public static void setAll(String userid){
        user=new PsyUser(userid);
    }
    public static PsyUser getUser(){ return user;}
}
