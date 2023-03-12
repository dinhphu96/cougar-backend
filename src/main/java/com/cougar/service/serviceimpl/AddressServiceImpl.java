package com.cougar.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cougar.DAO.AddressDAO;
import com.cougar.entity.Address;
import com.cougar.service.AddressService;
@Service
public class AddressServiceImpl implements AddressService{
	@Autowired AddressDAO addressDAO;

	@Override
	public List<Address> getAddressesByUsserId(Integer userId) {
		// TODO Auto-generated method stub
		return addressDAO.getAddressesByUsserId(userId);
	}

	@Override
	public Address create(Address address) {
		// TODO Auto-generated method stub
		return addressDAO.save(address);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		addressDAO.deleteById(id);
	}
}
