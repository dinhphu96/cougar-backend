package com.cougar.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.cougar.DAO.OrderDetailDAO;
import com.cougar.service.OrderDetailService;

public class OrderDetailServiceImpl implements OrderDetailService{
	@Autowired OrderDetailDAO orderDetailDAO;
}
