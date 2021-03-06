package progettoispw.letmeknow.controller.utenti;

import progettoispw.letmeknow.controller.ConnectionDBMS;
import progettoispw.letmeknow.controller.form.FormMeta;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements SalvaUtenteMeta, FormMeta {
    ConnectionDBMS connDB;
    Query query;
    public UserDAO() {
        connDB= new ConnectionDBMS();
        query=new Query();
    }
    public String [] selectUser(String uid){
        Statement stmt=null;
        ResultSet rst=null;
        String [] ret=new String [4];
        try {
            stmt=connDB.connection(stmt);
            rst=query.selectUser(stmt,uid);
            while(rst.next()) {
                ret[0]=rst.getString(UID);
                ret[1]=rst.getString(PASSWORD);
                ret[2]=rst.getString(TYPE);
                ret[3]=rst.getString(EMAIL);
            }
            return ret;
        } catch (SQLException e) {
            e.printStackTrace();
            return new String[4];
        }finally{
            connDB.closeRSTSTMT(rst,stmt);
        }
    }
    public boolean setPswd(String userid,String input){
        Statement stmt=null;
        try {
            stmt=connDB.connection(stmt);
            return query.setDB(stmt,userid,PASSWORD,input);
        }finally{
            connDB.closeSTMT(stmt);
        }

    }
    public boolean setEmail(String userid,String input){
        Statement stmt=null;
        try {
            stmt=connDB.connection(stmt);
            return query.setDB(stmt,userid,EMAIL,input);
        }finally{
            connDB.closeSTMT(stmt);
        }
    }
    public boolean checkMail(String input){
        Statement stmt=null;
        ResultSet rst=null;
        try {
            stmt=connDB.connection(stmt);
            rst= query.selectUser(stmt,EMAIL,input);
            return rst.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        } finally{
            connDB.closeRSTSTMT(rst,stmt);
        }
    }
    public boolean registration(String uid,String password, String type, String email) {
        Statement stmt=null;
        try {
            stmt=connDB.connection(stmt);
            query.newLine(stmt,uid,password,type,email);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally{
            connDB.closeRSTSTMT(null,stmt);
        }
    }
    public boolean registration(String uid,String password, String type ,int[] val,String description,String email,String goal ){
        Statement stmt=null;
        try {
            stmt=connDB.connection(stmt);
            query.newLine(stmt,uid,password,type,val,description,email,goal);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        } finally{
            connDB.closeSTMT(stmt);
        }
    }
    public boolean feed(String userid,String input){
            Statement stmt=null;
            try {
                stmt=connDB.connection(stmt);
                return query.feed(stmt,userid,input);
            } finally{
                connDB.closeSTMT(stmt);
            }

        }
    public List<String> getUID() {
        Statement stmt=null;
        ResultSet rst=null;
        try {
            stmt=connDB.connection(stmt);
            ArrayList<String> uid = new ArrayList<>();
            rst = query.queryUid(stmt);
            while (rst.next()) {
                uid.add(rst.getString(UID));
            }
            return uid;
        } catch (SQLException e) {
            System.err.println("errore nella richiesta degli userid");
            return new ArrayList<>();
        }finally{
            connDB.closeRSTSTMT(rst,stmt);
        }
    }
    public String[] recover (String email){
        Statement stmt=null;
        ResultSet rst=null;
        String [] ret=new String[2];
        try{
            stmt=connDB.connection(stmt);
            rst=query.selectUser(stmt,EMAIL,email);
            while(rst.next()){
                ret [0]=rst.getString(UID);
                ret [1]=rst.getString(PASSWORD);
                break;
            }
            return ret;
        } catch (Exception throwables) {
            return new String[2];
        }finally{
            connDB.closeSTMT(stmt);
        }
    }

}
