package com.cougar.security.jwt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.cougar.entity.UserLogin;
import com.cougar.security.SecurityConstants;
import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.TextCodec;

@Component
public class JwtUtils {
	private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
	static final String issuer = "fpt-polytechnic-college";
	static final String audiencer = "cougars-team";

	public String generateAccessToken(Authentication authentication) {

		UserLogin userPrincipal = (UserLogin) authentication.getPrincipal();
		List<String> roles = userPrincipal.getAuthorities().stream()
	            .map(GrantedAuthority::getAuthority)
	            .collect(Collectors.toList());
		List<String> permissions = new ArrayList<>();
	    if (roles.contains("ADMIN")) {
	        permissions.addAll(Arrays.asList("create", "read", "update", "delete"));
	    }
	    if (roles.contains("USER")) {
	        permissions.addAll(Arrays.asList("read", "update"));
	    }
		JwtBuilder jwtBuilder = Jwts.builder()
				.setSubject(userPrincipal.getEmail())
				.claim("scope", roles)
				.claim("permissions", permissions)
				.setIssuedAt(new Date())
				.setExpiration(new Date((new Date()).getTime() + SecurityConstants.JWT_EXPIRATION))
				.setIssuer(issuer)
				.setAudience(audiencer)
				.signWith(SignatureAlgorithm.HS256,
						TextCodec.BASE64.decode("Yn2kjibddFAWtnPJ2AFlL8WXmohJMCvigQggaEypa5E="));	
	   
		 return jwtBuilder.compact();
	}

	public String getUserEmailFromJwtRefreshToken(String token) {
		return Jwts.parser().setSigningKey(SecurityConstants.JWT_SECRET).parseClaimsJws(token).getBody().getSubject();
	}

	public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(SecurityConstants.JWT_SECRET).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException e) {
			logger.error("Invalid JWT signature: {}", e.getMessage());
		} catch (MalformedJwtException e) {
			logger.error("Invalid JWT token: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			logger.error("JWT token is expired: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			logger.error("JWT token is unsupported: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			logger.error("JWT claims string is empty: {}", e.getMessage());
		}

		return false;
	}
}