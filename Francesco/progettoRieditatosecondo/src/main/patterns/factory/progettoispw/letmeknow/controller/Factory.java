package progettoispw.letmeknow.controller;

public class Factory {
    private static User user;
    private Factory(){
        user=null;
    }
    public static boolean tryLog(String userid, String password){
        boolean bool=true;
        if (ConcreteUsrUser.checkCredentials(userid,password)){
            ConcreteUsrUser.setAll(userid);
            user=ConcreteUsrUser.getUser();
        }
        else if(ConcretePsyUser.checkCredentials(userid,password)){
            ConcretePsyUser.setAll(userid);
            user=ConcreteUsrUser.getUser();
        }
        return bool;
    }
    public static User getUser(){
        return user;
    }
}
