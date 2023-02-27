package com.cougar.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cougar.DAO.AuthorityDAO;
import com.cougar.service.AuthorityService;
@Service
public class AuthorityServiceImpl implements AuthorityService{
	@Autowired AuthorityDAO authorityDAO;
}
