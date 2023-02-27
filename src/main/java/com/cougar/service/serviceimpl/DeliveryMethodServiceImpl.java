package com.cougar.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.cougar.DAO.DeliveryMethodDAO;
import com.cougar.service.DeliveryMethodService;

public class DeliveryMethodServiceImpl implements DeliveryMethodService{
	@Autowired DeliveryMethodDAO deliveryMethodDAO;
}
