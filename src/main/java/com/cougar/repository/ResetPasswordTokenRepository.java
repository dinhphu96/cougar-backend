package com.cougar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cougar.entity.ResetPasswordToken;

public interface ResetPasswordTokenRepository extends JpaRepository<ResetPasswordToken, Integer> {
	ResetPasswordToken findByToken(String token);
}
