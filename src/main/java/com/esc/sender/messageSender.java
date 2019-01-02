package com.esc.sender;

import com.esc.message.TextMessage;
import com.esc.message.TextMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class messageSender {

    @Autowired
    private TextMessageRepository TextMessageRepo;

    public List<TextMessage> getMessages() {
        List<TextMessage> messages = TextMessageRepo.findAllWithCurrentDate(new Date());
        return messages;
    }
}
