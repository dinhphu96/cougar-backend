package com.cougar.payload.request;

import lombok.Data;

@Data
public class RegisterRequest {
	private String fullname;
	private String email;
	private String phone;
	private String password;
	private String avatar;

	public RegisterRequest() {
	}
	public RegisterRequest(String fullname, String email, String phone, String password, String avatar) {
		this.fullname = fullname;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.avatar = avatar;
	}	
}
