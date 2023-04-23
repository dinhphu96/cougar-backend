package com.cougar.restController;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
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
@RequestMapping("/api/users")
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

	@PostMapping("/create-admin-with-avatar")
	public ResponseEntity<?> createAdminWithAvatar(@RequestBody RegisterRequest registerUpRequest) {
		if (userLoginDAO.existsByEmail(registerUpRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Email already exists!"));
		}
		if (userLoginDAO.existsByPhone(registerUpRequest.getPhone())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Phone already exists!"));
		}
		UserLogin userLogin = new UserLogin();
		userLogin.setEmail(registerUpRequest.getEmail());
		userLogin.setPassword(pe.encode(registerUpRequest.getPassword()));
		RoleRegister roles = roleRegisterDAO.findByName("ADMIN").get();
		userLogin.setRoles(Collections.singletonList(roles));
		userLogin.setFullname(registerUpRequest.getFullname());
		userLogin.setPhone(registerUpRequest.getPhone());
		UserLogin adminCreated = userLoginDAO.save(userLogin);
		Map<String, String> config = new HashMap<>();
		config.put("cloud_name", "dmjh7imwd");
		config.put("api_key", "778777726581776");
		config.put("api_secret", "maiZWuW_V9AF9gIfGJ7ZLHpb3z8");
		Cloudinary cloudinary = new Cloudinary(config);
		String avatarNameOnCloud = "avatar-user-id-" + adminCreated.getId();
		@SuppressWarnings("rawtypes")
		Map params = ObjectUtils.asMap("public_id", avatarNameOnCloud, "overwrite", true, "upload_preset", "cougarstrore");
		try {
			Object res = cloudinary.uploader().upload(registerUpRequest.getAvatar(), params);
			@SuppressWarnings("unchecked")
			String url = ((Map<String, String>) res).get("url").replace("http://res.cloudinary.com/dmjh7imwd/image/upload/", "");
			User oldUser = userService.findById(adminCreated.getId());
			oldUser.setAvatar(url);
			return ResponseEntity.ok(userService.update(oldUser));
		} catch (IOException exception) {
			return ResponseEntity.badRequest()
					.body(new MessageResponse("Có lỗi khi xử lý hình ảnh, hãy thử upload lại sau."));
		}
	}

	@PostMapping("/create-admin")
	public ResponseEntity<?> createAdmin(@RequestBody RegisterRequest registerUpRequest) {
		if (userLoginDAO.existsByEmail(registerUpRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Email already exists!"));
		}
		if (userLoginDAO.existsByPhone(registerUpRequest.getPhone())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Phone already exists!"));
		}
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
	
	@PutMapping("/update-admin-with-avatar")
	public ResponseEntity<?> updateAdminWithAvatar(@RequestBody User user) {
		User oldUser = userService.findById(user.getId());
		if (!user.getEmail().equals(oldUser.getEmail())) {
			if (userLoginDAO.existsByEmail(user.getEmail())) {
				return ResponseEntity.badRequest().body(new MessageResponse("Email already exists!"));
			}
		}
		if (!user.getPhone().equals(oldUser.getPhone())) {
			if (userLoginDAO.existsByPhone(user.getPhone())) {
				return ResponseEntity.badRequest().body(new MessageResponse("Phone already exists!"));
			}
		}
		Map<String, String> config = new HashMap<>();
		config.put("cloud_name", "dmjh7imwd");
		config.put("api_key", "778777726581776");
		config.put("api_secret", "maiZWuW_V9AF9gIfGJ7ZLHpb3z8");
		Cloudinary cloudinary = new Cloudinary(config);
		String avatarNameOnCloud = "avatar-user-id-" + user.getId();
		@SuppressWarnings("rawtypes")
		Map params = ObjectUtils.asMap("public_id", avatarNameOnCloud, "overwrite", true, "upload_preset", "cougarstrore");
		try {
			Object res = cloudinary.uploader().upload(user.getAvatar(), params);
			@SuppressWarnings("unchecked")
			String url = ((Map<String, String>) res).get("url").replace("http://res.cloudinary.com/dmjh7imwd/image/upload/", "");
			oldUser.setAvatar(url);
			String oladPass = oldUser.getPassword();
			user.setPassword(oladPass);
			return ResponseEntity.ok(userService.update(oldUser));
		} catch (IOException exception) {
			return ResponseEntity.badRequest().body(new MessageResponse("Có lỗi khi xử lý hình ảnh, hãy thử upload lại sau."));
		}
	}

	@PutMapping("/update-admin")
	public ResponseEntity<?> update(@RequestBody User user) {
		User oldUser = userService.findById(user.getId());
		if (!user.getEmail().equals(oldUser.getEmail())) {
			if (userLoginDAO.existsByEmail(user.getEmail())) {
				return ResponseEntity.badRequest().body(new MessageResponse("Email already exists!"));
			}
		}
		if (!user.getPhone().equals(oldUser.getPhone())) {
			if (userLoginDAO.existsByPhone(user.getPhone())) {
				return ResponseEntity.badRequest().body(new MessageResponse("Phone already exists!"));
			}
		}
		String oladPass = oldUser.getPassword();
		user.setPassword(oladPass);
		return ResponseEntity.ok(userService.update(user));
	}

	@PutMapping("/update")
	public User updateUserFromShop(@RequestBody User user) {
		String pass = userService.findById(user.getId()).getPassword();
		user.setPassword(pass);
		return userService.update(user);
	}
	
	@PutMapping("/updateWithAvatar")
	public ResponseEntity<?> updateAdminWithAvatarFromShop(@RequestBody User user) {
		User oldUser = userService.findById(user.getId());
		
		if (!user.getEmail().equals(oldUser.getEmail())) {
			if (userLoginDAO.existsByEmail(user.getEmail())) {
				return ResponseEntity.badRequest().body(new MessageResponse("Email already exists!"));
			}
		}
		if (!user.getPhone().equals(oldUser.getPhone())) {
			if (userLoginDAO.existsByPhone(user.getPhone())) {
				return ResponseEntity.badRequest().body(new MessageResponse("Phone already exists!"));
			}
		}
		
		
		Map<String, String> config = new HashMap<>();
		config.put("cloud_name", "dmjh7imwd");
		config.put("api_key", "778777726581776");
		config.put("api_secret", "maiZWuW_V9AF9gIfGJ7ZLHpb3z8");
		Cloudinary cloudinary = new Cloudinary(config);
		String avatarNameOnCloud = "avatar-user-id-" + user.getId();
		@SuppressWarnings("rawtypes")
		Map params = ObjectUtils.asMap("public_id", avatarNameOnCloud, "overwrite", true, "upload_preset", "cougarstrore");
		try {
			Object res = cloudinary.uploader().upload(user.getAvatar(), params);
			@SuppressWarnings("unchecked")
			String url = ((Map<String, String>) res).get("url").replace("http://res.cloudinary.com/dmjh7imwd/image/upload/", "");
			user.setAvatar(url);
			String oladPass = oldUser.getPassword();
			user.setPassword(oladPass);
			return ResponseEntity.ok(userService.update(user));
		} catch (IOException exception) {
			return ResponseEntity.badRequest().body(new MessageResponse("Có lỗi khi xử lý hình ảnh, hãy thử upload lại sau."));
		}
	}
}
