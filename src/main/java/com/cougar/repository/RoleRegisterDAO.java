package com.cougar.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cougar.entity.RoleRegister;


public interface RoleRegisterDAO extends JpaRepository<RoleRegister, Integer> {
	Optional<RoleRegister> findByName(String name);
}
