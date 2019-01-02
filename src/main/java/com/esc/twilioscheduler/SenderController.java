package com.esc.twilioscheduler;

import com.esc.message.TextMessage;
import com.esc.message.TextMessageRepository;
import com.esc.user.ApplicationUserRepository;
import com.twilio.Twilio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Controller
public class SenderController {

    @Autowired
    private TextMessageRepository textMessageRepo;
    @Autowired
    private ApplicationUserRepository appUserRepo;

    @GetMapping(value="/test")
    public RedirectView getMessages() throws ParseException {

        // Get current Date
        Date now = new Date();


        // Get all messages
        List<TextMessage> messages = (List<TextMessage>) textMessageRepo.findAll();

        for(TextMessage m : messages) {

            if((m.sendTimestamp.before(now) || m.sendTimestamp.equals(now)) && !m.wasSent) {
                // TWILIO SEND

                Twilio.init(System.getenv("ACCOUNT_SID"), System.getenv("AUTH_TOKEN"));

                /* First number is the TO number, must be a verified number in Twilio
                 * Second number is our Twilio number that CANNOT be changed
                 */
                Message message = Message.creator(new PhoneNumber("2069313616"),
                        new PhoneNumber("+12062028535"),
                        m.message).create();

                m.wasSent = true;
                textMessageRepo.save(m);

            }

        }


        return new RedirectView("/profile");
    }
}
