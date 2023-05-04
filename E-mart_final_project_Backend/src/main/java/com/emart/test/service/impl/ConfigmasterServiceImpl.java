package com.emart.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emart.test.entity.Configmaster;
import com.emart.test.exception.ResourceNotFoundException;
import com.emart.test.repository.ConfigmasterRepository;
import com.emart.test.service.ConfigmasterService;

@Service
public class ConfigmasterServiceImpl implements ConfigmasterService {

	@Autowired
	private ConfigmasterRepository configmasterRepository;
	
	@Override
	public Configmaster createConfigmaster(Configmaster configmaster) {
		
		return this.configmasterRepository.save(configmaster);
	}

	@Override
	public Configmaster updateConfigmaster(Configmaster configmaster, Integer configmasterId) {
		Configmaster configmaster1 = this.configmasterRepository.findById(configmasterId)
				.orElseThrow(()->new ResourceNotFoundException("Configmaster","confimastergId",configmasterId));
		configmaster1.setConfigname(configmaster.getConfigname());
		return configmaster1;
	}

	@Override
	public Configmaster getConfigmasterById(Integer configmasterId) {
		Configmaster configmaster1 = this.configmasterRepository.findById(configmasterId)
				.orElseThrow(()->new ResourceNotFoundException("Configmaster","confimastergId",configmasterId));
		return configmaster1;
	}

	@Override
	public List<Configmaster> getAllConfigmasters() {
		List<Configmaster> configmasterList = this.configmasterRepository.findAll();
		return configmasterList;
	}

	@Override
	public void deleteConfigmaster(Integer configmasterId) {
		Configmaster configmaster1 = this.configmasterRepository.findById(configmasterId)
				.orElseThrow(()->new ResourceNotFoundException("Configmaster","confimastergId",configmasterId));
		this.configmasterRepository.delete(configmaster1);
	}

}
