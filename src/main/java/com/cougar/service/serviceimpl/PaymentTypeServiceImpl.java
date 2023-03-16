package com.cougar.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cougar.DAO.PaymentTypeDAO;
import com.cougar.entity.PaymentType;
import com.cougar.service.PaymentTypeService;

@Service
public class PaymentTypeServiceImpl implements PaymentTypeService{
	@Autowired PaymentTypeDAO paymentTypeDAO;

	@Override
	public List<PaymentType> getAll() {
		// TODO Auto-generated method stub
		return paymentTypeDAO.findAll();
	}
}
