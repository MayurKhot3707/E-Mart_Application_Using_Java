package com.emart.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emart.test.dto.DODProductsDTO;
import com.emart.test.dto.TSPProductsDTO;
import com.emart.test.entity.Catmaster;
import com.emart.test.service.CatmasterService;

@RestController
@RequestMapping("/public/api/catmaster")
@CrossOrigin("http://localhost:3000")
public class CatmasterController {

	@Autowired
	private CatmasterService catmasterService;
	
	@GetMapping("/")
	public List<Catmaster> getAllCatmaster()
	{
		return this.catmasterService.getAllCatmasters();
	}
	
	@GetMapping("/{catmasterId}")
	public Catmaster getSingleCatmaster(@PathVariable Integer catmasterId)
	{
		return this.catmasterService.getCatmasterById(catmasterId);
	}
	
	@PostMapping("/")
	public Catmaster createCatmaster(@RequestBody Catmaster catmaster)
	{
		return this.catmasterService.createCatmaster(catmaster);
	}
	
	@GetMapping("/major")
	public List<Catmaster> getAllMajorCategories()
	{
		return this.catmasterService.getAllMajorCategories();
	}
	
	@GetMapping("/dod")
	public List<DODProductsDTO> getAllDodProducts()
	{
		return this.catmasterService.getAllDodProducts();
	}
	
	@GetMapping("/tsp")
	public List<TSPProductsDTO> getAllTSPProductsDTO()
	{
		return this.catmasterService.getAllTSPProducts();
	}
	
	@GetMapping("/suborproduct/{id}")
	public List<DODProductsDTO> getSubOrProducts(@PathVariable Integer id)
	{
		return this.catmasterService.getSuborProducts(id);
	}
	
}
