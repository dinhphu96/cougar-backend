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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cougar.entity.Address;
import com.cougar.service.AddressService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/addresses")
public class AddessesRestController {
	
	@Autowired
	AddressService addressService;

	@GetMapping("/{userId}")
	public List<Address> getAddressesByUsserId(@PathVariable("userId") Integer userId){
		return addressService.getAddressesByUsserId(userId);
	}
	
	@PostMapping("")
	public Address create(@RequestBody Address address) {
		return addressService.create(address);
	}
	
	@PutMapping("/{id}")
	public Address update(@PathVariable("id") Integer id, @RequestBody Address address) {
		return addressService.create(address); //update
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		addressService.delete(id);
	}
	
	@PutMapping("/setAsDefault")
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
