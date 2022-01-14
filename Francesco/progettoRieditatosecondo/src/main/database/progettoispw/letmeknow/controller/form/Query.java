package progettoispw.letmeknow.controller.form;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Query {
    private String sql;
    public ResultSet queryResults(Statement stmt, String userid ,int formid) {
        ResultSet rst=null;
        try{
        sql=String.format(" SELECT * \n FROM forms where userid = '%s' and formid='%d'",userid,formid);
        rst=stmt.executeQuery(sql);
        if(!stmt.executeQuery(sql).next()){
            System.out.println("first time");
            rst.close();
            sql=String.format("INSERT INTO `users`.`forms` (`formid`, `userid`, `q1`, `q2`, `q3`, `q4`, `q5`, `q6`) VALUES ('%d', '%s', '-1', '-1', '-1', '-1', '-1', '-1');",formid,userid);
            stmt.executeUpdate(sql);
            sql=String.format(" SELECT * \n FROM forms where userid = '%s' and formid='%d' ",userid,formid);
            return stmt.executeQuery(sql);
        }
        else {
            return stmt.executeQuery(sql);
        }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

    }
    public Boolean setResults(Statement stmt,String userid,int formid,int [] answer){
        try {
            sql = String.format(" UPDATE `users`.`forms` " +
                            "SET `q1` = '%d', `q2` = '%d', `q3` = '%d', `q4` = '%d', `q5` = '%d', `q6` = '%d' WHERE (`formid` = '%d') and (`userid` = '%s');",
                    answer[0], answer[1], answer[2], answer[3], answer[4], answer[5], formid, userid);
            stmt.executeUpdate(sql);
            return true;
        } catch (SQLException throwables) {
            return false;
        }
    }
    public ResultSet takeParam(Statement stmt,String userid){
        try {
            String sql=String.format("SELECT empathy,humor,positivity FROM users.utenti where userid='%s';",userid);
            return stmt.executeQuery(sql);
        } catch (SQLException throwables) {
            return null;
        }
    }
    public ResultSet takeDate(Statement stmt,String userid,int formid){
        try {
            String sql=String.format("SELECT `by` FROM forms where userid='%s'AND formid=%d;",userid,formid);
            System.out.println(sql);
            return stmt.executeQuery(sql);
        } catch (SQLException throwables) {
            return null;
        }
    }
    public Boolean close(Statement stmt,String userid,int formid,int[] param){
        try {
            for(int i=0;i<param.length;i++)System.out.println(param[i]);
            String sql=String.format(" UPDATE  forms \n set `emp` = %d, `hum` = %d, `pos` = %d,`by`=CURRENT_TIMESTAMP \n WHERE (`formid` = %d) and (`userid` = '%s');\n",
                                                                        param[0],param[1],param[2],2,"0000000");
            stmt.executeUpdate(sql);
            return true;
        } catch (SQLException throwables) {
            return false;
        }
    }

}
