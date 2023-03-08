package com.cougar.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cougar.DAO.ProductWishlistDAO;
import com.cougar.entity.ProductWishlist;
import com.cougar.service.ProductWishlistService;
@Service
public class ProductWishlistServiceImpl implements ProductWishlistService{
	
	@Autowired
	ProductWishlistDAO productWishlistDAO;

	@Override
	public List<ProductWishlist> getListWishListByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return productWishlistDAO.getListWishListByUserId(userId);
	}

	@Override
	public ProductWishlist save(ProductWishlist wishlist) {
		// TODO Auto-generated method stub
		return productWishlistDAO.save(wishlist);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		productWishlistDAO.deleteById(id);
	}

}
