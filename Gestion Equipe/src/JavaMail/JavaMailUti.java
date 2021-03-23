/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaMail;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Tarek
 */
public class JavaMailUti {
    public static void sendMail(String recepient) {
    System.out.println("Preparation de l'envoi du mail");
    Properties properties = new Properties();
    
    properties.put("mail.smtp.auth", "true");
    properties.put("mail.smtp.starttls.enable", "true");
    properties.put("mail.smtp.host", "smtp.gmail.com");
    properties.put("mail.smtp.port", "587");
    
    String myAccountEmail = "contact.footunisie@gmail.com";
    String password = "FOOTUNISIE123";
    
    Session session = Session.getInstance(properties, new Authenticator(){
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(myAccountEmail,password);
        }
        
    });
    
    Message message = prepareMessage(session,myAccountEmail,recepient); 
    
    Transport.send(message);
    System.out.println("Mail envoyé avec succes");
    }   

    private static Message prepareMessage(Session session, String myAccountEmail, String recepient) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(recepient));
            message.setSubject("Votre équipe a été crée avec succés");
//            String htmlCode = "<h1>";
//            message.setContent("","text/html");
//            message.setText("Bonjour, \nVotre équipe a été crée avec succés. \nMerci d'avoir utiliser FOOTUNISIE ");
            return message;
        } catch (Exception ex) {
            Logger.getLogger(JavaMailUti.class.getName()).log(Level.SEVERE, null, ex);
        }
       return null;
    }
}
