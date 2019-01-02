package com.esc.message;

import com.esc.user.ApplicationUser;
import com.esc.user.ApplicationUserRepository;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class MessageController {

    @Autowired
    private ApplicationUserRepository appRepo;
    @Autowired
    private TextMessageRepository textMessageRepo;

    // This route saves a user's text message and redirects them to their profile.
    @PostMapping(value="/messages")
    public RedirectView createMessage(@RequestParam String day, @RequestParam String time, @RequestParam String rawMessage, Principal p) throws ParseException {
        // Construct and format the Date
        Date sendDate = new SimpleDateFormat("yyyy-MM-dd").parse(day);
        Date sendTime = new SimpleDateFormat("HH:mm").parse(time);

        //   - Make sure the Date is at least 30 minutes in the future

        // Construct Message object
        TextMessage newMessage = new TextMessage(sendDate, sendTime, rawMessage);

        // Link the message to the signed in user.
        ApplicationUser user = (ApplicationUser) ((UsernamePasswordAuthenticationToken) p).getPrincipal();
        newMessage.applicationUser = appRepo.findByUsername(user.username);

        // Save the date in message database
        textMessageRepo.save(newMessage);

        return new RedirectView("/profile");
    }
}
