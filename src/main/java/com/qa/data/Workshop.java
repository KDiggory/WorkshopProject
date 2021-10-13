package com.qa.data;


import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Workshop {




	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private String address;
	
	@JsonIgnore
	@OneToMany(mappedBy = "workshop")
	private List<Projects> project;
	
	@OneToMany(mappedBy = "workshop")
	private List<PowerTools> powertools;

	public Workshop() {
		super();
	
	}

	public Workshop(Integer id, String name, String address, List<Projects> project, List<PowerTools> powertool) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.project = project;
		this.powertools = powertool;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) { 
		this.address = address;
	}
 
	public List<Projects> getProject() {
		return project;
	}

	public List<PowerTools> getPowertools() {
		return powertools;
	}

	public void setPowertools(List<PowerTools> powertools) {
		this.powertools = powertools;
	}

	public void setProject(List<Projects> project) {
		this.project = project;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, id, name, powertools, project);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Workshop other = (Workshop) obj;
		return Objects.equals(address, other.address) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(powertools, other.powertools)
				&& Objects.equals(project, other.project);
	}

	

}