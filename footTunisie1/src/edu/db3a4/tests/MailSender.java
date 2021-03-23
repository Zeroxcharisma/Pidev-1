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
public class MailSender {
    	/**
	   Outgoing Mail (SMTP) Server
	   requires TLS or SSL: smtp.gmail.com (use authentication)
	   Use Authentication: Yes
	   Port for TLS/STARTTLS: 587
     * @param args
	 */
	public  void main(String[] args, String a) {
		final String fromEmail = "taher.zribi@esprit.tn"; //requires valid gmail id
		final String password = "181JMT1090"; // correct password for gmail id
		final String toEmail = "nidhal.yahmadi@esprit.tn"; // can be any email id 
		
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
		EmailUtil.sendEmail(session, toEmail,"Ajouter Resultats", "Veuiller ajouter les resultats du tournoi "
                        +a+" dans les plus brefs delais."+Newligne+Newligne+"Cordialement."
                        +Newligne+Newligne+Newligne+"Service gestion des tournois FootTunisie.");
		
	}
    
}
