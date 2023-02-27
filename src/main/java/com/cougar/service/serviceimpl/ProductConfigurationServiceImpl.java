package com.cougar.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.cougar.DAO.ProductConfigurationDAO;
import com.cougar.service.ProductConfigurationService;

public class ProductConfigurationServiceImpl implements ProductConfigurationService{
	@Autowired ProductConfigurationDAO productConfigurationDAO;
}
