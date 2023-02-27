package com.cougar.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cougar.DAO.ProductDAO;
import com.cougar.entity.Product;
import com.cougar.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDAO productDAO;

	@Override
	public List<Product> findAll() {
		return productDAO.findAll();
	}

	@Override
	public Product findById(Integer id) {
		return productDAO.findById(id).get();
	}

	@Override
	public Product save(Product pr) {
		return productDAO.save(pr);
	}

	@Override
	public Product update(Product pr) {
		return productDAO.save(pr);
	}

	@Override
	public void delete(Integer id) {
		productDAO.deleteById(id);
		
	}
}
