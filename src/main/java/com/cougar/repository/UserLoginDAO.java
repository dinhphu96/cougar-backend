package com.cougar.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cougar.entity.UserLogin;


public interface UserLoginDAO extends JpaRepository<UserLogin, Integer> {
	Optional<UserLogin> findByEmail(String email);
	Boolean existsByEmail(String email);
	UserLogin getUserLoginById(Integer userSessionID);
}
