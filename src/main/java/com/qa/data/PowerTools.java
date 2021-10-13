package com.qa.data;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class PowerTools implements Tools {

	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;
	
	private String usedFor;
	
	private String easy;
	
	private Integer cost;
	
	private String dangerous;
	
	@ManyToOne 
	private Workshop workshop;
	
//	@OneToMany	
//	private Projects project;

	public PowerTools() {
		super();
		
	}

	public PowerTools(Integer id, String name, String usedFor, String easy, Integer cost, String dangerous,
			Workshop workshop) {
		super();
		this.id = id;
		this.name = name;
		this.usedFor = usedFor;
		this.easy = easy;
		this.cost = cost;
		this.dangerous = dangerous;
		this.workshop = workshop;
		//this.project = project;
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

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public String getDangerous() {
		return dangerous;
	}

	public void setDangerous(String dangerous) {
		this.dangerous = dangerous;
	}

	public Workshop getWorkshop() {
		return workshop;
	}

	public void setWorkshop(Workshop workshop) {
		this.workshop = workshop;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cost, dangerous, easy, id, name, usedFor, workshop);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PowerTools other = (PowerTools) obj;
		return Objects.equals(cost, other.cost) && Objects.equals(dangerous, other.dangerous)
				&& Objects.equals(easy, other.easy) && Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(usedFor, other.usedFor) && Objects.equals(workshop, other.workshop);
	}

	
	 
	
 
}
