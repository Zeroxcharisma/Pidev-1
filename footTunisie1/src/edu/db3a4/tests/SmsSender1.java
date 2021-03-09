/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.tests;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

/**
 *
 * @author ASUS
 */
public class SmsSender1 {
    /**
     * @param args the command line arguments
     */
   // Find your Account Sid and Auth Token at twilio.com/console

    public static final String ACCOUNT_SID =
            "AC3fafe62966e89704047887747bc8c83b";
    public static final String AUTH_TOKEN =
            "af050f79629dfd5e45310b4600f9840f";


    public void send(String s,String x){
         Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
      
        Message message = Message 
                .creator(new PhoneNumber("+21698511511"), // to
                        new PhoneNumber("+13392178599"), // from
                       ""+s)
                .create();
  System.out.println("aaslema");
        System.out.println(message.getSid());
    
}
}