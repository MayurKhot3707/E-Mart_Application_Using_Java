package com.emart.test.dto;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	
	private String username;
	
	private String password;
	
	private String fname;
	
	private String mname;
	
	private String lname;
	
	private String email;
	
	private long mobileno;
	
	private String cardholer;
	
	private int points;



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public UserDTO(String username, String password, String fname, String mname, String lname, String email,
			long mobileno, String cardholer, int points) {
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
	}

	public UserDTO() {
		super();
	}
	
	
	
}

