package com.cougar.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cougar.entity.Address;
import com.cougar.service.AddressService;

@CrossOrigin("*")
@RestController
public class AddessesRestController {
	
	@Autowired
	AddressService addressService;

	@GetMapping("/rest/addresses/{userId}")
	public List<Address> getAddressesByUsserId(@PathVariable("userId") Integer userId){
		return addressService.getAddressesByUsserId(userId);
	}
}