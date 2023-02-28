package com.cougar.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cougar.DAO.AuthorityDAO;
import com.cougar.entity.Authority;
import com.cougar.service.AuthorityService;

@Service
public class AuthorityServiceImpl implements AuthorityService{
	@Autowired AuthorityDAO authorityDAO;

	@Override
	public List<Authority> findAll() {
		return authorityDAO.findAll();
	}
	
	@Override
	public void create(Authority newAuthority) {
		authorityDAO.save(newAuthority);
	}

}
