package com.cougar.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cougar.DAO.BrandDAO;
import com.cougar.service.BrandService;
@Service
public class BrandServiceImpl implements BrandService {
	@Autowired BrandDAO brandDAO;
}
