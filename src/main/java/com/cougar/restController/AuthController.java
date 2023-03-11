package com.cougar.restController;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cougar.entity.UserLogin;
import com.cougar.payload.request.ChangePasswordRequest;
import com.cougar.payload.request.LoginRequest;
import com.cougar.payload.response.JwtResponse;
import com.cougar.entity.RoleRegister;
import com.cougar.payload.request.RegisterRequest;
import com.cougar.payload.response.MessageResponse;
import com.cougar.repository.RoleRegisterDAO;
import com.cougar.repository.UserLoginDAO;
import com.cougar.security.UserDetailsImpl;
import com.cougar.security.UserDetailsServiceImpl;
import com.cougar.security.jwt.JwtUtils;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserLoginDAO userLoginDAO;

	@Autowired
	RoleRegisterDAO roleRegisterDAO;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	PasswordEncoder pe;
	
	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
		try {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

			SecurityContextHolder.getContext().setAuthentication(authentication);
			String jwt = jwtUtils.generateJwtToken(authentication);

			UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
			List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
					.collect(Collectors.toList());
			System.out.println(userDetails);
			return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getFullname(),
					userDetails.getEmail(), userDetails.getAvatar(), roles));
		} catch (BadCredentialsException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new MessageResponse("Incorrect email or password"));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected error occurred");
		}
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerUpRequest) {
		if (userLoginDAO.existsByEmail(registerUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already taken!"));
		}

		if (userLoginDAO.existsByPhone(registerUpRequest.getPhone())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Phone is already in use!"));
		}

		// Create new user's account
		UserLogin user = new UserLogin();
		user.setEmail(registerUpRequest.getEmail());
		user.setPassword(pe.encode(registerUpRequest.getPassword()));
		RoleRegister roles = roleRegisterDAO.findByName("USER").get();
		user.setRoles(Collections.singletonList(roles));
		user.setFullname(registerUpRequest.getFullname());	
		user.setPhone(registerUpRequest.getPhone());
		userLoginDAO.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	
	@PostMapping("/change-password")
	public ResponseEntity<?> doChangePassword(HttpServletRequest request, @RequestBody ChangePasswordRequest changePasswordRequest) {
	    HttpSession session = request.getSession();
	    String accessToken = (String) session.getAttribute("user");
//	    String email = jwtUtils.getUserNameFromJwtToken(accessToken);
	    System.out.println(accessToken);
	    return ResponseEntity.ok(new MessageResponse("Password updated successfully!" + accessToken));
//	    try {
//	        String email = jwtUtils.getUserNameFromJwtToken(token);
//	        Optional<UserLogin> user = userLoginDAO.findByEmail(email);
//	        if (user.isPresent()) {
//	            if (pe.matches(changePasswordRequest.getCurrentPassword(), user.get().getPassword())) {
//	                String encodedNewPassword = pe.encode(changePasswordRequest.getNewPassword());
//	                user.get().setPassword(encodedNewPassword);
//	                userLoginDAO.save(user.get());
//	                return ResponseEntity.ok(new MessageResponse("Password updated successfully!"));
//	            } else {
//	                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageResponse("Incorrect old password"));
//	            }
//	        } else {
//	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageResponse("User not found"));
//	        }
//	    } catch (Exception e) {
//	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new MessageResponse("Unauthorized"));
//	    }
//	    Optional<UserLogin> user = userLoginDAO.findByEmail(email);
//	    if (user.isPresent()) {
//	        if (pe.matches(changePasswordRequest.getCurrentPassword(), user.get().getPassword())) {
//	            String encodedNewPassword = pe.encode(changePasswordRequest.getNewPassword());
//	            user.get().setPassword(encodedNewPassword);
//	            userLoginDAO.save(user.get());
//	            return ResponseEntity.ok(new MessageResponse("Password updated successfully!"));
//	        } else {
//	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageResponse("Incorrect old password"));
//	        }
//	    } else {
//	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageResponse("User not found"));
//	    }
	}

}
