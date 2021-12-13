package progettoispw.letmeknow.controller.utenti;

import java.io.Serializable;
import java.util.List;

public class utenteSerialized implements Serializable {
    static salvaUtente [] statArray=null;
    private final Object MUTEX =new Object();
    static int i=0;
    private List <salvaUtente> saveList;
    static boolean alive=false;
    public void attachArr(salvaUtente user){
        statArray[i]=user;
    }
    int indice=-1;
    boolean presente=true;
    public utenteSerialized(){
        alive=true;
         /*while(alive){
           for(int i=0;i< statArray.length;i++){
                indice=saveList.indexOf(statArray[i]);
                if(i>0){
                    for(salvaUtente user : saveList){
                        if(statArray[i]==user){
                            presente=true;
                        }
                    }
                    if(presente==false){
                        saveList.attach(statArray[i]);
                    }
                }

            }*/

    }
}
