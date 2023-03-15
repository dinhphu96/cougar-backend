package com.cougar.restController;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
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
import com.cougar.entity.RoleRegister;
import com.cougar.entity.User;
import com.cougar.entity.UserLogin;
import com.cougar.payload.request.RegisterRequest;
import com.cougar.payload.response.MessageResponse;
import com.cougar.repository.RoleRegisterDAO;
import com.cougar.repository.UserLoginDAO;
import com.cougar.service.AuthorityService;
import com.cougar.service.RoleService;
import com.cougar.service.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/users")
public class UserRestController {
	@Autowired
	UserService userService;
	@Autowired
	RoleService roleService;
	@Autowired
	AuthorityService authorityService;
	@Autowired
	UserLoginDAO userLoginDAO;
	@Autowired
	RoleRegisterDAO roleRegisterDAO;

	@Autowired
	PasswordEncoder pe;

	@GetMapping("")
	public List<User> getAll() {
		return userService.findAll();
	}

	@GetMapping("/{id}")
	public User getById(@PathVariable("id") Integer id) {
		return userService.findById(id);
	}

	// Create Admin
	@PostMapping("")
	public ResponseEntity<?> createAdmin(@RequestBody RegisterRequest registerUpRequest) {
		// Kiểm tra email
		if (userLoginDAO.existsByEmail(registerUpRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Email already exists!"));
		}

		// Kiểm tra phone
		if (userLoginDAO.existsByPhone(registerUpRequest.getPhone())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Phone already exists!"));
		}

		// Create new admin's account
		UserLogin userLogin = new UserLogin();
		userLogin.setEmail(registerUpRequest.getEmail());
		userLogin.setPassword(pe.encode(registerUpRequest.getPassword()));
		RoleRegister roles = roleRegisterDAO.findByName("ADMIN").get();
		userLogin.setRoles(Collections.singletonList(roles));
		userLogin.setFullname(registerUpRequest.getFullname());
		userLogin.setPhone(registerUpRequest.getPhone());

		UserLogin temp = userLoginDAO.save(userLogin);

		return ResponseEntity.ok(userService.findById(temp.getId()));
	}

	@PutMapping("")
	public ResponseEntity<?> update(@RequestBody User user) {
		User oldUser = userService.findById(user.getId());
		
		// Kiểm tra email - Nếu khác email cũ thì mới kiểm tra
		if (!user.getEmail().equals(oldUser.getEmail())) {
			if (userLoginDAO.existsByEmail(user.getEmail())) {
				return ResponseEntity.badRequest().body(new MessageResponse("Email already exists!"));
			}
		}
		
		// Kiểm tra phone - Nếu khác phone cũ thì mới kiểm tra
		if (!user.getPhone().equals(oldUser.getPhone())) {
			if (userLoginDAO.existsByPhone(user.getPhone())) {
				return ResponseEntity.badRequest().body(new MessageResponse("Phone already exists!"));
			}
		}
		
		String oladPass = oldUser.getPassword();
		user.setPassword(oladPass);
		return ResponseEntity.ok(userService.update(user));
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

	@PutMapping("/update/{id}")
	public User updateUserFromShop(@PathVariable("id") Integer id, @RequestBody User user) {
		String pass = userService.findById(id).getPassword();
		user.setPassword(pass);
		return userService.update(user);
	}
}
