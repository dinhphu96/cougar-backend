package com.cougar.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cougar.entity.Option;
import com.cougar.service.OptionService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/options")
public class OptionRestController {
	@Autowired OptionService optionService;
	@GetMapping("")
	public List<Option> getAll() {
		return optionService.findAll();
	}
}
