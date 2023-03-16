package com.cougar.service;

import com.cougar.entity.UserLogin;

public interface UserLoginService {
	UserLogin findByEmail(String email); 
	void sendEmail(String to, String subject, String text);
	UserLogin save(UserLogin user);
}
