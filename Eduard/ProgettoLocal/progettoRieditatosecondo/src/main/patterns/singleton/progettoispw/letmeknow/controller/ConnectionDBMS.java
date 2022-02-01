package progettoispw.letmeknow.controller;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class ConnectionDBMS {
    private static String  user ;
    private static String password;
    private static String dburl ;
    private static String driverclassname ;
    private static java.sql.Connection conn;
    private static int numConnection;
    public ConnectionDBMS(){

        if(conn==null){
            ConnectionInfo connectionInfo = new ConnectionInfo("src/main/resources/progettoispw/letmeknow/connection/ConnectionParameters.xml");

            Map<String, String> parameters = connectionInfo.getConnectionInfo();
            user=parameters.get("username");
            password=parameters.get("password");
            dburl=parameters.get("url");
            driverclassname=parameters.get("driverName");
            conn=getConn();
        }
    }
    private static java.sql.Connection getConn(){
        try {
            Class.forName(driverclassname);//recupera dinamicamente il driver , prende la classe dal class path
            return conn = DriverManager.getConnection(dburl, user ,password);//quando ho get connection ho il driver caricato
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public Statement connection(Statement stmt){
        if(numConnection<1) {
            try {
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                increm();
                return stmt;
            } catch (Exception throwables) {
                closeSTMT(stmt);
                return null;
            }
        }
        return null;
    }
    private static void decrem(){
        numConnection--;
    }
    private static void increm(){
        numConnection++;
    }
    public void closeSTMT(Statement stmt) {
        try {
            if(stmt!=null)stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            decrem();
            //"GESTIONE CONNESSIONE FALLITA "
        }
    }
    public void closeRSTSTMT(ResultSet rst, Statement stmt) {
        try {
            if(rst!=null)rst.close();
            closeSTMT(stmt);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            decrem();
            //"GESTIONE CONNESSIONE FALLITA "
        }
    }
    public void closeCONN(){
        try {
            if(conn!=null)conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            decrem();
            //"GESTIONE CONNESSIONE FALLITA "
        }
    }
}
