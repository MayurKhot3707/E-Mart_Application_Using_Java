package com.emart.test.entity;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Productdtlmaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int proudctdtlmasterid;
	private String configdtl;
	private int productid;
	private int configid;

	@ManyToOne
	private Productmaster productmaster;
	
	@ManyToOne
	private Configmaster configmaster;

	public Productdtlmaster(int proudctdtlmasterid, String configdtl, int productid, int configid,
			Productmaster productmaster, Configmaster configmaster) {
		super();
		this.proudctdtlmasterid = proudctdtlmasterid;
		this.configdtl = configdtl;
		this.productid = productid;
		this.configid = configid;
		this.productmaster = productmaster;
		this.configmaster = configmaster;
	}

	public Productdtlmaster() {
		super();
	}

	public int getProudctdtlmasterid() {
		return proudctdtlmasterid;
	}

	public void setProudctdtlmasterid(int proudctdtlmasterid) {
		this.proudctdtlmasterid = proudctdtlmasterid;
	}

	public String getConfigdtl() {
		return configdtl;
	}

	public void setConfigdtl(String configdtl) {
		this.configdtl = configdtl;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public int getConfigid() {
		return configid;
	}

	public void setConfigid(int configid) {
		this.configid = configid;
	}

	public Productmaster getProductmaster() {
		return productmaster;
	}

	public void setProductmaster(Productmaster productmaster) {
		this.productmaster = productmaster;
	}

	public Configmaster getConfigmaster() {
		return configmaster;
	}

	public void setConfigmaster(Configmaster configmaster) {
		this.configmaster = configmaster;
	}
	
	
	
}
