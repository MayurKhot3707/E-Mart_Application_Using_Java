package com.emart.test.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emart.test.dto.ProductDetailsDTO;
import com.emart.test.dto.ProductmasterDTO;
import com.emart.test.entity.Productmaster;
import com.emart.test.exception.ResourceNotFoundException;
import com.emart.test.repository.ProductmasterRepository;
import com.emart.test.service.ProductmasterService;;

@Service
public class ProductmasterServiceImpl implements ProductmasterService {
	
	@Autowired
	private ProductmasterRepository productMasterRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ProductmasterDTO createProductmaster(ProductmasterDTO productdto) {
		Productmaster productmaster = this.dtoToProductmaster(productdto);
		Productmaster savedproductmaster = this.productMasterRepository.save(productmaster);
		return this.productmasterToDto(savedproductmaster);
	}

	@Override
	public ProductmasterDTO updateProductmaster(ProductmasterDTO productdto, Integer productId) {
		Productmaster productmaster = this.productMasterRepository.findById(productId)
				.orElseThrow(()->new ResourceNotFoundException("Productmaster","ProductId",productId));
		productmaster.setPrice(productdto.getPrice());
		productmaster.setDiscount(productdto.getDiscount());
		productmaster.setCardholderprice(productdto.getCardholderprice());
		productmaster.setPointredm(productdto.getPointredm());
		
		Productmaster updatedproductmaster = this.productMasterRepository.save(productmaster);
		
		return this.productmasterToDto(updatedproductmaster);
	}

	@Override
	public ProductmasterDTO getProductmasterById(Integer productId) {
		Productmaster productmaster = this.productMasterRepository.findById(productId)
				.orElseThrow(()->new ResourceNotFoundException("Productmaster","ProductId",productId));
		return this.productmasterToDto(productmaster);
	}

	@Override
	public List<ProductmasterDTO> getAllProductmasters() {
		List<Productmaster> allproductmasters = this.productMasterRepository.findAll();
		List<ProductmasterDTO> allproductmasterdtos = allproductmasters.stream()
				.map(productmaster->this.productmasterToDto(productmaster))
				.collect(Collectors.toList());
		return allproductmasterdtos;
	}

	@Override
	public void deleteProductmaster(Integer productId) {
		Productmaster productmaster = this.productMasterRepository.findById(productId)
				.orElseThrow(()->new ResourceNotFoundException("Productmaster","ProductId",productId));
		this.productMasterRepository.delete(productmaster);
	}
	
	public Productmaster dtoToProductmaster(ProductmasterDTO product)
	{
		Productmaster productmaster = this.modelMapper.map(product, Productmaster.class);
		return productmaster;
	}
	
	public ProductmasterDTO productmasterToDto(Productmaster product)
	{
		ProductmasterDTO dto = this.modelMapper.map(product, ProductmasterDTO.class);
		return dto;
	}

	@Override
	public List<ProductDetailsDTO> getProductWithDetails(Integer productId) {
		List<Object[]> productlistwithconfig = this.productMasterRepository.getProductWithDetails(productId);
		List<ProductDetailsDTO> productList = new ArrayList<>();
	    for (Object[] row : productlistwithconfig) {
	    	ProductDetailsDTO productDTO = new ProductDetailsDTO();
	        productDTO.setProductid((Integer) row[0]);
	        productDTO.setCardholderprice((Double) row[1]);
	        productDTO.setDiscount((Float) row[2]);
	        productDTO.setPointredm((Integer) row[3]);
	        productDTO.setPrice((Double) row[4]);
	        productDTO.setProductimagpath((String) row[5]);
	        productDTO.setProductshortdesc((String) row[6]);
	        productDTO.setProductlongdesc((String) row[7]);
	        productDTO.setProductname((String) row[8]);
	        productDTO.setConfigdtl((String) row[9]);
	        productDTO.setConfigid((Integer) row[10]);
	        productDTO.setConfigname((String) row[11]);
	        productList.add(productDTO);
	    }
		
		return productList;
	}

}
