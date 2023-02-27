package com.cougar.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cougar.entity.Product;

public interface ProductDAO extends JpaRepository<Product, Integer>{

}
