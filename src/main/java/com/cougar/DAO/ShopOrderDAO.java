package com.cougar.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cougar.entity.ShopOrder;

public interface ShopOrderDAO extends JpaRepository<ShopOrder, Integer>{

	@Query("select so from ShopOrder so where so.user.id = ?1 and so.orderStatus = null")
	ShopOrder findCartByUserId(Integer userId);

}
