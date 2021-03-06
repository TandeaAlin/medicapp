package com.medicapp.data.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "drug")
public class Drug {

	@Id
	@GeneratedValue
	@Column(name = "iddrug")
	private int iddrug;

	@Column(name = "name")
	private String name;

	@Column(name = "price")
	private String price;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "drug")
	@JsonIgnore
	private Set<Prescription> prescriptions = new HashSet<Prescription>(0);

	public int getIddrug() {
		return iddrug;
	}

	public void setIddrug(int iddrug) {
		this.iddrug = iddrug;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Drug(int iddrug, String name, String price) {
		super();
		this.iddrug = iddrug;
		this.name = name;
		this.price = price;
	}

	public Set<Prescription> getPrescriptions() {
		return prescriptions;
	}

	public void setPrescriptions(Set<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}

	public Drug() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Drug [iddrug=" + iddrug + ", name=" + name + ", price=" + price + "]";
	}

}
