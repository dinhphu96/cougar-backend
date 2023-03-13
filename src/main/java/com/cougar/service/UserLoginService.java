package com.cougar.service;

import com.cougar.entity.UserLogin;

public interface UserLoginService {
	UserLogin findByEmail(String email); 
}
