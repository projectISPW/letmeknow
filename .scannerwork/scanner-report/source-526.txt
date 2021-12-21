package progettoispw.letmeknow.controller.utenti;
import java.sql.*;

import static progettoispw.letmeknow.controller.utenti.Query.*;

public class UtenteSQL extends Query {
    private String User = "root";
    private String Pass = "password";
    private String DB_URL = "jdbc:mysql://127.0.0.1:3306/users";
    private String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    private Statement stmt = null;

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

    public ResultSet getUserData(String userid) throws SQLException {
        return selectUser(stmt, userid);
    }

    public void setDescription( String userid, String descr) throws SQLException {
        setDescriptionQuery(stmt,userid,"description",descr);
        return;
    }
    public void setGoal( String userid, String goal) throws SQLException {
        setDescriptionQuery(stmt,userid,"goal",goal);
        return;
    }
    public void setTag( String userid, String tag) throws SQLException {
        setDescriptionQuery(stmt,userid,"tag",tag);
        return;
    }
    public void setData( String userid, String data) throws SQLException {
        setDataQuery(stmt,userid,data);
        return;
    }

}
