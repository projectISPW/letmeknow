package progettoispw.letmeknow.controller.search;
import java.sql.*;

import static progettoispw.letmeknow.controller.search.Query.*;
import static progettoispw.letmeknow.controller.utenti.Query.*;

public class SearchSQL extends Query {
    private String User = "root";
    private String Pass = "password";
    private String DB_URL = "jdbc:mysql://127.0.0.1:3306/users";
    private String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    private Statement stmt = null;

    public SearchSQL() throws ClassNotFoundException {
        Connection conn = null;
        try {
            Class.forName(DRIVER_CLASS_NAME);//recupera dinamicamente il driver , prende la classe dal class path
            conn = DriverManager.getConnection(DB_URL, User, Pass);//quando ho get connection ho il driver caricato
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public ResultSet getUserData1(String userid) throws SQLException {
        return selectUser(stmt,userid);
    }
    public ResultSet search4All(String userid,int emp, int hum,int pos){
        return searchAll(stmt,emp, hum,pos,userid);
    }
    public ResultSet searchGoal(String userid, String goal) {
        return searchDataQuery(stmt,userid,"tag",goal);
    }

    public ResultSet searchDescr(String userid, String descr) {
        return searchDataQuery(stmt,userid,"description",descr);
    }
}
