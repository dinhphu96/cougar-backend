package com.cougar.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cougar.DAO.DeliveryMethodDAO;
import com.cougar.service.DeliveryMethodService;

@Service
public class DeliveryMethodServiceImpl implements DeliveryMethodService{
	@Autowired DeliveryMethodDAO deliveryMethodDAO;
}