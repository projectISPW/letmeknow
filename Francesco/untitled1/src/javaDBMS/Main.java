package javaDBMS;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void test(ResultSet rst) throws SQLException {
        int indice=1;
        while(rst.next()){
            System.out.println(rst.getString(indice++));
        }
    }
    public static void main(String []args) throws SQLException {
        Sql data=new Sql();
        test(data.selectResult(1,2022));

    }
}
