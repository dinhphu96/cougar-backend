package com.cougar.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.cougar.DAO.BrandDAO;
import com.cougar.service.BrandService;

public class BrandServiceImpl implements BrandService {
	@Autowired BrandDAO brandDAO;
}
