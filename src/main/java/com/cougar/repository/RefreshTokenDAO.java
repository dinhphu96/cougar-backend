package com.cougar.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cougar.entity.RefreshToken;

public interface RefreshTokenDAO extends JpaRepository<RefreshToken, Integer> {
//	Optional<RefreshToken> findByToken(String token);
}
