package com.cougar.service;

import java.util.List;

import com.cougar.entity.ProductWishlist;

public interface ProductWishlistService {

	List<ProductWishlist> getListWishListByUserId(Integer userId);

	ProductWishlist save(ProductWishlist wishlist);

	void deleteById(Integer id);

}
