package progettoispw.letmeknow.controller.utenti;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Query {
    public static ResultSet selectUser(Statement stmt, String iduser )throws SQLException {
        /*String sql= "SELECT *\n" +
                "FROM utenti\n" +
                "where userid='" + iduser+"';";*/
        String sql=String.format(" SELECT *\n FROM utenti \n where userid = '%s' ;\n",iduser);
        System.out.println(sql);
        return stmt.executeQuery(sql);
    }
    public static void setDescriptionQuery(Statement stmt, String iduser ,String what,String edit)throws SQLException {
        String sql=String.format(" UPDATE  utenti\n set %s='%s'\n WHERE userid = '%s' ;\n",what,edit,iduser);
        System.out.println(sql);
        stmt.executeUpdate(sql);
       return ;
    }
    public static int inserisciAlbum(Statement stmt, String iduser, String password ,String email) throws SQLException  {
        String insertStatement = String.format("INSERT INTO utenti (AlbumId, Titolo, Artista, Anno) VALUES (%s,'%s','%s',%s)");
        System.out.println(insertStatement);
        return stmt.executeUpdate(insertStatement);
    }
}
