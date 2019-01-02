package com.esc.sender;

import com.esc.message.TextMessage;
import com.esc.message.TextMessageRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringRunner;
import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class messageSenderTest {
    @Autowired
    private TextMessageRepository textMessageRepo;

    @Test
    public void testThings() throws Exception {
//        List<TextMessage> messages = TextMessageRepo.findAllWithCurrentDate(new SimpleDateFormat("yyyy-MM-dd").parse("2019-01-01"));
//        System.out.println(messages);
//        Date sendDate = new SimpleDateFormat("yyyy-MM-dd").parse("2019-01-01");
//        System.out.println(sendDate);
//        String day = "2019-01-01";
//        String time = "09:30";
//        Date sendDate = new SimpleDateFormat("yyyy-MM-dd").parse(day);
//        Date sendTime = new SimpleDateFormat("HH:mm").parse(time);
//
//        textMessageRepo.save(new TextMessage(sendDate, sendTime, "This is the right message to show"));
//
//        day = "2020-01-01";
//        time = "09:30";
//        sendDate = new SimpleDateFormat("yyyy-MM-dd").parse(day);
//        sendTime = new SimpleDateFormat("HH:mm").parse(time);
//
//        textMessageRepo.save(new TextMessage(sendDate, sendTime, "This is the wrong message to show"));
//
//        System.out.println(textMessageRepo.findAll());
    }
}