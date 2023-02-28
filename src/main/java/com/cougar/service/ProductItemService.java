package com.cougar.service;

import java.util.List;

import com.cougar.entity.ProductItem;

public interface ProductItemService {

	List<ProductItem> findAll();

	ProductItem findById(Integer id);

	ProductItem save(ProductItem prI);

	ProductItem update(ProductItem prI);

	void delete(Integer id);

}
