package com.qa.data;

import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.qa.data.Projects;
import com.qa.data.Tools;
import com.qa.data.Workshop;

public class HandTools implements Tools {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;
	
	private String usedFor;
	
	private String easy;
	
	private String size;
	
	@ManyToMany 
	private Workshop workshop;
	
	@ManyToMany 
	private Projects project;

	public HandTools(Integer id, String name, String usedFor, String easy, String size, Workshop workshop,
			Projects project) {
		super();
		this.id = id;
		this.name = name;
		this.usedFor = usedFor;
		this.easy = easy;
		this.size = size;
		this.workshop = workshop;
		this.project = project;
	}

	public HandTools() {
		super();
		
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

	public String getUsedFor() {
		return usedFor;
	}

	public void setUsedFor(String usedFor) {
		this.usedFor = usedFor;
	}

	public String getEasy() {
		return easy;
	}

	public void setEasy(String easy) {
		this.easy = easy;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Workshop getWorkshop() {
		return workshop;
	}

	public void setWorkshop(Workshop workshop) {
		this.workshop = workshop;
	}

	public Projects getProject() {
		return project;
	}

	public void setProject(Projects project) {
		this.project = project;
	}

	@Override
	public int hashCode() {
		return Objects.hash(easy, id, name, project, size, usedFor, workshop);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HandTools other = (HandTools) obj;
		return Objects.equals(easy, other.easy) && Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(project, other.project) && Objects.equals(size, other.size)
				&& Objects.equals(usedFor, other.usedFor) && Objects.equals(workshop, other.workshop);
	}
	

}
 
