package progettoispw.letmeknow.controller.form;

import progettoispw.letmeknow.controller.ConnectionDB;
import progettoispw.letmeknow.controller.chat.Message;

import java.sql.*;
import java.util.Vector;

public class FormSQL extends Query{
    private ConnectionDB conn=new ConnectionDB() ;
    private Statement stmt=conn.getStatement();
    private ResultSet rst;
    public int [] queryResult (String userid, int formid){
        ResultSet rst=queryResults(stmt, userid, formid);
        try {
            int [] array=new int[6];
            int indice=0;
            while (rst.next()) {
                for(int i=0;i<6;i++){
                    array[i]=Integer.parseInt(rst.getString(i+3));
                }
            }
            rst.close();
            return array;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
    public Boolean setAnswer(String userid,int formid,int [] answer){
        return(setResults(stmt,userid,formid,answer));
      }
    }
