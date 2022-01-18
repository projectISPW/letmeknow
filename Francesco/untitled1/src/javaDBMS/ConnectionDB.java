package javaDBMS;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDB {
    private static String  User = "uf56pst70onxcz68";
    private static String Pass = "N5bkvOZY2AhFpYZYu3w7";
    private static String DB_URL = "jdbc:mysql://uf56pst70onxcz68:N5bkvOZY2AhFpYZYu3w7@b16kdsy1yce6nyrrldqg-mysql.services.clever-cloud.com:3306/b16kdsy1yce6nyrrldqg";
    private static String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    private static Statement stmt = null;
    private static java.sql.Connection conn = null;
    private static Statement connection(){
        try {
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
        if (stmt==null){
            System.out.println("i am here");
            stmt = connection();
        }
        return stmt;
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
            if(stmt!=null)stmt.close();
            if(conn!=null)conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //"GESTIONE CONNESSIONE FALLITA "
        }
    }
}