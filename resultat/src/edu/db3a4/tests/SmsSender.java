/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.tests;

/**
 *
 * @author nidha
 */
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
public class SmsSender {

    /**
     * @param args the command line arguments
     */
   // Find your Account Sid and Auth Token at twilio.com/console
    public static final String ACCOUNT_SID =
            "AC8863452bdbbdc163d6bde78cd1266dc3";
    public static final String AUTH_TOKEN =
            "58872fbad2565fefc6645f4904c6802a";


    public void send(String s,String x){
         Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
      
        Message message = Message 
                .creator(new PhoneNumber("+21652315021"), // to
                        new PhoneNumber("+17206500497"), // from
                       ""+s)
                .create();
  System.out.println("wiouwwww");
        System.out.println(message.getSid());
    
}
}
