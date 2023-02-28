package com.cougar.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cougar.DAO.RoleDAO;
import com.cougar.entity.Role;
import com.cougar.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService{
	@Autowired RoleDAO roleDAO;

	@Override
	public Role findById(Integer id) {
		return roleDAO.findById(id).get();
	}

}
