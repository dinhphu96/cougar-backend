package com.cougar.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cougar.DAO.CategoryDAO;
import com.cougar.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired CategoryDAO categoryDAO;
}
