package com.emart.test.service;

import java.util.List;

import com.emart.test.dto.DODProductsDTO;
import com.emart.test.dto.TSPProductsDTO;
import com.emart.test.entity.Catmaster;

public interface CatmasterService {

	Catmaster createCatmaster(Catmaster catmaster);
	
	Catmaster updateCatmaster(Catmaster catmaster, Integer catmasterId);
	
	Catmaster getCatmasterById(Integer catmasterId);
	
	List<Catmaster> getAllCatmasters();
	
	void deleteCatmaster(Integer catmasterId);
	
	List<Catmaster> getAllMajorCategories();
	
	List<DODProductsDTO> getAllDodProducts();
	
	List<TSPProductsDTO> getAllTSPProducts();
	
	List<DODProductsDTO> getSuborProducts(Integer id);
	
}
