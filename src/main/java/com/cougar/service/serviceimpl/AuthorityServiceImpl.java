package com.cougar.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.cougar.DAO.AuthorityDAO;
import com.cougar.service.AuthorityService;

public class AuthorityServiceImpl implements AuthorityService{
	@Autowired AuthorityDAO authorityDAO;
}
