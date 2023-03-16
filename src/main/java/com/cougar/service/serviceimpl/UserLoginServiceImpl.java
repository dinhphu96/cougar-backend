package com.cougar.service.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.cougar.entity.UserLogin;
import com.cougar.repository.UserLoginDAO;
import com.cougar.service.UserLoginService;

@Service

public class UserLoginServiceImpl implements UserLoginService{
	@Autowired
	private UserLoginDAO userLoginDAO;
	
	@Autowired
    private JavaMailSender mailSender;

	@Override
	public UserLogin findByEmail(String email) {		
		Optional<UserLogin> optionalUserLogin = userLoginDAO.findByEmail(email);
        return optionalUserLogin.orElse(null);
	}

	@Override
	public void sendEmail(String to, String subject, String text)  {
		SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);		
	}

	@Override
	public UserLogin save(UserLogin user) {		
		return userLoginDAO.save(user);
	}
	
	
}
