package com.cougar.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cougar.entity.Variation;

public interface VariationDAO extends JpaRepository<Variation, Integer>{

	@Query("select vari from Variation vari where vari.subcategory.id = ?1")
	List<Variation> getVariationsBySubID(Integer subID);

}
