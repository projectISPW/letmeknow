package progettoispw.letmeknow.controller.chat;

import java.sql.*;

public class MessagesSQL extends Query{
    private String User = "root";
    private String Pass = "password";
    private String DB_URL = "jdbc:mysql://127.0.0.1:3306/users";
    private String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    private Statement stmt = null;
    public MessagesSQL() throws ClassNotFoundException {
        Connection conn = null;
        try {
            Class.forName(DRIVER_CLASS_NAME);//recupera dinamicamente il driver , prende la classe dal class path
            conn = DriverManager.getConnection(DB_URL, User, Pass);//quando ho get connection ho il driver caricato
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public ResultSet getRecived(String userid) throws SQLException {
        return selectUser(stmt,userid,"reciver");
    }
    public ResultSet getSended(String userid) throws SQLException {
        return selectUser(stmt,userid,"sender");
    }
    public ResultSet getSR(String userid) throws SQLException {
        return selectUserRSALL(stmt,userid);
    }
    public ResultSet getSRchat(String user1,String user2) throws SQLException {
        return selectUserRS(stmt,user1,user2);
    }
    public void newMessage(String from,String to,String text ) throws SQLException {
        newMSG(stmt,from,to,text);
    }
}
