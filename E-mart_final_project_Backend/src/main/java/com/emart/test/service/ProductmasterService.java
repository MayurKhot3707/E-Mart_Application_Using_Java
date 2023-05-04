package com.emart.test.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.emart.test.dto.ProductDetailsDTO;
import com.emart.test.dto.ProductmasterDTO;


public interface ProductmasterService {
	
	ProductmasterDTO createProductmaster(ProductmasterDTO productdto);
	
	ProductmasterDTO updateProductmaster(ProductmasterDTO productdto, Integer productId);
	
	ProductmasterDTO getProductmasterById(Integer productId);
	
	List<ProductmasterDTO> getAllProductmasters();
	
	void deleteProductmaster(Integer productId);
	
	List<ProductDetailsDTO> getProductWithDetails(@Param("productId") Integer productId);

}
