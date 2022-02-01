package progettoispw.letmeknow.controller;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class ConnectionDB {
    private static final String FILENAME= "progettoispw/letmeknow/connection/ConnectionParameters.xml";
    private static String User;
    private static String Pass;
    private static String DB_URL;
    private static String DRIVER_CLASS_NAME;
    private static java.sql.Connection conn = null;
    private static Statement stmt1;
    private static Statement connection(){
        try {
            Statement stmt;
            System.out.println("creata connessione");
            Class.forName(DRIVER_CLASS_NAME);//recupera dinamicamente il driver , prende la classe dal class path
            conn = DriverManager.getConnection(DB_URL, User, Pass);//quando ho get connection ho il driver caricato
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            return stmt;
        } catch (Exception throwables) {
            throwables.printStackTrace();
            closeConnection();
            return null;
        }
    }
    public static Statement getStatement() {
        if (stmt1==null){
            System.out.println("i am here");

            stmt1 = connection();
        }
        return stmt1;
    }
    public static void closeRST(ResultSet rst) {
        if(rst!=null){
            try {
                rst.close();
            } catch (SQLException e) {
                e.printStackTrace();
                closeConnection();
            }
            closeConnection();
        }
    }





    public static void closeConnection() {
        try {
            if(stmt1!=null)stmt1.close();
            if(conn!=null)conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //"GESTIONE CONNESSIONE FALLITA "
        }
    }
}
