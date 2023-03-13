package com.cougar.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cougar.entity.UserLogin;
import com.cougar.service.UserLoginService;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserLoginService userLoginService;

	@Override
	@Transactional
	public UserLogin loadUserByUsername(String email) throws UsernameNotFoundException {
		return userLoginService.findByEmail(email);		
	}
}
