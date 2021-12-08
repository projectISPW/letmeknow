import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String [] args) throws ParseException {
        Date data;
        String StringDate="2020/11/10";
        SimpleDateFormat dateParser=new SimpleDateFormat ("yyyy/MM/dd");
        System.err.println(dateParser.parse(StringDate));
    }
}
