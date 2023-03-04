package com.cougar.service;

import java.util.List;

import com.cougar.entity.ProductConfiguration;

public interface ProductConfigurationService {

	List<ProductConfiguration> findByProductItemId(Integer productItemId);

}
