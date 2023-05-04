package com.emart.test.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emart.test.dto.DODProductsDTO;
import com.emart.test.dto.TSPProductsDTO;
import com.emart.test.entity.Catmaster;
import com.emart.test.exception.ResourceNotFoundException;
import com.emart.test.repository.CatmasterRepository;
import com.emart.test.service.CatmasterService;

@Service
public class CatmasterServiceImpl implements CatmasterService {

	@Autowired
	private CatmasterRepository catmasterRepository;
	
	@Override
	public Catmaster createCatmaster(Catmaster catmaster) {
		
		return this.catmasterRepository.save(catmaster);
	}

	@Override
	public Catmaster updateCatmaster(Catmaster catmaster, Integer catmasterId) {
		Catmaster catmaster1 = this.catmasterRepository.findById(catmasterId)
				.orElseThrow(()-> new ResourceNotFoundException("Catmaster","catmasterId",catmasterId));
		catmaster1.setCatimagpath(catmaster.getCatimagpath());
		catmaster1.setFlag(catmaster.getFlag());
		catmaster1.setCatname(catmaster.getCatname());
		return catmaster1;
	}

	@Override
	public Catmaster getCatmasterById(Integer catmasterId) {
		Catmaster catmaster = this.catmasterRepository.findById(catmasterId)
				.orElseThrow(()->new ResourceNotFoundException("Catmaster","catmasterId",catmasterId));
		return catmaster;
	}

	@Override
	public List<Catmaster> getAllCatmasters() {
		List<Catmaster> catmastersList= this.catmasterRepository.findAll();
		return catmastersList;
	}

	@Override
	public void deleteCatmaster(Integer catmasterId) {
		Catmaster catmaster = this.catmasterRepository.findById(catmasterId)
				.orElseThrow(()->new ResourceNotFoundException("Catmaster","catmasterId",catmasterId));
		this.catmasterRepository.delete(catmaster);
	}

	@Override
	public List<Catmaster> getAllMajorCategories() {
		List<Catmaster> list = this.catmasterRepository.majorCategories();
		return list;
	}

	@Override
	public List<DODProductsDTO> getAllDodProducts() {
		List<Object[]> objlist = this.catmasterRepository.dodProducts();
		
		List<DODProductsDTO> dtolist = new ArrayList<>();
		
		for(Object[] row : objlist)
		{
			DODProductsDTO dto = new DODProductsDTO();
			dto.setCatmasterid((Integer)row[0]);
			dto.setCatid((String) row[1]);
			dto.setCatimagepath((String) row[2]);
			dto.setCatname((String) row[3]);
			dto.setFlag((String) row[4]);
			dto.setProductid((Integer) row[5]);
			dto.setSubcatid((String) row[6]);
//			dto.setProductmaster_productid((Integer) row[7]);
			dto.setPrice((Double) row [8]);
			
			dtolist.add(dto);
		}
		
		return dtolist;
	}

	@Override
	public List<TSPProductsDTO> getAllTSPProducts() {
		
		List<Object[]> objlist=this.catmasterRepository.tspProducts();
		
		List<TSPProductsDTO> tspdtolist=new ArrayList<>();
		
		for(Object[] row : objlist ){
			TSPProductsDTO dto=new TSPProductsDTO();
			
			dto.setCatmasterid((Integer)row[0]);
			dto.setCatid((String) row[1]);
			dto.setCatimagepath((String) row[2]);
			dto.setCatname((String) row[3]);
			dto.setFlag((String) row[4]);
			dto.setProductid((Integer) row[5]);
			dto.setSubcatid((String) row[6]);
//			dto.setProductmaster_productid((Integer) row[7]);
			dto.setPrice((Double) row [8]);
			
			tspdtolist.add(dto);
		
		}
		
		return tspdtolist;
	}

	@Override
	public List<DODProductsDTO> getSuborProducts(Integer id) {
		Catmaster catmaster = this.catmasterRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Catmaster","catmasterid",id));
		System.out.println(catmaster.getCatid());
		if(catmaster.getSubcatid()==null && (catmaster.getFlag().equals("M")|| catmaster.getFlag().equals("S")))
		{
			List<Object[]> objlist = this.catmasterRepository.subCategories(catmaster.getCatid());
			List<DODProductsDTO> dtolist = new ArrayList<>();
			
			for(Object[] row : objlist)
			{
				DODProductsDTO dto = new DODProductsDTO();
				dto.setCatmasterid((Integer)row[0]);
				dto.setCatid((String) row[1]);
				dto.setCatimagepath((String) row[2]);
				dto.setCatname((String) row[3]);
				dto.setFlag((String) row[4]);
				dto.setProductid((Integer) row[5]);
				dto.setSubcatid((String) row[6]);
				
				dtolist.add(dto);
			}
			return dtolist;
		}
		else
		{
			List<Object[]> objlist=this.catmasterRepository.getProducts(catmaster.getCatid());
			
			List<DODProductsDTO> dtolist = new ArrayList<>();
			
			for(Object[] row : objlist)
			{
				DODProductsDTO dto = new DODProductsDTO();
				dto.setCatmasterid((Integer)row[0]);
				dto.setCatid((String) row[1]);
				dto.setCatimagepath((String) row[2]);
				dto.setCatname((String) row[3]);
				dto.setFlag((String) row[4]);
				dto.setProductid((Integer) row[5]);
				dto.setSubcatid((String) row[6]);
				dto.setPrice((Double) row [8]);
				
				dtolist.add(dto);
			}
			return dtolist;
		}
	}


}
