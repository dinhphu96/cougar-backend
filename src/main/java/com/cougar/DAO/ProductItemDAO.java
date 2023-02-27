package com.cougar.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cougar.entity.ProductItem;

public interface ProductItemDAO extends JpaRepository<ProductItem, Integer>{

}
