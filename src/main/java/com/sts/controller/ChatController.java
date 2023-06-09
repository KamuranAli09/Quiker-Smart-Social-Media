package com.sts.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sts.model.Messages;

@RestController
public class ChatController {
	@SendTo("/topic/return-to")
	@MessageMapping("/message")
	public Messages getContent(@RequestBody Messages message) {
		try {
			Thread.sleep(200);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		return message;
	}
	
}