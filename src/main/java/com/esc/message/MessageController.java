package com.esc.message;

import com.esc.user.ApplicationUser;
import com.esc.user.ApplicationUserRepository;
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

@Controller
public class MessageController {

    @Autowired
    private ApplicationUserRepository appRepo;
    @Autowired
    private TextMessageRepository textMessageRepo;

    @PostMapping(value="/messages")
    public RedirectView createMessage(@RequestParam String day, @RequestParam String time, @RequestParam String rawMessage, Principal p) {
        // Construct and format the Joda-Time object
        String dateTime = day + " " + time;
        DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");
        LocalDateTime jodaTime = format.parseLocalDateTime(dateTime);
//        DateTimeFormatter formatOut = DateTimeFormat.forPattern("MM/dd/yyyy HH:mm"); //Use this if you want to print the Date/Time in a different format.

        System.out.println(format.print(jodaTime)); //For testing

        //   - Make sure the Date is at least 30 minutes in the future

        // Construct Message object
        TextMessage newMessage = new TextMessage(jodaTime, rawMessage);

        // Link the message to the signed in user.
        ApplicationUser user = (ApplicationUser) ((UsernamePasswordAuthenticationToken) p).getPrincipal();
        newMessage.applicationUser = appRepo.findByUsername(user.username);

        // Save the date in message database
        textMessageRepo.save(newMessage);

        return new RedirectView("/profile");
    }
}
