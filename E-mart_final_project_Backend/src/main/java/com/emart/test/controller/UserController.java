package com.emart.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emart.test.dto.UserDTO;
import com.emart.test.service.UserService;

@RestController
@RequestMapping("/public/api/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@GetMapping("/")
	public ResponseEntity<List<UserDTO>> getAllUsers()
	{
		List<UserDTO> usersList = this.userService.getAllUsers();
		return ResponseEntity.ok(usersList);
	}
	
	@PostMapping("/")
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userdto)
	{
		UserDTO dto = this.userService.createUser(userdto);
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping("/{username}")
	public ResponseEntity<UserDTO> getSingleUser(@PathVariable String username)
	{
		return ResponseEntity.ok(this.userService.getUserById(username));
	}
	
}
