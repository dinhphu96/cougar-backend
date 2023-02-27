package com.cougar.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cougar.entity.Category;

public interface CategoryDAO extends JpaRepository<Category, Integer>{

}
