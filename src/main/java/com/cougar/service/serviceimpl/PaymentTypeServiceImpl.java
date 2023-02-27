package com.cougar.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cougar.DAO.PaymentTypeDAO;
import com.cougar.service.PaymentTypeService;

@Service
public class PaymentTypeServiceImpl implements PaymentTypeService{
	@Autowired PaymentTypeDAO paymentTypeDAO;
}
