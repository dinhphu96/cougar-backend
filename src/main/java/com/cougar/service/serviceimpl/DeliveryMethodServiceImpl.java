package com.cougar.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cougar.DAO.DeliveryMethodDAO;
import com.cougar.entity.DeliveryMethod;
import com.cougar.service.DeliveryMethodService;

@Service
public class DeliveryMethodServiceImpl implements DeliveryMethodService{
	@Autowired DeliveryMethodDAO deliveryMethodDAO;

	@Override
	public List<DeliveryMethod> getAll() {
		// TODO Auto-generated method stub
		return deliveryMethodDAO.findAll();
	}
	
}
