package com.esc.twilioscheduler;

import com.esc.message.TextMessage;
import com.esc.message.TextMessageRepository;
import com.esc.user.ApplicationUserRepository;
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
        DateFormat timeStampFormatter = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat timeFormatter = new SimpleDateFormat("HH:mm");

        // Get all messages
        List<TextMessage> messages = (List<TextMessage>) textMessageRepo.findAll();

        // Filter out messages with today's day, times before current time, and message not sent yet.
        // Loop through messages
        //    Get phone number associated with message
        //    Send message through twilio
        //    Set boolean to true
        for (TextMessage m : messages) {

//            Date messageDate = (Date) m.date;
//            Date messageTime = (Date) m.time;

//            System.out.println(messageDate);
//            System.out.println(messageTime);






//            if(messageDate == now. && (m.time == nowTime || m.time.before(nowTime)) && !m.was_sent) {
//                // Send message with Twilio
//                System.out.println("Message DATE: " + m.date);
//                System.out.println("Message TIME: " + m.time);
//            }




//            if(m.date == nowDate && (m.time == nowTime || m.time.before(nowTime)) && !m.was_sent) {
//                // Send message with Twilio
//                System.out.println("Message DATE: " + m.date);
//                System.out.println("Message TIME: " + m.time);
//            }
        }

        return new RedirectView("/profile");
    }
}
