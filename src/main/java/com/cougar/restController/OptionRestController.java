package com.cougar.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cougar.entity.Option;
import com.cougar.service.OptionService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/options")
public class OptionRestController {
	@Autowired
	OptionService optionService;

	@GetMapping("")
	public List<Option> getAll() {
		return optionService.findAll();
	}
	
	@PostMapping("")
	public Option create(@RequestBody Option option) {
		return optionService.create(option);
	}

}
