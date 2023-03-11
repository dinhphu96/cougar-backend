package com.cougar.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cougar.entity.UserLogin;
import com.cougar.repository.UserLoginDAO;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserLoginDAO userDao;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserLogin user = userDao.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + email));
		return UserDetailsImpl.build(user);
	}
}
