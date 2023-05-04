package com.emart.test.service;

import java.util.List;

import com.emart.test.dto.UserDTO;

public interface UserService {

	UserDTO createUser(UserDTO userdto);
	
	UserDTO updateUser(UserDTO userdto, String userId);
	
	UserDTO getUserById(String userId);
	
	List<UserDTO> getAllUsers();
	
	void deleteUser(String userId);
	
}
