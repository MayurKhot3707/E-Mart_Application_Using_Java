package com.emart.test.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;

@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter{

	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JWTTokenHelper jwtTokenHelper;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String requestURI = request.getRequestURI();

        if (requestURI.startsWith("/public/")) {
            filterChain.doFilter(request, response);
            return;
        }
		
		
		
		//1.Get Token
		String requestToken = request.getHeader("Authorization");
		//Bearer ererter34243
		
		
		System.out.println(requestToken);
		
		String username=null;
		String token = null;
		
		if(request!=null && requestToken.startsWith("Bearer"))
		{
			token = requestToken.substring(7);
			try{
				username = this.jwtTokenHelper.getUsernameFromToken(token);
			}catch(IllegalArgumentException e)
			{
				System.out.println("Unable to get jwt token");
			}catch(ExpiredJwtException e)
			{
				System.out.println("jwt token exiperd");
			}catch(MalformedJwtException e) 
			{
				System.out.println("invalid jwt token ");
			}
			
		}
		else
		{
			System.out.println("JWT token does not begin with Bearer");
		}
		
		
		//2. Validate token
		
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
			
			if(this.jwtTokenHelper.validateToken(token,userDetails))
			{
				//we have to do now authentication
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = 
						new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				
				
			}else
			{
				System.out.println("Invaild jwt token");
			}
			
			
		}else
		{
			System.out.println("Username is null or context is not null");
		}
		
		//3. filter 
		filterChain.doFilter(request, response);
		
		
	}

}
