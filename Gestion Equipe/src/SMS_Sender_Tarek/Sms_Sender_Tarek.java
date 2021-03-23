/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SMS_Sender_Tarek;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

/**
 *
 * @author Tarek
 */
public class Sms_Sender_Tarek {
    // Find your Account Sid and Auth Token at twilio.com/console
    public static final String ACCOUNT_SID =
            "ACb51e15a2d0e472099a2c58dbfef7eda9";
    public static final String AUTH_TOKEN =
            "fcfe30d8547c6b2b43abc44537916979";

    public static void main(String[] tarek) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message
                .creator(new PhoneNumber("+21699179378"), // to
                        new PhoneNumber("+12036333947"), // from
                        "Votre équipe a été ajouté. \nMerci d'avoir utilisé FOOTUNISIE ")
                .create();

        System.out.println(message.getSid());
    }
}