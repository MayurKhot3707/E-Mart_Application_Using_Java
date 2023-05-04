package com.emart.test.service;

import java.util.List;

import com.emart.test.entity.Useraddress;

public interface UseraddressService {

	
	Useraddress creatUseraddress(Useraddress useraddress);
	
	Useraddress updateUseraddress(Useraddress useraddress, Integer useraddressId);
	
	Useraddress getUseraddressById(Integer useraddressId);
	
	List<Useraddress> getAllUseraddress();
	
	void deleteUseraddress(Integer useraddressid);
	
}
