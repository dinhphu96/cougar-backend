package com.cougar.service;

import java.util.List;

import com.cougar.entity.User;

public interface UserService {

	List<User> findAll();

	User findById(Integer id);

	User create(User user);

	User update(User user);

	void deleteById(Integer id);

	List<User> isAdmin();

	List<User> isUser();

}
