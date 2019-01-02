package com.esc;

import com.esc.message.TextMessageRepository;
import com.esc.sender.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EscApplication {

	public static void main(String[] args) {
		SpringApplication.run(EscApplication.class, args);

		System.out.println("http://localhost:8080");



		MessageSender m = new MessageSender(textMessageRepo);
		try {
			System.out.println(m.getMessages());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Autowired
	private static TextMessageRepository textMessageRepo;
	
}

