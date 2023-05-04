package com.emart.test.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
public class Addtocart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addtocartid;
	
	private int productid;
	
	private String productname;
	
	private String productimagpath;
	
	private String productshortdesc;
	
	private double price;
	
	private double cardholderprice;
	
	private int pointredm;
	
	private float discount;
	
	private int qty;
	
	private String username;
	
	@ManyToOne
	private Productmaster productmaster;
	
	@ManyToOne
	private User user;
	
	@OneToMany(mappedBy="addtocart", cascade=CascadeType.ALL)
	private List<Orders> orders= new ArrayList<>();

	public Addtocart(int addtocartid, int productid, String productname, String productimagpath,
			String productshortdesc, double price, double cardholderprice, int pointredm, float discount, int qty,
			String username, Productmaster productmaster, User user, List<Orders> orders) {
		super();
		this.addtocartid = addtocartid;
		this.productid = productid;
		this.productname = productname;
		this.productimagpath = productimagpath;
		this.productshortdesc = productshortdesc;
		this.price = price;
		this.cardholderprice = cardholderprice;
		this.pointredm = pointredm;
		this.discount = discount;
		this.qty = qty;
		this.username = username;
		this.productmaster = productmaster;
		this.user = user;
		this.orders = orders;
	}

	public Addtocart() {
		super();
	}

	public int getAddtocartid() {
		return addtocartid;
	}

	public void setAddtocartid(int addtocartid) {
		this.addtocartid = addtocartid;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getCardholderprice() {
		return cardholderprice;
	}

	public void setCardholderprice(double cardholderprice) {
		this.cardholderprice = cardholderprice;
	}

	public int getPointredm() {
		return pointredm;
	}

	public void setPointredm(int pointredm) {
		this.pointredm = pointredm;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Productmaster getProductmaster() {
		return productmaster;
	}

	public void setProductmaster(Productmaster productmaster) {
		this.productmaster = productmaster;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	
	
}
