package com.emart.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emart.test.entity.Productdtlmaster;
import com.emart.test.exception.ResourceNotFoundException;
import com.emart.test.repository.ProductdtlmasterRepository;
import com.emart.test.service.ProductdtlmasterService;

@Service
public class ProductdtlmasterServiceImpl implements ProductdtlmasterService {

	@Autowired
	private ProductdtlmasterRepository productdtlmasterRepository;
	
	@Override
	public Productdtlmaster createProductdtlmaster(Productdtlmaster productdtl) {
		
		return this.productdtlmasterRepository.save(productdtl);
	}

	@Override
	public Productdtlmaster updateProductdtlmaster(Productdtlmaster productdtl, Integer productdtlId) {
		Productdtlmaster productdtlmaster = this.productdtlmasterRepository.findById(productdtlId)
				.orElseThrow(()->new ResourceNotFoundException("Productdtlmaster","productdtlId",productdtlId));
				
		productdtlmaster.setConfigdtl(productdtl.getConfigdtl());
		
		return productdtlmaster;
	}

	@Override
	public Productdtlmaster getProductdtlmasterById(Integer productdtlId) {
		Productdtlmaster productdtlmaster = this.productdtlmasterRepository.findById(productdtlId)
				.orElseThrow(()->new ResourceNotFoundException("Productdtlmaster","productdtlId",productdtlId));
		return productdtlmaster;
	}

	@Override
	public List<Productdtlmaster> getAllProductdtlmasters() {
		List<Productdtlmaster> productdtlmasterList = this.productdtlmasterRepository.findAll();
		return productdtlmasterList;
	}

	@Override
	public void deleteProductmaster(Integer productdtlId) {
		Productdtlmaster productdtlmaster = this.productdtlmasterRepository.findById(productdtlId)
				.orElseThrow(()->new ResourceNotFoundException("Productdtlmaster","productdtlId",productdtlId));
		this.productdtlmasterRepository.delete(productdtlmaster);
	}

}
