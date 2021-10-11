package com.qa.data;


import java.util.List;
import java.util.Objects;

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
	private Integer workshopId;
	
	private String workshopName;
	
	private String workshopAddress;
	
	@JsonIgnore
	@OneToMany(mappedBy = "workshop")
	private List<Workshop> workshop;

	public Workshop(Integer workshopId, String workshopName, String workshopAddress, List<Workshop> workshop) {
		super();
		this.workshopId = workshopId;
		this.workshopName = workshopName;
		this.workshopAddress = workshopAddress;
		this.workshop = workshop;
	}
	
	public Workshop() {
	super();
	}

	public Integer getWorkshopId() {
		return workshopId;
	}

	public void setWorkshopId(Integer workshopId) {
		this.workshopId = workshopId;
	}

	public String getWorkshopName() {
		return workshopName;
	}

	public List<Workshop> getWorkshop() {
		return workshop;
	}

	public void setWorkshopName(String workshopName) {
		this.workshopName = workshopName;
	}

	public String getWorkshopAddress() {
		return workshopAddress;
	}

	public void setWorkshopAddress(String workshopAddress) {
		this.workshopAddress = workshopAddress;
	}



	public void setWorkshop(List<Workshop> workshop) {
		this.workshop = workshop;
	}


	public String value() {
		return null;
	}
	@Override
	public int hashCode() {
		return Objects.hash(workshop, workshopAddress, workshopId, workshopName);
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
		return Objects.equals(workshop, other.workshop) && Objects.equals(workshopAddress, other.workshopAddress)
				&& Objects.equals(workshopId, other.workshopId) && Objects.equals(workshopName, other.workshopName);
	}
	 
	
}
