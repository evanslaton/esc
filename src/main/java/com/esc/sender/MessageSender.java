package com.esc.sender;

import com.esc.message.TextMessage;
import com.esc.message.TextMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class MessageSender {

    @Autowired
    private TextMessageRepository textMessageRepo;

    public Iterable<TextMessage> getMessages() throws Exception {
//        String todaysDate = new Date().toString();
//        Date sendDate = new SimpleDateFormat("yyyy-MM-dd").parse("2019-01-01");
//        Date sendTime = new SimpleDateFormat("HH:mm").parse(todaysDate);

        Iterable<TextMessage> messages = textMessageRepo.findAll();
        return messages;
    }

    public MessageSender(TextMessageRepository repo) {
        this.textMessageRepo = repo;
    }

}
