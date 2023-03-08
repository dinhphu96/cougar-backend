package com.cougar.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cougar.entity.ProductWishlist;

public interface ProductWishlistDAO extends JpaRepository<ProductWishlist, Integer>{

	@Query("select wl from ProductWishlist wl where wl.user.id = ?1")
	List<ProductWishlist> getListWishListByUserId(Integer userId);

}
