package com.cougar.restController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
import com.cougar.payload.request.EmailRequest;
import com.cougar.payload.request.LoginRequest;
import com.cougar.payload.response.JwtResponseDto;
import com.cougar.entity.ResetPasswordToken;
import com.cougar.entity.Review;
import com.cougar.entity.RoleRegister;
import com.cougar.payload.request.RegisterRequest;
import com.cougar.payload.request.ResetPasswordRequest;
import com.cougar.payload.response.MessageResponse;
import com.cougar.payload.response.UserInfo;
import com.cougar.repository.RoleRegisterDAO;
import com.cougar.repository.UserLoginDAO;
import com.cougar.security.jwt.JwtUtils;
import com.cougar.service.ProductItemService;
import com.cougar.service.ResetPasswordTokenService;
import com.cougar.service.ReviewService;
import com.cougar.service.UserLoginService;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserLoginDAO userLoginDAO;
	
	@Autowired
	UserLoginService userLoginService;

	@Autowired
	RoleRegisterDAO roleRegisterDAO;
	
	@Autowired
	PasswordEncoder pe;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	ProductItemService productItemService;
	
	@Autowired
	ReviewService reviewService;
	
	@Autowired
	ResetPasswordTokenService resetPasswordTokenService;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
		
		try {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			String jwt = jwtUtils.generateAccessToken(authentication);
			UserLogin userDetails = (UserLogin) authentication.getPrincipal();
			UserInfo userInfo = new UserInfo(
					userDetails.getId(),
					userDetails.getFullname(),
					userDetails.getEmail(),
					userDetails.getPhone(),
					userDetails.getAvatar(),
					userDetails.getAuthorities()
					);
	        Map<String, Object> response = new HashMap<>();
	        response.put("SHARE_USER", userInfo);
	        response.put("accessToken", new JwtResponseDto(jwt));			
			return ResponseEntity.ok(response);
		} catch (BadCredentialsException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new MessageResponse("Incorrect email or password"));
		} catch (Exception e) {
			e.printStackTrace();
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
	public ResponseEntity<?> doChangePassword(@RequestBody ChangePasswordRequest changePasswordRequest) {
	    try {
	        UserLogin user = userLoginService.findByEmail(changePasswordRequest.getEmail());
	        if (user!=null) {
	            if (pe.matches(changePasswordRequest.getCurrentPassword(), user.getPassword())) {
	                String encodedNewPassword = pe.encode(changePasswordRequest.getNewPassword());
	                user.setPassword(encodedNewPassword);
	                userLoginDAO.save(user);
	                return ResponseEntity.ok(new MessageResponse("Password updated successfully!"));
	            } else {
	                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageResponse("Incorrect old password"));
	            }
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageResponse("User not found"));
	        }
	    } catch (ExpiredJwtException e) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new MessageResponse("Token has expired"));
	    } catch (UnsupportedJwtException e) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new MessageResponse("Token is not supported"));
	    } catch (MalformedJwtException e) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new MessageResponse("Token is invalid"));
	    } catch (SignatureException e) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new MessageResponse("Token signature is invalid"));
	    } catch (UsernameNotFoundException e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageResponse("User not found"));
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageResponse("Internal server error"));
	    }
	}
	
	@PostMapping("/forgot-password")
    public ResponseEntity<?> forgotPassword(@RequestBody EmailRequest email) {
 
        UserLogin user = userLoginService.findByEmail(email.getEmail()); 
        if (user == null) {
            return ResponseEntity.badRequest().body(new MessageResponse("No users found with this email address"));
        } 
        String token = UUID.randomUUID().toString();
        resetPasswordTokenService.createResetPasswordTokenForUser(user, token);
 
        String resetPasswordLink = "http://localhost:3000/reset-password?token=" + token;
        String subject = "Reset Password";
        String text = "Click the following link to reset your password: (Valid for 5 minutes) \n " + resetPasswordLink;
 
        userLoginService.sendEmail(user.getEmail(), subject, text); 
        return ResponseEntity.ok().body(new MessageResponse("Check your email!"));
    }
	
	@PostMapping("reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody ResetPasswordRequest req) {
        ResetPasswordToken resetPasswordToken = resetPasswordTokenService.getResetPasswordToken(req.getToken());
       if (resetPasswordToken == null) {
        return ResponseEntity.badRequest().body(new MessageResponse("Invalid token"));
    } else if (resetPasswordToken.isExpired()) {
        return ResponseEntity.badRequest().body(new MessageResponse("Token has expired"));
    }
        UserLogin userLogin = resetPasswordToken.getUserLogin();
        userLogin.setPassword(pe.encode(req.getPassword()));
        userLoginService.save(userLogin); 
        return ResponseEntity.ok().body(new MessageResponse("Your password has been reset successfully"));
    }
	
	@PostMapping("/review")
	public Review createReview(@RequestBody Review review) {
	  return reviewService.save(review);
	}

}
