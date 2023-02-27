package com.cougar.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cougar.DAO.ProductConfigurationDAO;
import com.cougar.service.ProductConfigurationService;

@Service
public class ProductConfigurationServiceImpl implements ProductConfigurationService{
	@Autowired ProductConfigurationDAO productConfigurationDAO;
}
