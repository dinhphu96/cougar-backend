package com.cougar.payload.request;

import lombok.Data;

@Data
public class ResetPasswordRequest {
	String password;
	String token;
}
