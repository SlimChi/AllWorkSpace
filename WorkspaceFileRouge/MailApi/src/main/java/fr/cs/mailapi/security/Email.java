package fr.cs.mailapi.security;

import fr.cs.mailapi.metier.InfoEmail;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Date;
import java.util.Properties;


public class Email {

    public static boolean sendEmail(InfoEmail infoEmail){
        final String fromEmail = "CDA.RX@free.fr";
        final String password ="CDA@Afpa-Roubaix";


        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.free.fr"); //SMTP Host
        props.put("mail.smtp.socketFactory.port", "587"); //SSL Port
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
        props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
        props.put("mail.smtp.port", "587"); //SMTP Port

        Authenticator auth = new Authenticator()  {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };

        Session session = Session.getDefaultInstance(props, auth);


        try
        {
            MimeMessage msg = new MimeMessage(session);
            //set message headers
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            //msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");
            msg.setFrom(new InternetAddress("fsackebandt@free.fr", "NoReply"));
            msg.setReplyTo(InternetAddress.parse("fsackebandt@free.fr", false));
            msg.setSubject(infoEmail.getSubject(), "UTF-8");
            msg.setText(infoEmail.getBody(), "UTF-8");
            msg.setSentDate(new Date());
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(infoEmail.getDestinataire(), false));
            Transport.send(msg);

            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public static boolean verifMail(String destinataire) {
        return true;
    }
}
