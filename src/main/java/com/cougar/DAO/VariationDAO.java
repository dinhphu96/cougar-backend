package com.cougar.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cougar.entity.Variation;

public interface VariationDAO extends JpaRepository<Variation, Integer>{
	
}
