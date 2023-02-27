package com.cougar.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cougar.DAO.AddressDAO;
import com.cougar.service.AddressService;
@Service
public class AddressServiceImpl implements AddressService{
	@Autowired AddressDAO addressDAO;
}
