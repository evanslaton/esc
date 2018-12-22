package com.esc.message;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Date;

@Controller
public class MessageController {

    @PostMapping(value="/messages")
    public RedirectView createMessage(@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date day, @RequestParam String time, @RequestParam String message) {
        // Construct the Date object
        day.set
        //   - Make sure the Date is at least 30 minutes in the future
        // Create new message




        // Link the message to the signed in user
        // Save it to the database

        return new RedirectView("/profile");
    }
}
