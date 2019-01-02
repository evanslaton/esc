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

@Service
public class MessageSender {
    private TextMessageRepository textMessageRepo;

    @Autowired
    public void setTextMessageRepo(TextMessageRepository textMessageRepo) {
        MessageSender.textMessageRepo = textMessageRepo;
    }

    
}
