package com.cougar.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cougar.entity.ProductWishlist;
import com.cougar.service.ProductWishlistService;

@CrossOrigin("*")
@RestController
public class WishListRestControlller {
	
	@Autowired
	ProductWishlistService productWishlistService;

	@GetMapping("/rest/wishLists/{userId}")
	public List<ProductWishlist> getListWishListByUserId(@PathVariable("userId") Integer userId){
		return productWishlistService.getListWishListByUserId(userId);
	}
	
	@PostMapping("/rest/wishLists")
	public ProductWishlist save(@RequestBody ProductWishlist wishlist){
		return productWishlistService.save(wishlist);
	}
	
	@DeleteMapping("/rest/wishLists/{id}")
	public void deleteById(@PathVariable("id") Integer id) {
		productWishlistService.deleteById(id);
	}
}
