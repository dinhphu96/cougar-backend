package com.cougar.payload.request;

import lombok.Data;

@Data
public class ChangePasswordRequest {
	private String currentPassword;
	private String newPassword;
	private String email;
}
