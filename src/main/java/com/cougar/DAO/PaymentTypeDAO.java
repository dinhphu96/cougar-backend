package com.cougar.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cougar.entity.PaymentType;

public interface PaymentTypeDAO extends JpaRepository<PaymentType, Integer>{

}
