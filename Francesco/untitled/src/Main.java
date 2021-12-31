import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {
        JavaMailUtil mail =new JavaMailUtil();
        mail.sendMail("progettoispw2021@gmail.com");
    }
}
