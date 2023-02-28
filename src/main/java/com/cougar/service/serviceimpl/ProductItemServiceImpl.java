package com.cougar.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cougar.DAO.ProductItemDAO;
import com.cougar.entity.ProductItem;
import com.cougar.service.ProductItemService;
@Service
public class ProductItemServiceImpl implements ProductItemService{
	
	@Autowired
	ProductItemDAO productItemDAO;

	@Override
	public List<ProductItem> findAll() {
		// TODO Auto-generated method stub
		return productItemDAO.findAll();
	}

	@Override
	public ProductItem findById(Integer id) {
		// TODO Auto-generated method stub
		return productItemDAO.findById(id).get();
	}

	@Override
	public ProductItem save(ProductItem prI) {
		// TODO Auto-generated method stub
		return productItemDAO.save(prI);
	}

	@Override
	public ProductItem update(ProductItem prI) {
		// TODO Auto-generated method stub
		return productItemDAO.save(prI);
	}

	@Override
	public void delete(Integer id) {
		productItemDAO.deleteById(id);
		
	}


}
