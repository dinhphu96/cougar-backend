package com.cougar.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cougar.entity.OrderDetail;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Integer>{

}
