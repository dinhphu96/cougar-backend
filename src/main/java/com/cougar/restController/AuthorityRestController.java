package com.cougar.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cougar.entity.Authority;
import com.cougar.service.AuthorityService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/authorities")
public class AuthorityRestController {
	@Autowired AuthorityService authorityService;

	@GetMapping("")
	public List<Authority> getAll() {
		return authorityService.findAll();
	}
}
