package com.cougar.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cougar.entity.Contact;

public interface ContactDAO extends JpaRepository<Contact, Integer>{
	
}
