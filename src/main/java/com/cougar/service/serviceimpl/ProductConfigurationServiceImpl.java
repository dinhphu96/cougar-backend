package com.cougar.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cougar.DAO.ProductConfigurationDAO;
import com.cougar.entity.ProductConfiguration;
import com.cougar.service.ProductConfigurationService;

@Service
public class ProductConfigurationServiceImpl implements ProductConfigurationService{
	
	@Autowired
	ProductConfigurationDAO productConfigurationDAO;

	@Override
	public List<ProductConfiguration> findByProductItemId(Integer productItemId) {
		// TODO Auto-generated method stub
		return productConfigurationDAO.findByProductItemId(productItemId);
	}

	@Override
	public void save(ProductConfiguration con) {
		// TODO Auto-generated method stub
		productConfigurationDAO.save(con);
	}

	@Override
	public List<ProductConfiguration> getAll() {
		// TODO Auto-generated method stub
		return productConfigurationDAO.findAll();
	}
}
