package com.cougar.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cougar.entity.ProductConfiguration;


public interface ProductConfigurationDAO extends JpaRepository<ProductConfiguration, Integer>{

	@Query("select con from ProductConfiguration con where con.productItem.id = ?1")
	List<ProductConfiguration> findByProductItemId(Integer productItemId);

}
