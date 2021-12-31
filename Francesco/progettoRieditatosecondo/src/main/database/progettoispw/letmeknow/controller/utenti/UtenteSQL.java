package progettoispw.letmeknow.controller.utenti;
import java.sql.*;
import java.util.Vector;

import static progettoispw.letmeknow.controller.utenti.Query.*;

public class UtenteSQL extends Query implements SalvaUtenteMeta {
    private String User = "root";
    private String Pass = "password";
    private String DB_URL = "jdbc:mysql://127.0.0.1:3306/users";
    private String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    private Statement stmt = null;
    private ResultSet rst;
    public UtenteSQL() throws ClassNotFoundException {
        Connection conn = null;

        try {
            Class.forName(DRIVER_CLASS_NAME);//recupera dinamicamente il driver , prende la classe dal class path
            conn = DriverManager.getConnection(DB_URL, User, Pass);//quando ho get connection ho il driver caricato
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ResultSet getUserData(String userid)  {
        try {
            return selectUser(stmt, userid);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setDescription( String userid, String descr){
        try {
            setDescriptionQuery(stmt,userid,"description",descr);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return;
    }
    public void setGoal( String userid, String goal) {
        try {
            setDescriptionQuery(stmt,userid,"goal",goal);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return;
    }
    public void setTag( String userid, String tag){
        try {
            setDescriptionQuery(stmt,userid,"tag",tag);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return;
    }
    public void setData( String userid, String data) {
        try {
            setDataQuery(stmt,userid,data);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return;
    }
    public void setPswd( String userid, String input)  {
        try {
            setDataQuery(stmt,userid,input);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return;
    }
    public void setEmail( String userid, String input){
        try {
            setDescriptionQuery(stmt,userid,"email",input);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return;
    }
    public String[] recover (String email){
        String [] returnStr=new String[2];
        try{
            rst=selectUser(stmt,"email",email);
            while(rst.next()){
                returnStr [0]=rst.getString(USERID);
                returnStr[1]=rst.getString(PASSWORD);
            }

            return returnStr;
        } catch (Exception throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
    public Vector<String> getUID() {
        try {
            Vector<String> uid = new Vector<>();
            rst = queryUid(stmt);
            while (rst.next()) {
                uid.add(rst.getString(USERID));
            }
            return uid;
        } catch (SQLException e) {
            System.err.println("errore nella richiesta degli userid");
            return null;
        }
    }
    public boolean checkEmail(String input){
        try {
            rst= selectUser(stmt,"email",input);
            while (rst.next()) {
                System.out.println(rst.getString(1));
               return true;
            }
            return false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }
    public boolean registration(String uid,String password, String type ,int[] val,String description,String email,String goal ){
        try {
            newLine(stmt,uid,password,type,val,description,email,goal);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }
}
