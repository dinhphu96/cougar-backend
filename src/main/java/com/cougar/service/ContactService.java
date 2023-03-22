package com.cougar.service;

import java.util.List;

import com.cougar.entity.Contact;

public interface ContactService {

	List<Contact> findAll();

	void save(Contact contact);

	Contact changeStatus(Contact contact);

}
