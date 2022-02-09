package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.WordCheck;
import progettoispw.letmeknow.controller.usruser.UsrUser;

public class rscUser implements innerUsers{
    private final String userid;
    private String description;
    private String goal;
    private int lenMax;
    private WordCheck check;
    public rscUser(UsrUser elem){
        lenMax=15;
        userid=elem.getUserid();
        description= elem.getDescript();
        goal=elem.getTag();
        check=new WordCheck();
    }
    @Override
    public String getUserid() {
        return userid;
    }
    public String getDescription() {
        return check.checkLen(description,lenMax);
    }
    public String getGoal() {
        return check.checkLen(goal,lenMax);
    }
    @Override
    public void setMaxVal(int maxVal) {
        lenMax=maxVal;
    }

}
