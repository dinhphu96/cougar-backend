package com.cougar.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.cougar.DAO.PaymentTypeDAO;
import com.cougar.service.PaymentTypeService;

public class PaymentTypeServiceImpl implements PaymentTypeService{
	@Autowired PaymentTypeDAO paymentTypeDAO;
}
