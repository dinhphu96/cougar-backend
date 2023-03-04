package com.cougar.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cougar.DAO.CategoryDAO;
import com.cougar.entity.Category;
import com.cougar.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired CategoryDAO categoryDAO;

	@Override
	public List<Category> findAll() {
		return categoryDAO.findAll();
	}
}
