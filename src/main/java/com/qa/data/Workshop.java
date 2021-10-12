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

	public Workshop() {
		super();
	
	}

	public Workshop(Integer id, String name, String address, List<Projects> project) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.project = project;
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

	public void setProject(List<Projects> project) {
		this.project = project;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, id, name, project);
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
				&& Objects.equals(name, other.name) && Objects.equals(project, other.project);
	}

}