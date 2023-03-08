package com.cougar.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< Updated upstream
=======
import org.springframework.data.jpa.repository.Query;
>>>>>>> Stashed changes

import com.cougar.entity.UserLogin;


public interface UserLoginDAO extends JpaRepository<UserLogin, Integer> {
	Optional<UserLogin> findByEmail(String email);
	Boolean existsByEmail(String email);
<<<<<<< Updated upstream
	UserLogin getUserLoginById(Integer userSessionID);
=======
	Boolean existsByPhone(String phone);
//	@Query(value = "select * from UserLogin u where u.email = ?1 and password = ?2", nativeQuery = true)
//	Boolean exitsUser(String email, String password);
>>>>>>> Stashed changes
}
