package com.cougar.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cougar.entity.Authority;
import com.cougar.entity.Role;
import com.cougar.entity.User;
import com.cougar.service.AuthorityService;
import com.cougar.service.RoleService;
import com.cougar.service.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/users")
public class UserRestController {
	@Autowired UserService userService;
	@Autowired RoleService roleService;
	@Autowired AuthorityService authorityService;
	
	@GetMapping("")
	public List<User> getAll() {
		return userService.findAll();
	}
	
	@GetMapping("/{id}")
	public User getById(@PathVariable("id") Integer id) {
		return userService.findById(id);
	}
	
	@PostMapping("")
	public User post(@RequestBody User user) {
		Role role = roleService.findById(1); // ADMIN
		User userCreated = userService.create(user);
		
		Authority newAuthority = new Authority();
		newAuthority.setRole(role);
		newAuthority.setUser(userCreated);
		
		authorityService.create(newAuthority);
		return userCreated;
	}
	
	@PutMapping("")
	public User update(@RequestBody User user) {
		return userService.update(user);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		userService.deleteById(id);
	}
	
	@GetMapping("/is-admin")
	public List<User> isAdmin() {
		return userService.isAdmin();
	}
	
	@GetMapping("/is-user")
	public List<User> isUser() {
		return userService.isUser();
	}
}
