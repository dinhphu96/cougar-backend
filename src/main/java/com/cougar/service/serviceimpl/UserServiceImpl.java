package com.cougar.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cougar.DAO.UserDAO;
import com.cougar.entity.User;
import com.cougar.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired UserDAO userDAO;
	
	@Override
	public List<User> findAll() {
		return userDAO.findAll();
	}

	@Override
	public User findById(Integer id) {
		return userDAO.findById(id).get();
	}

	@Override
	public User create(User user) {
		return userDAO.save(user);
	}

	@Override
	public User update(User user) {
		return userDAO.save(user);
	}

	@Override
	public void deleteById(Integer id) {
		userDAO.deleteById(id);
	}

	@Override
	public List<User> isAdmin() {
		return userDAO.getAllUsersHaveRoleAdmin();
	}

	@Override
	public List<User> isUser() {
		return userDAO.getAllUsersHaveRoleUser();
	}

}
