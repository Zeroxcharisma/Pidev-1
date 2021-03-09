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
public class SmsSender {
     /**
     * @param args the command line arguments
     */
   // Find your Account Sid and Auth Token at twilio.com/console
    public static final String ACCOUNT_SID =
            "AC66c2d2e2b95a443858d0b2b3d883bb56";
    public static final String AUTH_TOKEN =
            "2594b7f5561314c30f7e5e6daa8134d8";


    public void send(String s,String x){
         Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
      
        Message message = Message 
                .creator(new PhoneNumber("+21653419827"), // to
                        new PhoneNumber("+16014291961"), // from
                       ""+s)
                .create();
  System.out.println("aaslema");
        System.out.println(message.getSid());
    
}
}
