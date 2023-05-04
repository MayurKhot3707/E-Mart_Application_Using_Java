package com.emart.test.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.emart.test.dto.UserDTO;
import com.emart.test.entity.User;
import com.emart.test.exception.ResourceNotFoundException;
import com.emart.test.exception.UserNotFoundException;
import com.emart.test.repository.UserRepository;
import com.emart.test.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDTO createUser(UserDTO userdto) {
		userdto.setPassword(this.passwordEncoder.encode(userdto.getPassword()));
		User user = this.dtoToUser(userdto);
		User saveduser =this.userRepository.save(user);
		return this.userToDto(saveduser);
	}

	
	@Override
	public UserDTO updateUser(UserDTO userdto, String userId) {
		User user = this.userRepository.findById(userId)
				.orElseThrow(()-> new UserNotFoundException("User","userId",userId));
		
		user.setFname(userdto.getFname());
		user.setLname(userdto.getLname());
		user.setMname(userdto.getMname());
		user.setEmail(userdto.getEmail());
		user.setMobileno(userdto.getMobileno());
		user.setPassword(userdto.getPassword());
		user.setUsername(userdto.getUsername());
		
		User updatedUser = this.userRepository.save(user);
		
		return this.userToDto(updatedUser);
	}

	@Override
	public UserDTO getUserById(String userId) {
		User user = this.userRepository.findById(userId)
				.orElseThrow(()-> new UserNotFoundException("User","userId",userId));
		
		return this.userToDto(user);
	}

	@Override
	public List<UserDTO> getAllUsers() {
		List<User> userList = this.userRepository.findAll();
		List<UserDTO> userdtoList = userList.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		return userdtoList;
	}

	@Override
	public void deleteUser(String userId) {
		User user = this.userRepository.findById(userId)
				.orElseThrow(()-> new UserNotFoundException("User","userId",userId));
		this.userRepository.delete(user);
	}

	public User dtoToUser(UserDTO dto)
	{
		User user = this.modelMapper.map(dto, User.class);
		return user;
	}
	
	public UserDTO userToDto(User user)
	{
		UserDTO userdto = this.modelMapper.map(user, UserDTO.class);
		return userdto;
	}

}
