package com.cougar.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cougar.entity.OrderDetail;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Integer>{

	@Query("select od from OrderDetail od where od.shopOrder.id = ?1")
	List<OrderDetail> getOrderDetailByShopId(Integer shopId);

}
