package com.cougar.payload.response;

import java.util.List;

import lombok.Data;

@Data
public class JwtResponse {
	private String accessToken;
	private String type = "Bearer ";
	private Integer id;
	private String fullname;
	private String email;
	private List<String> roles;
	public JwtResponse(String accessToken, Integer id, String fullname, String email, List<String> roles) {
		this.accessToken = accessToken;
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.roles = roles;
	}	
	
	
}
