package progettoispw.letmeknow.bean;

import progettoispw.letmeknow.controller.ISCController;
import progettoispw.letmeknow.controller.resultSearchController;

import java.util.Vector;

public class ISCBean {
    private int nval;
    private ISCController controller;
    public ISCBean (int val){
        nval=val;
        controller=new ISCController(nval);
    }
    public ISCBean (){
        nval=0;
        controller=new ISCController(nval);
    }
    int indice;
    private Vector<lastMessage> actual;
    public String getUserid(){
        return controller.getUid();
    }
    public String[] exitUid(){
        String [] arrStr=new String[nval];
        actual=controller.queryUsers();;
        for(lastMessage usr : actual){
            indice=actual.indexOf(usr);
            arrStr[indice]=usr.getUserid();
        }
        return arrStr;
    }
    public String[] exitMsg(){
        String [] arrStr=new String[nval];
        for(lastMessage usr : actual){
            indice=actual.indexOf(usr);
            arrStr[indice]=usr.getLastmsg();
        }
        return arrStr;
    }
    public void touched(String user){
        controller.who(user);
    }
    public void search(String find){
        if(find!="") {controller.search(find);}
    }
    public void reset(){
        controller.reset();
    }
}
