package com.emart.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emart.test.dto.ProductDetailsDTO;
import com.emart.test.dto.ProductmasterDTO;
import com.emart.test.service.ProductmasterService;


@RestController
@RequestMapping("/public/api/productmaster")
@CrossOrigin("http://localhost:3000")
public class ProductmasterController {

	@Autowired
	private ProductmasterService productMasterService;
	
	@GetMapping("/")
	public List<ProductmasterDTO> getAllProductmasters()
	{
		return this.productMasterService.getAllProductmasters();
	}
	
	@GetMapping("/product/{productId}")
	public ResponseEntity<ProductmasterDTO> getSingleProductmaster(@PathVariable Integer productId) {
	    return ResponseEntity.ok(this.productMasterService.getProductmasterById(productId));
	}
	
	@GetMapping("/productdesc/{productId}")
	public ResponseEntity<List<ProductDetailsDTO>> getProductWithDetails(@PathVariable Integer productId) {
	    List<ProductDetailsDTO> productDetails = productMasterService.getProductWithDetails(productId);
	    return ResponseEntity.ok(productDetails);
	}


}
