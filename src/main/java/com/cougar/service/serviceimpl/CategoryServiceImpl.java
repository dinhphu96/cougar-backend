package com.cougar.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.cougar.DAO.CategoryDAO;
import com.cougar.service.CategoryService;

public class CategoryServiceImpl implements CategoryService{
	@Autowired CategoryDAO categoryDAO;
}
