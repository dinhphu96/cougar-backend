package com.cougar.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.cougar.entity.UserLogin;
import com.cougar.security.UserDetailsServiceImpl;



public class AuthTokenFilter extends OncePerRequestFilter {
  @Autowired
  private JwtUtils jwtUtils;

  @Autowired
  private UserDetailsServiceImpl userDetailsService;

  private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    try {
      String jwt = getToken(request);
      if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
        String email = jwtUtils.getUserEmailFromJwtRefreshToken(jwt);

        UserLogin userDetails = userDetailsService.loadUserByUsername(email);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null,
            userDetails.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        SecurityContextHolder.getContext().setAuthentication(authentication);
      }
    } catch (Exception e) {
      logger.error("Cannot set user authentication: {}", e);
    }
    filterChain.doFilter(request, response);
  }

//  private String parseJwt(HttpServletRequest request) {
//    String headerAuth = request.getHeader("Authorization");
//
//    if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
//      return headerAuth.substring(7, headerAuth.length());
//    }
//
//    return null;
//  }
  
  public String getToken( HttpServletRequest request ) {
      
      String authHeader = getAuthHeaderFromHeader( request );
      if ( authHeader != null && authHeader.startsWith("Bearer ")) {
          return authHeader.substring(7);
      }

      return null;
  }

	public String getAuthHeaderFromHeader( HttpServletRequest request ) {
      return request.getHeader("Authorization");
  }
}