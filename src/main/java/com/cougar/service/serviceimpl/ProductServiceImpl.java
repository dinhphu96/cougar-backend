package com.cougar.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cougar.DAO.ProductDAO;
import com.cougar.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired ProductDAO productDAO;
}
