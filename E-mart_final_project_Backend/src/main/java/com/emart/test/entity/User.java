package com.emart.test.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User implements UserDetails{

	@Id
	@Column(nullable=false)
	private String username;
	@Column(nullable=false)
	private String password;
	@Column(nullable=false)
	private String fname;
	@Column(nullable=true)
	private String mname;
	@Column(nullable=false)
	private String lname;
	@Column(nullable=false)
	private String email;
	@Column(nullable=false)
	private long mobileno;
	@Column(nullable=true)
	private String cardholer;
	@Column(nullable=true)
	private int points;
	
	@OneToMany(mappedBy="users",cascade=CascadeType.ALL)
	private List<Useraddress> useraddress = new ArrayList<>();
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	private List<Addtocart> addtocarts = new ArrayList<>();
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	private List<Orders> orders = new ArrayList<>();
	
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL)
	private List<Payment>payment = new ArrayList<>();

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	public User(String username, String password, String fname, String mname, String lname, String email, long mobileno,
			String cardholer, int points, List<Useraddress> useraddress, List<Addtocart> addtocarts,
			List<Orders> orders, List<Payment> payment) {
		super();
		this.username = username;
		this.password = password;
		this.fname = fname;
		this.mname = mname;
		this.lname = lname;
		this.email = email;
		this.mobileno = mobileno;
		this.cardholer = cardholer;
		this.points = points;
		this.useraddress = useraddress;
		this.addtocarts = addtocarts;
		this.orders = orders;
		this.payment = payment;
	}

	public User() {
		super();
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobileno() {
		return mobileno;
	}

	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}

	public String getCardholer() {
		return cardholer;
	}

	public void setCardholer(String cardholer) {
		this.cardholer = cardholer;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public List<Useraddress> getUseraddress() {
		return useraddress;
	}

	public void setUseraddress(List<Useraddress> useraddress) {
		this.useraddress = useraddress;
	}

	public List<Addtocart> getAddtocarts() {
		return addtocarts;
	}

	public void setAddtocarts(List<Addtocart> addtocarts) {
		this.addtocarts = addtocarts;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public List<Payment> getPayment() {
		return payment;
	}

	public void setPayment(List<Payment> payment) {
		this.payment = payment;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
