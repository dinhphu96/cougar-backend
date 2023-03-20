package com.cougar.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cougar.DAO.ContactDAO;
import com.cougar.entity.Contact;
import com.cougar.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {
	@Autowired ContactDAO contactDAO;

	@Override
	public List<Contact> findAll() {
		return contactDAO.findAll();
	}

	@Override
	public void save(Contact contact) {
		contactDAO.save(contact);
	}
	
}
