package com.cougar.service;

import java.util.List;

import com.cougar.entity.ProductConfiguration;

public interface ProductConfigurationService {

	List<ProductConfiguration> findByProductItemId(Integer productItemId);

	void save(ProductConfiguration con);

	List<ProductConfiguration> getAll();

	ProductConfiguration update(ProductConfiguration con);

	ProductConfiguration saveNewItem(ProductConfiguration con);

}
