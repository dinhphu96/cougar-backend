package com.cougar.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cougar.entity.ShopOrder;

public interface ShopOrderDAO extends JpaRepository<ShopOrder, Integer>{

	@Query("select so from ShopOrder so where so.user.id = ?1 and so.orderStatus = null")
	ShopOrder findCartByUserId(Integer userId);
	
	@Query("SELECT so FROM ShopOrder so WHERE so.user.id = ?1 ORDER BY so.id DESC")
	List<ShopOrder> findByUserId(Integer userId);
}
