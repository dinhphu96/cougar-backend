package com.cougar.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cougar.entity.RoleLogin;


public interface RoleLoginDAO extends JpaRepository<RoleLogin, Integer> {
	Optional<RoleLogin> findByName(String name);
}
