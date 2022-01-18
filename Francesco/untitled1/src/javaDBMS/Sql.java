package javaDBMS;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Sql extends Query {
    public ResultSet selectResult(int month, int year){
        try {
            Statement stmt=ConnectionDB.getStatement();
            return selectResult(stmt,month,year);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public void  suggestForm(String from,String what){
        try{
            Statement stmt=ConnectionDB.getStatement();
            suggestForm(stmt,from,what);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            ConnectionDB.closeConnection();
        }
    }
}