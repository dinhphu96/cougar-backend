package com.cougar.service;

import java.util.List;

import com.cougar.entity.Variation;

public interface VariationService{

	List<Variation> getVariationsBySubID(Integer subID);

	List<Variation> getAll();

	
}
