package com.chatmessenger.backend.chatmessenger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.chatmessenger.backend.chatmessenger.entity.User;
import com.chatmessenger.backend.chatmessenger.service.UserService;
import com.chatmessenger.backend.chatmessenger.vo.ChatMessageRequest;
import com.chatmessenger.backend.chatmessenger.vo.ChatMessageResponse;

@Controller
public class ChatController {
	
	@Autowired
	private UserService userService;
	
	@MessageMapping("/chat.sendMessage")
	@SendTo("/topic/public")
	public ChatMessageResponse sendMessage(@Payload ChatMessageRequest chatMessage) {
		ChatMessageResponse response = new ChatMessageResponse();
		response.setContent(chatMessage.getContent());
		response.setSenderId(chatMessage.getSenderId());
		User user = userService.getUser(chatMessage.getSenderId());
		response.setSenderName(user.getUserName());
		return response;
	}
	
	@MessageMapping("/chat.addUser")
	@SendTo("/topic/public")
	public ChatMessageRequest addUser(@Payload ChatMessageRequest chatMessage, SimpMessageHeaderAccessor headerAccessor) {
		headerAccessor.getSessionAttributes().put("username", chatMessage.getSenderId());
		chatMessage.setContent("I have just joined...");
		return chatMessage;
	}
	
}
