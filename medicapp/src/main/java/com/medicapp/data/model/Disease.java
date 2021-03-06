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
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

@XmlRootElement
@Entity
@Table(name = "disease")
public class Disease {

	@Id
	@GeneratedValue
	@Column(name = "iddisease")
	private int iddisease;

	@Column(name = "name")
	private String name;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "disease")
	@JsonIgnore
	private Set<KnownDisease> knownDiseases = new HashSet<KnownDisease>(0);

	public Disease() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Disease(int iddisease, String name, Set<KnownDisease> knownDiseases) {
		super();
		this.iddisease = iddisease;
		this.name = name;
		this.knownDiseases = knownDiseases;
	}

	public Set<KnownDisease> getKnownDiseases() {
		return knownDiseases;
	}

	public void setKnownDiseases(Set<KnownDisease> knownDiseases) {
		this.knownDiseases = knownDiseases;
	}

	public int getIddisease() {
		return iddisease;
	}

	public void setIddisease(int iddisease) {
		this.iddisease = iddisease;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Disease [iddisease=" + iddisease + ", name=" + name + "]";
	}

}
