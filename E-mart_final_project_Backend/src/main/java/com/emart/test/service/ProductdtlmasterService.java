package com.emart.test.service;

import java.util.List;

import com.emart.test.entity.Productdtlmaster;

public interface ProductdtlmasterService {

	Productdtlmaster createProductdtlmaster(Productdtlmaster productdtl);
	
	Productdtlmaster updateProductdtlmaster(Productdtlmaster productdtl, Integer productdtlId);
	
	Productdtlmaster getProductdtlmasterById(Integer productdtlId);
	
	List<Productdtlmaster> getAllProductdtlmasters();
	
	void deleteProductmaster(Integer productdtlId);
	
}
