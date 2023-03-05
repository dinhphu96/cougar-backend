package com.cougar.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cougar.entity.UserPaymentMethod;

public interface UserPaymentMethodDAO extends JpaRepository<UserPaymentMethod, Integer>{

	@Query("select pm from UserPaymentMethod pm where pm.user.id = ?1")
	List<UserPaymentMethod> getUserPaymenMethodByUserId(Integer userId);

}
