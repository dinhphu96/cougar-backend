package com.cougar.service;

import java.util.List;

import com.cougar.entity.Authority;

public interface AuthorityService {

	void create(Authority newAuthority);

	List<Authority> findAll();

}
