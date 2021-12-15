package progettoispw.letmeknow.controller.utenti;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SalvaUtente extends SalvaUtenteMeta{
    private String userid;
    private String password;
    private String type;
    private UtenteSQL userData;
    private ResultSet rst;

    public SalvaUtente(String who)  {
        try {
            userData = new UtenteSQL();
            rst = userData.getUserData(who);
            while(rst.next()){
                userid = rst.getString(USERID);
                password=rst.getString(PASSWORD);
                type=rst.getString(TYPE);
            }
        } catch (SQLException throwables) {
            //throwables.printStackTrace();
            System.out.println("exeption occurred 1");
        }catch (ClassNotFoundException e) {
            //e.printStackTrace();
            System.out.println("exeption occurred 2");
        }
    }
    public boolean checkUtente (String pswdInput){
        return password.equals(pswdInput);
    }
    public void abscessType (String pswdInput) {
        if (checkUtente(pswdInput)) {
           if(type.equals("usr")) dataHomeUsr();
        }
    }
    private int pos;
    private int hum;
    private int emp;
    private String personalDescrip;
    private String obbPersonale;
    private String tag;
    private String data;
    static Goal personalObb=new Goal();
    public void  dataHomeUsr () {
        try{
            rst = userData.getUserData(userid);
            while(rst.next()){
                pos = Integer.parseInt(rst.getString(POS));
                hum = Integer.parseInt(rst.getString(HUM));
                emp= Integer.parseInt(rst.getString(EMP));
                tag=rst.getString(TAG);
                data=rst.getString(END);
                obbPersonale=rst.getString(GOAL);
                personalObb.setObiettivo(obbPersonale);
                personalObb.setTag(tag);
                personalObb.setData(data);
                personalDescrip =rst.getString(DES);
                return ;
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            return ;
        }
    }
    public int getEmp(){
        return emp;
    }
    public int getHum(){
        return hum;
    }
    public int getPos(){
        return pos;
    }
    public String getDescrizione(){
        return personalDescrip;
    }
    public String getTag(){return personalObb.getTag();}
    public String getObiettivo(){ return personalObb.getObiettivo();}
    public Integer[] getData(){return personalObb.getData();}
    public void setPersonalDes(String newS)  {
       try{userData.setDescription(userid,newS);}
       catch (SQLException throwables) {
           throwables.printStackTrace();
       }
    }
    public void setPersonalGoal(String newS)  {
        try{
            personalObb.setObiettivo(newS);
            userData.setGoal(userid,newS);
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void setPersonalTag(String newS)  {
        try{
            personalObb.setTag(newS);
            userData.setTag(userid,newS);
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void setPersonalData(Integer [] value)  {
        try{
            String convert=""+value[2]+"-"+value[1]+"-"+value[0];
            personalObb.setData(convert);
            userData.setData(userid,convert);}
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
