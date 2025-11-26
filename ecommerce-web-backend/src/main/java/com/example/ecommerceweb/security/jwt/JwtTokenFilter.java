package com.example.ecommerceweb.security.jwt;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.ecommerceweb.security.service.UserDetailsServiceImpl;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {

	private JwtUtils jwtUtils;
	private UserDetailsServiceImpl userDetailsServiceImpl;

	public JwtTokenFilter(JwtUtils jwtUtils, UserDetailsServiceImpl userDetailsServiceImpl) {
		this.jwtUtils = jwtUtils;
		this.userDetailsServiceImpl = userDetailsServiceImpl;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String jwt = getJwt(request);

		if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
			String username = jwtUtils.getUsernameFromJwt(jwt);
			UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(username);
			UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null,
					userDetails.getAuthorities());
			authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(authToken);
		}

		filterChain.doFilter(request, response);
	}

	private String getJwt(HttpServletRequest request) {
		String authHeader = request.getHeader("Authorization");

		if (authHeader != null && authHeader.startsWith("Bearer ")) {
			return authHeader.substring(7);
		}

		return null;
	}

}
