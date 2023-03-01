package com.cougar.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cougar.entity.User;

public interface UserDAO extends JpaRepository<User, Integer>{
	
	@Query("SELECT DISTINCT A.user FROM Authority A WHERE A.role.id = 1")
	List<User> getAllUsersHaveRoleAdmin();
	
	@Query("SELECT DISTINCT A.user FROM Authority A WHERE A.role.id = 2")
	List<User> getAllUsersHaveRoleUser();
}
