package com.qa.data;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;



@Entity
public class Projects {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer id;

	private String name;
	
	private String materials;
	
	private String easy;
	
	private Integer days;
	
	@ManyToOne 
	private Workshop workshop;

	public Projects(Integer id, String name, String materials, String easy, Integer days, Workshop workshop) {
		super();
		this.id = id;
		this.name = name;
		this.materials = materials;
		this.easy = easy;
		this.days = days;
		this.workshop = workshop;
	}

	public Projects() { 
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

	public String getMaterials() {
		return materials;
	}

	public void setMaterials(String materials) {
		this.materials = materials;
	}

	public String getEasy() {
		return easy;
	}

	public void setEasy(String easy) {
		this.easy = easy;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	public Workshop getWorkshop() {
		return workshop;
	}

	public void setWorkshop(Workshop workshop) {
		this.workshop = workshop;
	}

	@Override
	public int hashCode() {
		return Objects.hash(days, easy, id, materials, name, workshop);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Projects other = (Projects) obj;
		return Objects.equals(days, other.days) && Objects.equals(easy, other.easy) && Objects.equals(id, other.id)
				&& Objects.equals(materials, other.materials) && Objects.equals(name, other.name)
				&& Objects.equals(workshop, other.workshop);
	}
	

	
	
}
