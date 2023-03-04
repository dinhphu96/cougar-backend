package com.cougar.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cougar.entity.Address;

public interface AddressDAO extends JpaRepository<Address, Integer>{

	@Query("select adr from Address adr where adr.user.id = ?1")
	List<Address> getAddressesByUsserId(Integer userId);



}
