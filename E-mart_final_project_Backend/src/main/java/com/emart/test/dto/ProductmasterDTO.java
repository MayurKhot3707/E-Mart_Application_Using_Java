package com.emart.test.dto;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductmasterDTO {

	private int productid;
	private double cardholderprice;
	private float discount;
	private int pointredm;
	private double price;
	private String productimagpath;
	private String productshortdesc;
	@Column(length=100000)
	private String productlongdesc;
	private String productname;
	public ProductmasterDTO(int productid, double cardholderprice, float discount, int pointredm, double price,
			String productimagpath, String productshortdesc, String productlongdesc, String productname) {
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
	}
	public ProductmasterDTO() {
		super();
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public double getCardholderprice() {
		return cardholderprice;
	}
	public void setCardholderprice(double cardholderprice) {
		this.cardholderprice = cardholderprice;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public int getPointredm() {
		return pointredm;
	}
	public void setPointredm(int pointredm) {
		this.pointredm = pointredm;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
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
	
	
}
