package com.cougar.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cougar.entity.ProductWishlist;

public interface ProductWishlistDAO extends JpaRepository<ProductWishlist, Integer>{

}
