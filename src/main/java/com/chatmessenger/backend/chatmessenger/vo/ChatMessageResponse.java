package com.chatmessenger.backend.chatmessenger.vo;

import lombok.Data;

@Data
public class ChatMessageResponse {
	private Long senderId;
	private String senderName;
	private String content;
}
