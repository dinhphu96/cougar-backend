package com.cougar.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("/rest/addresses")
	public Address create(@RequestBody Address address) {
		return addressService.create(address);
	}
	
	@PutMapping("/rest/addresses/{id}")
	public Address update(@PathVariable("id") Integer id, @RequestBody Address address) {
		return addressService.create(address); //update
	}
	
	@DeleteMapping("/rest/addresses/{id}")
	public void delete(@PathVariable("id") Integer id) {
		addressService.delete(id);
	}
	
	@PutMapping("/rest/addresses/setAsDefault")
	public List<Address> setAsDefault(@RequestBody Address address){
		List<Address> list = addressService.getAddressesByUsserId(address.getUser().getId());
		for (Address add : list) {
			if(add.getIsDefault() == true) {
				add.setIsDefault(false);
				addressService.create(add); 
			}
			
		}
		address.setIsDefault(true);
		addressService.create(address); 
		
		return list;
	}
}
