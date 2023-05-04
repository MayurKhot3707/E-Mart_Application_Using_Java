package com.emart.test.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DODProductsDTO {
	
	private Integer catmasterid;
	
	private String catid;
	
	private String catimagepath;
	
	private String subcatid;
	
	private String catname;
	
	private String flag;
	
	private Integer productid;
	
//	@Column(nullable=true)
//	private Integer productmaster_productid;
	
	private double price;

public DODProductsDTO(Integer catmasterid, String catid, String catimagepath, String subcatid, String catname,
		String flag, Integer productid, double price) {
	super();
	this.catmasterid = catmasterid;
	this.catid = catid;
	this.catimagepath = catimagepath;
	this.subcatid = subcatid;
	this.catname = catname;
	this.flag = flag;
	this.productid = productid;
	this.price = price;
}

public DODProductsDTO() {
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

public String getCatimagepath() {
	return catimagepath;
}

public void setCatimagepath(String catimagepath) {
	this.catimagepath = catimagepath;
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

public String getFlag() {
	return flag;
}

public void setFlag(String flag) {
	this.flag = flag;
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
	
	

}
