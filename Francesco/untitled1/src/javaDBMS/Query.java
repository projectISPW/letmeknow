package javaDBMS;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Query {
    protected ResultSet selectResult(Statement stmt, int month, int year )throws SQLException {
        String sql=String.format(" SELECT * FROM forms WHERE YEAR(`by`)=%d AND MONTH(`by`)=%d ",year,month);
        System.out.println(sql);
        return stmt.executeQuery(sql);
    }
    protected void suggestForm(Statement stmt,String from,String what) throws SQLException {
        String sql=String.format(" INSERT INTO suggest (`from`, `content`,`when`,`type`) VALUES ('%s', '%s',CURRENT_TIMESTAMP,'psy');",from,what);
        System.out.println(sql);
        stmt.executeUpdate(sql);

    }
}
