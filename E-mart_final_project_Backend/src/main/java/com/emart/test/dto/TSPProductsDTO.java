package com.emart.test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TSPProductsDTO {
	
	private Integer catmasterid;
	
	private String catid;
	
	private String subcatid;
	
	private String catname;
	
	private String catimagepath;
	
	private Integer productid;
	
	private double price;
	
	private String flag;

	public TSPProductsDTO(Integer catmasterid, String catid, String subcatid, String catname, String catimagepath,
			Integer productid, double price, String flag) {
		super();
		this.catmasterid = catmasterid;
		this.catid = catid;
		this.subcatid = subcatid;
		this.catname = catname;
		this.catimagepath = catimagepath;
		this.productid = productid;
		this.price = price;
		this.flag = flag;
	}

	public TSPProductsDTO() {
		super();
	}

	public Integer getCatmasterid() {
		return catmasterid;
	}

	public void setCatmasterid(Integer catmasterid) {
		this.catmasterid = catmasterid;
	}

	public String getCatid() {
		return catid;
	}

	public void setCatid(String catid) {
		this.catid = catid;
	}

	public String getSubcatid() {
		return subcatid;
	}

	public void setSubcatid(String subcatid) {
		this.subcatid = subcatid;
	}

	public String getCatname() {
		return catname;
	}

	public void setCatname(String catname) {
		this.catname = catname;
	}

	public String getCatimagepath() {
		return catimagepath;
	}

	public void setCatimagepath(String catimagepath) {
		this.catimagepath = catimagepath;
	}

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	
	

}
