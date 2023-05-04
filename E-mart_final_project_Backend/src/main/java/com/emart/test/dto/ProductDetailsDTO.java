package com.emart.test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailsDTO {
	private Integer productid;
    private Double cardholderprice;
    private Float discount;
    private Integer pointredm;
    private Double price;
    private String productimagpath;
    private String productshortdesc;
    private String productlongdesc;
    private String productname;
    private String configdtl;
    private Integer configid;
    private String configname;
	public ProductDetailsDTO(Integer productid, Double cardholderprice, Float discount, Integer pointredm, Double price,
			String productimagpath, String productshortdesc, String productlongdesc, String productname,
			String configdtl, Integer configid, String configname) {
		super();
		this.productid = productid;
		this.cardholderprice = cardholderprice;
		this.discount = discount;
		this.pointredm = pointredm;
		this.price = price;
		this.productimagpath = productimagpath;
		this.productshortdesc = productshortdesc;
		this.productlongdesc = productlongdesc;
		this.productname = productname;
		this.configdtl = configdtl;
		this.configid = configid;
		this.configname = configname;
	}
	public ProductDetailsDTO() {
		super();
	}
	public Integer getProductid() {
		return productid;
	}
	public void setProductid(Integer productid) {
		this.productid = productid;
	}
	public Double getCardholderprice() {
		return cardholderprice;
	}
	public void setCardholderprice(Double cardholderprice) {
		this.cardholderprice = cardholderprice;
	}
	public Float getDiscount() {
		return discount;
	}
	public void setDiscount(Float discount) {
		this.discount = discount;
	}
	public Integer getPointredm() {
		return pointredm;
	}
	public void setPointredm(Integer pointredm) {
		this.pointredm = pointredm;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getProductimagpath() {
		return productimagpath;
	}
	public void setProductimagpath(String productimagpath) {
		this.productimagpath = productimagpath;
	}
	public String getProductshortdesc() {
		return productshortdesc;
	}
	public void setProductshortdesc(String productshortdesc) {
		this.productshortdesc = productshortdesc;
	}
	public String getProductlongdesc() {
		return productlongdesc;
	}
	public void setProductlongdesc(String productlongdesc) {
		this.productlongdesc = productlongdesc;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getConfigdtl() {
		return configdtl;
	}
	public void setConfigdtl(String configdtl) {
		this.configdtl = configdtl;
	}
	public Integer getConfigid() {
		return configid;
	}
	public void setConfigid(Integer configid) {
		this.configid = configid;
	}
	public String getConfigname() {
		return configname;
	}
	public void setConfigname(String configname) {
		this.configname = configname;
	}
    
    
}
