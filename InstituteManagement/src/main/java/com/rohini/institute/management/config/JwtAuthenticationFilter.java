package com.rohini.institute.management.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.rohini.institute.management.services.UserDetailsServiceImpl;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	@Autowired
	private JwtUtil jwtUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		final String requestTokenHeader = request.getHeader("Authorization");
		System.out.println("requestTokenHeader : " + requestTokenHeader);
		String username = null;
		String jwtToken = null;
		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer")) {
			System.out.println(": token start with bearer : ");
			jwtToken = requestTokenHeader.substring(7);
			System.out.println("jwtToken : " + requestTokenHeader.substring(7));
			try {
				username = this.jwtUtil.getUsernameFromToken(jwtToken);
				System.out.println("Username form token : " + username);
			} catch (ExpiredJwtException e) {
				System.out.println(e);
			} catch (Exception e) {
				System.out.println(e);
			}
		} else {
			System.out.println("Invalid token, not start with bearer");
		}

//		Validate
		System.out.println(username + "!!!!!!" + SecurityContextHolder.getContext().getAuthentication());
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			final UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
			System.out.println("--------" + userDetails);
			if (Boolean.TRUE.equals(this.jwtUtil.validateToken(jwtToken, userDetails))) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthentication = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthentication);
			}
		} else {
			System.out.println("Token is not valid");
		}
		filterChain.doFilter(request, response);

	}

}
