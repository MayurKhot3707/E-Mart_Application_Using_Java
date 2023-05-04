package com.emart.test.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.emart.test.entity.User;
import com.emart.test.exception.UserNotFoundException;
import com.emart.test.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// loading user from database
		User user = this.userRepository.findById(username)
		.orElseThrow(()->new UserNotFoundException("Username","Username",username));
		
		return user;
	}

}
