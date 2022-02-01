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
    int indice;
    private Vector<lastMessage> actual;
    public String[] exitUid(){
        String [] arrStr=new String[nval];
        actual=controller.queryUsers();;
        for(lastMessage usr : actual){
            indice=actual.indexOf(usr);
            arrStr[indice]=usr.getUserid();
            //System.out.println("About me: in bean " +arrStr[indice]);
        }
        return arrStr;
    }
    private String[] exitMsg(){
        String [] arrStr=new String[nval];
        for(lastMessage usr : actual){
            indice=actual.indexOf(usr);
            arrStr[indice]=usr.getUserid();
            //System.out.println("About me: in bean " +arrStr[indice]);
        }
        return arrStr;
    }
    public void touched(String user){
        controller.who(user);
    }
}
