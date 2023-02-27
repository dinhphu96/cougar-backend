package com.cougar.service;

import java.util.List;

import com.cougar.entity.Product;

public interface ProductService {

	List<Product> findAll();

	Product findById(Integer id);

	Product save(Product pr);

	Product update(Product pr);

	void delete(Integer id);

}
