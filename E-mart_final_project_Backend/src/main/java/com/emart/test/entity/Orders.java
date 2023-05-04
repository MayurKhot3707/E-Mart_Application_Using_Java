package com.emart.test.entity;

import java.util.ArrayList;
import java.util.Date;
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
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderid;
	
	private double cardholderprice;
	
	private int cartid;
	
	private float discount;
	
	private Date orderdate;
	
	private int pointredm;
	
	private double price;
	
	private int productid;
	
	private String productname;
	
	private int qty;
	
	private String username;
	
	@ManyToOne
	private Addtocart addtocart;
	@ManyToOne
	private User user;
	@ManyToOne
	private Productmaster productmaster;
	
	@OneToMany(mappedBy="orders", cascade = CascadeType.ALL)
	private List<Payment>payment = new ArrayList<>();

	public Orders(int orderid, double cardholderprice, int cartid, float discount, Date orderdate, int pointredm,
			double price, int productid, String productname, int qty, String username, Addtocart addtocart, User user,
			Productmaster productmaster, List<Payment> payment) {
		super();
		this.orderid = orderid;
		this.cardholderprice = cardholderprice;
		this.cartid = cartid;
		this.discount = discount;
		this.orderdate = orderdate;
		this.pointredm = pointredm;
		this.price = price;
		this.productid = productid;
		this.productname = productname;
		this.qty = qty;
		this.username = username;
		this.addtocart = addtocart;
		this.user = user;
		this.productmaster = productmaster;
		this.payment = payment;
	}

	public Orders() {
		super();
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public double getCardholderprice() {
		return cardholderprice;
	}

	public void setCardholderprice(double cardholderprice) {
		this.cardholderprice = cardholderprice;
	}

	public int getCartid() {
		return cartid;
	}

	public void setCartid(int cartid) {
		this.cartid = cartid;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
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

	public Addtocart getAddtocart() {
		return addtocart;
	}

	public void setAddtocart(Addtocart addtocart) {
		this.addtocart = addtocart;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Productmaster getProductmaster() {
		return productmaster;
	}

	public void setProductmaster(Productmaster productmaster) {
		this.productmaster = productmaster;
	}

	public List<Payment> getPayment() {
		return payment;
	}

	public void setPayment(List<Payment> payment) {
		this.payment = payment;
	}
	
	
}
