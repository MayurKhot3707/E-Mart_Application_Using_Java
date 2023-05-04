package com.emart.test.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Productmaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	@OneToMany(mappedBy="productmaster", cascade = CascadeType.ALL)
	private Set<Productdtlmaster> productdtlmasters = new HashSet<>();
	
	@OneToMany(mappedBy="productmaster", cascade = CascadeType.ALL)
	private Set<Catmaster> catmasters = new HashSet<>();
	
	@OneToMany(mappedBy="productmaster", cascade = CascadeType.ALL)
	private Set<Addtocart> addtocarts = new HashSet<>();
	
	@OneToMany(mappedBy="productmaster",cascade=CascadeType.ALL)
	private List<Orders> orders = new ArrayList<>();

	public Productmaster(int productid, double cardholderprice, float discount, int pointredm, double price,
			String productimagpath, String productshortdesc, String productlongdesc, String productname,
			Set<Productdtlmaster> productdtlmasters, Set<Catmaster> catmasters, Set<Addtocart> addtocarts,
			List<Orders> orders) {
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
		this.productdtlmasters = productdtlmasters;
		this.catmasters = catmasters;
		this.addtocarts = addtocarts;
		this.orders = orders;
	}

	public Productmaster() {
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

	public Set<Productdtlmaster> getProductdtlmasters() {
		return productdtlmasters;
	}

	public void setProductdtlmasters(Set<Productdtlmaster> productdtlmasters) {
		this.productdtlmasters = productdtlmasters;
	}

	public Set<Catmaster> getCatmasters() {
		return catmasters;
	}

	public void setCatmasters(Set<Catmaster> catmasters) {
		this.catmasters = catmasters;
	}

	public Set<Addtocart> getAddtocarts() {
		return addtocarts;
	}

	public void setAddtocarts(Set<Addtocart> addtocarts) {
		this.addtocarts = addtocarts;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	
	
}
