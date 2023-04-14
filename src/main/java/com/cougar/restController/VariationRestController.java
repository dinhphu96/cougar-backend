package com.cougar.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cougar.entity.Variation;
import com.cougar.service.VariationService;

@CrossOrigin("*")
@RestController
public class VariationRestController {
	@Autowired VariationService variationService;
	
	@GetMapping("/api/variations/{subID}")
	public List<Variation> getVariationsBySubID(@PathVariable("subID")Integer subID) {
		return variationService.getVariationsBySubID(subID);
	}
	
	@GetMapping("/api/variations")
	public List<Variation> getAll() {
		return variationService.getAll();
	}
}
