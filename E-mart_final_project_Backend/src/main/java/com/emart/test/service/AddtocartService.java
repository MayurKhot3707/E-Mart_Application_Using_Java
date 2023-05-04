package com.emart.test.service;

import java.util.List;

import com.emart.test.entity.Addtocart;

public interface AddtocartService {

	Addtocart createAddtocart(Addtocart addtocart);
	
	Addtocart updateAddtocart(Addtocart addtocart, Integer addtocartId);
	
	Addtocart getAddtocartById(Integer addtocartId);
	
	List<Addtocart> getAllAddtocarts();
	
	void deleteAddtocart(Integer addtocartId);
		
	
}
