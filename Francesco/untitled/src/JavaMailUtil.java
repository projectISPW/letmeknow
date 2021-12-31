
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailUtil {
    public void sendMail(String recipient){
        try {
            System.out.println("Sending message");
            Properties properties=new Properties();
            //configurazione server
            properties.put("mail.smtp.host","smtp.gmail.com");
            properties.put("mail.smtp.port", "465");
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.auth", "true");
            //configurazione log
            String myAccount="progettoispw2021@gmail.com";
            String password="Password2021";
            Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

                protected PasswordAuthentication getPasswordAuthentication() {

                    return new PasswordAuthentication(myAccount, password);

                }

            });
            session.setDebug(true);
            Message message = prepareMessage(session,myAccount,recipient);
            Transport .send(message);
            System.out.println("MESSAGE CORRECTLY SENDED");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    public Message prepareMessage (Session session,String myAccountEmail, String reciver){
        try {
            Message message =new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(reciver));
            message.setSubject("recover password");
            message.setText("Your password is .:\n Password");
            return message;
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return null;
    }
}