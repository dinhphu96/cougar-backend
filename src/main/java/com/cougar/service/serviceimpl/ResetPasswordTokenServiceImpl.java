package com.cougar.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cougar.entity.ResetPasswordToken;
import com.cougar.entity.UserLogin;
import com.cougar.repository.ResetPasswordTokenRepository;
import com.cougar.service.ResetPasswordTokenService;

@Service
public class ResetPasswordTokenServiceImpl implements ResetPasswordTokenService {
	
	@Autowired
	ResetPasswordTokenRepository resetPasswordTokenRepository;
	
	@Override
	public ResetPasswordToken createResetPasswordTokenForUser(UserLogin user, String token) {
		ResetPasswordToken resetPasswordToken = new ResetPasswordToken(token, user);
		return resetPasswordTokenRepository.save(resetPasswordToken);
	}

	@Override
	public void deletePasswordResetToken(ResetPasswordToken resetPasswordToken) {
		resetPasswordTokenRepository.delete(resetPasswordToken);
	}

	@Override
	public ResetPasswordToken getResetPasswordToken(String token) {
		return resetPasswordTokenRepository.findByToken(token);
	}

}
