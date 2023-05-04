package com.emart.test.service;

import java.util.List;

import com.emart.test.entity.Configmaster;

public interface ConfigmasterService {

	Configmaster createConfigmaster(Configmaster configmaster);
	
	Configmaster updateConfigmaster(Configmaster configmaster, Integer configmasterId);
	
	Configmaster getConfigmasterById(Integer configmasterId);
	
	List<Configmaster> getAllConfigmasters();
	
	void deleteConfigmaster(Integer ConfigmasterId);
	
}
