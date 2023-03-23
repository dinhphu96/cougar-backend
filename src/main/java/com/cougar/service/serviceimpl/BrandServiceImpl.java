package com.cougar.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cougar.DAO.BrandDAO;
import com.cougar.entity.Brand;
import com.cougar.service.BrandService;
@Service
public class BrandServiceImpl implements BrandService {
	@Autowired BrandDAO brandDAO;

	@Override
	public List<Brand> getAll() {
		// TODO Auto-generated method stub
		return brandDAO.findAll();
	}
}
