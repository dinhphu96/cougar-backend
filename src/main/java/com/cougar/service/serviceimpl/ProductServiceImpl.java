package com.cougar.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.cougar.DAO.ProductDAO;
import com.cougar.service.ProductService;

public class ProductServiceImpl implements ProductService {
	@Autowired ProductDAO productDAO;
}
