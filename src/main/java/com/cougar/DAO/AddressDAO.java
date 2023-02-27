package com.cougar.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cougar.entity.Address;

public interface AddressDAO extends JpaRepository<Address, Integer>{

}
