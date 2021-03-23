/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.tests;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

/**
 *
 * @author ASUS
 */
public class MailSender_1 {
    	/**
	   Outgoing Mail (SMTP) Server
	   requires TLS or SSL: smtp.gmail.com (use authentication)
	   Use Authentication: Yes
	   Port for TLS/STARTTLS: 587
     * @param args
	 */
	public  void main(String[] args, String a) {
		final String fromEmail = "nidhal.yahmadi@esprit.tn"; //requires valid gmail id
		final String password = "Club1920"; // correct password for gmail id
		final String toEmail = "taher.zribi@esprit.tn"; // can be any email id 
		
		System.out.println("TLSEmail Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
		props.put("mail.smtp.port", "587"); //TLS Port
		props.put("mail.smtp.auth", "true"); //enable authentication
		props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
		
                //create Authenticator object to pass in Session.getInstance argument
		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		Session session = Session.getInstance(props, auth);
		String Newligne=System.getProperty("line.separator");
		EmailUtil_1.sendEmail(session, toEmail,"Resultats ajoutés", "les resultats du tournoi  "
                        +a+" sont ajouter."+Newligne+Newligne+"Cordialement."
                        +Newligne+Newligne+Newligne+"Service gestion des resultats FootTunisie.");
		
	}
    
}
