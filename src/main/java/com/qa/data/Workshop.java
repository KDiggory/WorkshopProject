package com.qa.data;


import java.lang.annotation.Annotation;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.Id;

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

	public void setWorkshopName(String workshopName) {
		this.workshopName = workshopName;
	}

	public String getWorkshopAddress() {
		return workshopAddress;
	}

	public void setWorkshopAddress(String workshopAddress) {
		this.workshopAddress = workshopAddress;
	}

	public List<Workshop> getWorkshop() {
		return workshop;
	}

	public void setWorkshop(List<Workshop> workshop) {
		this.workshop = workshop;
	}

	public Class<? extends Annotation> annotationType() {
		return null;
	}

	public String value() {
		return null;
	}
	
}
