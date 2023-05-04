package com.emart.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.emart.test.dto.ProductDetailsDTO;
import com.emart.test.entity.Productmaster;

public interface ProductmasterRepository extends JpaRepository<Productmaster,Integer>{

	
	@Query(nativeQuery = true,value ="SELECT p.productid, p.cardholderprice, p.discount, p.pointredm, p.price, p.productimagpath, p.productshortdesc, p.productlongdesc, p.productname, pt.configdtl, ct.configid, ct.configname FROM productmaster p INNER JOIN productdtlmaster pt ON p.productid = pt.productid INNER JOIN configmaster ct ON pt.configid = ct.configid WHERE p.productid = :productId")
	List<Object[]> getProductWithDetails(@Param("productId") Integer productId);


}
