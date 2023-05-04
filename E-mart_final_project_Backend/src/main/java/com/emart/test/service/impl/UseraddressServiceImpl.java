package com.emart.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emart.test.entity.Useraddress;
import com.emart.test.exception.ResourceNotFoundException;
import com.emart.test.repository.UseraddressRepository;
import com.emart.test.service.UseraddressService;

@Service
public class UseraddressServiceImpl implements UseraddressService {
	
	@Autowired
	private UseraddressRepository useraddressRepository;

	@Override
	public Useraddress creatUseraddress(Useraddress useraddress) {
		
		return this.useraddressRepository.save(useraddress);
	}

	@Override
	public Useraddress updateUseraddress(Useraddress useraddress, Integer useraddressId) {
		Useraddress useraddress1 = this.useraddressRepository.findById(useraddressId)
				.orElseThrow(()->new ResourceNotFoundException("Useraddress","useraddressId",useraddressId));
		useraddress1.setAddress(useraddress.getAddress());
		return useraddress1;
	}

	@Override
	public Useraddress getUseraddressById(Integer useraddressId) {
		Useraddress useraddress1 = this.useraddressRepository.findById(useraddressId)
				.orElseThrow(()->new ResourceNotFoundException("Useraddress","useraddressId",useraddressId));
		return useraddress1;
	}

	@Override
	public List<Useraddress> getAllUseraddress() {
		List<Useraddress> useraddressList = this.useraddressRepository.findAll();
		return useraddressList;
	}

	@Override
	public void deleteUseraddress(Integer useraddressId) {
		Useraddress useraddress1 = this.useraddressRepository.findById(useraddressId)
				.orElseThrow(()->new ResourceNotFoundException("Useraddress","useraddressId",useraddressId));
		this.useraddressRepository.delete(useraddress1);

	}

}
