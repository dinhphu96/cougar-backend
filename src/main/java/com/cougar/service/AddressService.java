package com.cougar.service;

import java.util.List;

import com.cougar.entity.Address;

public interface AddressService {

	List<Address> getAddressesByUsserId(Integer userId);

	Address create(Address address);

	void delete(Integer id);
	
}
