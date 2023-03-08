package com.cougar.payload.response;

import lombok.Data;

@Data
public class MessageResponse {
	private String message;

	public MessageResponse(String message) {
		this.message = message;
	}
	
	
}
