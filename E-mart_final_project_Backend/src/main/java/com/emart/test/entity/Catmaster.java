package com.emart.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Catmaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int catmasterid;
	private String catid;
	private String catimagpath;
	private String subcatid;
	private String catname;
	private String flag;
	@Column(nullable=true)
	private Integer productid;
	
	@ManyToOne
	private Productmaster productmaster;

	public Catmaster(int catmasterid, String catid, String catimagpath, String subcatid, String catname, String flag,
			Integer productid, Productmaster productmaster) {
		super();
		this.catmasterid = catmasterid;
		this.catid = catid;
		this.catimagpath = catimagpath;
		this.subcatid = subcatid;
		this.catname = catname;
		this.flag = flag;
		this.productid = productid;
		this.productmaster = productmaster;
	}

	public Catmaster() {
		super();
	}

	public int getCatmasterid() {
		return catmasterid;
	}

	public void setCatmasterid(int catmasterid) {
		this.catmasterid = catmasterid;
	}

	public String getCatid() {
		return catid;
	}

	public void setCatid(String catid) {
		this.catid = catid;
	}

	public String getCatimagpath() {
		return catimagpath;
	}

	public void setCatimagpath(String catimagpath) {
		this.catimagpath = catimagpath;
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

	public Productmaster getProductmaster() {
		return productmaster;
	}

	public void setProductmaster(Productmaster productmaster) {
		this.productmaster = productmaster;
	}

	

}
