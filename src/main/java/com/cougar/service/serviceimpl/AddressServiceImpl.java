package com.cougar.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.cougar.DAO.AddressDAO;
import com.cougar.service.AddressService;

public class AddressServiceImpl implements AddressService{
	@Autowired AddressDAO addressDAO;
}
