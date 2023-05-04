package com.emart.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.emart.test.entity.Catmaster;

public interface CatmasterRepository extends JpaRepository<Catmaster,Integer>{
	
	@Query(value="select * from catmaster where subcatid is null", nativeQuery= true)
	List<Catmaster> majorCategories();
	
	@Query(value="select c.*,p.price from catmaster c join productmaster p on c.productid=p.productid where c.flag='dod'",nativeQuery=true)
	List<Object[]> dodProducts();
	
	@Query(value="select c.*,p.price from catmaster c join productmaster p on c.productid=p.productid where c.flag='tsp'",nativeQuery=true)
	List<Object[]> tspProducts();
	
	@Query(value="select * from catmaster where subcatid= :id",nativeQuery=true)
	List<Object[]> subCategories(@Param(value = "id") String id);
	
	@Query(value="select c.*,p.price from catmaster c join productmaster p on c.productid=p.productid where c.subcatid= :id",nativeQuery=true)
	List<Object[]> getProducts(@Param(value = "id") String id);

}
