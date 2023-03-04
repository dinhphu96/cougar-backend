package com.cougar.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cougar.DAO.SubcategoryDAO;
import com.cougar.entity.Subcategory;
import com.cougar.service.SubcategoryService;
@Service
public class SubcategoryServiceImpl implements SubcategoryService{
	@Autowired SubcategoryDAO subcategoryDAO;
	
	@Override
	public List<Subcategory> findAll() {
		return subcategoryDAO.findAll();
	}

}
