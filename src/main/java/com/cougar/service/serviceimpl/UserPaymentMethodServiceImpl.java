package com.cougar.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cougar.DAO.UserPaymentMethodDAO;
import com.cougar.entity.UserPaymentMethod;
import com.cougar.service.UserPaymentMethodService;

@Service
public class UserPaymentMethodServiceImpl implements UserPaymentMethodService{
	
	@Autowired
	UserPaymentMethodDAO userPaymentMethodDAO;

	@Override
	public List<UserPaymentMethod> getUserPaymenMethodByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return userPaymentMethodDAO.getUserPaymenMethodByUserId(userId);
	}
	
}
