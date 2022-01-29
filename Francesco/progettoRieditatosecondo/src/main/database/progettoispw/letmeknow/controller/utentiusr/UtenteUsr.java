package progettoispw.letmeknow.controller.utentiusr;

import progettoispw.letmeknow.controller.utenti.SalvaUtente;

public class UtenteUsr extends SalvaUtente {
    UserDAO userDataUSR;
    private String des;
    private String goal;
    private String tag;
    private String data;
    private Goal personalObb;
    private ParameterSliders parameterSliders;
    public UtenteUsr(String who) {
        super(who);
        userDataUSR =new UserDAO();
        personalObb=new Goal();
        parameterSliders=new ParameterSliders();
        dataHomeUsr();
        queryResult();
    }
    public void  dataHomeUsr () {
        if(userid!=null){
            String [] inner= userDataUSR.selectUser(userid);
                parameterSliders.setEmp(inner[0]);
                parameterSliders.setHum(inner[1]);
                parameterSliders.setOpt(inner[2]);
                des = inner[3];
                personalObb.setObiettivo(inner[4]);
                personalObb.setTag(inner[5]);
                personalObb.setStrDataAmericanEurope(inner[6]);
        }
    }

    public int getEmp(){
        return parameterSliders.getEmp();
    }
    public int getHum(){
        return parameterSliders.getHum();
    }
    public int getOpt(){
        return parameterSliders.getOpt();
    }
    public String getDescript(){
        return des;
    }
    public String getTag(){
        return personalObb.getTag();
    }
    public String getGoal(){
        return personalObb.getObiettivo();
    }
    public Integer[] getDate(){
        return personalObb.getDataEuropean();
    }
    public boolean setPersonalDes(String newS)  {
        des =newS;
        return userDataUSR.setDescription(userid,newS);
    }
    public boolean setPersonalGoal(String newS)  {
        personalObb.setObiettivo(newS);
        return userDataUSR.setGoal(userid,newS);
    }
    public boolean setPersonalTag(String newS)  {
        personalObb.setTag(newS);
        return userDataUSR.setTag(userid,newS);
    }
    public boolean setPersonalData(String newData)  {
        personalObb.setStrDataEurope(newData);
        return userDataUSR.setData(userid,personalObb.getAmericanDataStr());
    }
    public void setParams(){
        queryResult();
        dataHomeUsr();
    }
    public boolean getExpired(){
        return personalObb.getExpired();
    }
    public boolean queryResult() {
        return userDataUSR.getResult(userid,parameterSliders.getAll());
    }
}