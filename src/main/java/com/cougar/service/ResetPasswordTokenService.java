package com.cougar.service;

import com.cougar.entity.ResetPasswordToken;
import com.cougar.entity.UserLogin;

public interface ResetPasswordTokenService {
	ResetPasswordToken createResetPasswordTokenForUser(UserLogin userLogin, String token);
    void deletePasswordResetToken(ResetPasswordToken resetPasswordToken);
    ResetPasswordToken getResetPasswordToken(String token);
}
