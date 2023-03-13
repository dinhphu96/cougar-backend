package com.cougar.service.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cougar.entity.UserLogin;
import com.cougar.repository.UserLoginDAO;
import com.cougar.service.UserLoginService;

@Service

public class UserLoginServiceImpl implements UserLoginService{
	@Autowired
	private UserLoginDAO userLoginDAO;

	@Override
	public UserLogin findByEmail(String email) {		
		Optional<UserLogin> optionalUserLogin = userLoginDAO.findByEmail(email);
        return optionalUserLogin.orElse(null);
	}
	
	
}
