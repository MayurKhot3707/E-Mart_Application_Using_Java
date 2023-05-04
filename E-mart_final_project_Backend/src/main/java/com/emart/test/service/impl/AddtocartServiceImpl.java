package com.emart.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emart.test.entity.Addtocart;
import com.emart.test.exception.ResourceNotFoundException;
import com.emart.test.repository.AddtocartRepository;
import com.emart.test.service.AddtocartService;

@Service
public class AddtocartServiceImpl implements AddtocartService {

	@Autowired
	private AddtocartRepository addtocartRepository;
	
	@Override
	public Addtocart createAddtocart(Addtocart addtocart) {
		
		return this.addtocartRepository.save(addtocart);
	}

	@Override
	public Addtocart updateAddtocart(Addtocart addtocart, Integer addtocartId) {
		Addtocart addtocart1 = this.addtocartRepository.findById(addtocartId)
				.orElseThrow(()-> new ResourceNotFoundException("Addtocart","addtocartId",addtocartId));
		addtocart1.setPrice(addtocart.getPrice());
		addtocart1.setPointredm(addtocart.getPointredm());
		addtocart1.setCardholderprice(addtocart.getCardholderprice());
		return addtocart1;
	}

	@Override
	public Addtocart getAddtocartById(Integer addtocartId) {
		Addtocart addtocart1 = this.addtocartRepository.findById(addtocartId)
				.orElseThrow(()-> new ResourceNotFoundException("Addtocart","addtocartId",addtocartId));
		return addtocart1;
	}

	@Override
	public List<Addtocart> getAllAddtocarts() {
		List<Addtocart> addtocartList = this.addtocartRepository.findAll();
		return addtocartList;
	}

	@Override
	public void deleteAddtocart(Integer addtocartId) {
		Addtocart addtocart1 = this.addtocartRepository.findById(addtocartId)
				.orElseThrow(()-> new ResourceNotFoundException("Addtocart","addtocartId",addtocartId));
		this.addtocartRepository.delete(addtocart1);

	}

}
