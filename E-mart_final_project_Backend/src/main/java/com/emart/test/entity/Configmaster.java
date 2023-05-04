package com.emart.test.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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
public class Configmaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int configid;
	private String configname;
	
	@OneToMany(mappedBy="configmaster", cascade = CascadeType.ALL)
	private Set<Productdtlmaster> productdtlmasters = new HashSet<>();

	public Configmaster(int configid, String configname, Set<Productdtlmaster> productdtlmasters) {
		super();
		this.configid = configid;
		this.configname = configname;
		this.productdtlmasters = productdtlmasters;
	}

	public Configmaster() {
		super();
	}

	public int getConfigid() {
		return configid;
	}

	public void setConfigid(int configid) {
		this.configid = configid;
	}

	public String getConfigname() {
		return configname;
	}

	public void setConfigname(String configname) {
		this.configname = configname;
	}

	public Set<Productdtlmaster> getProductdtlmasters() {
		return productdtlmasters;
	}

	public void setProductdtlmasters(Set<Productdtlmaster> productdtlmasters) {
		this.productdtlmasters = productdtlmasters;
	}
	
	
}
