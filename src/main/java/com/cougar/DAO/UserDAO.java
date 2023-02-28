package com.cougar.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cougar.entity.User;

public interface UserDAO extends JpaRepository<User, Integer>{
	
}
