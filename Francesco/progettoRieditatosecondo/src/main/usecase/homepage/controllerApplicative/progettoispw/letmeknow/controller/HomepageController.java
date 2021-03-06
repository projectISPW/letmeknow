//translated variables/classes

package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.controller.usruser.UsrUser;

public class HomepageController {
    UsrUser user;
    public HomepageController(boolean visit){
        if(!visit)user= ConcreteUsrUser.getUsrUser();
        else user= new UsrUser(ConcreteUsrUser.getSearch().getTouched());
    }
    public String getUserID(){
        return user.getUserid();
    }
    public int[] getParam(){
        int [] ret=new int[3];
        ret[0]=user.getEmp();
        ret[1]=user.getHum();
        ret[2]=user.getOpt();
        for(int i=0;i<3;i++)if(ret[i]>5 || ret[i]<1)ret[i]=1;
        return ret;
    }
    public String getDescription(){
        return user.getDescript();
    }
    public String getTag(){
        return user.getTag();
    }
    public String getGoal(){return user.getGoal();}
    public int[] getDate(){
        return user.getDate();
   }
   public boolean getExpired(){
        return user.getExpired();
   }
}
