package com.cougar.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cougar.entity.UserPaymentMethod;

public interface UserPaymentMethodDAO extends JpaRepository<UserPaymentMethod, Integer>{

}
