package com.qa.dto;

import java.util.List;

public class WorkshopDTO {

	private Integer id;
	
	private String workshopName;

	private String workshopLocation;

	private List<ProjectsDTO> projects;
	
	private List<PowerToolsDTO> powertools;

	

	

	public WorkshopDTO(Integer id, String workshopName, String workshopLocation, List<ProjectsDTO> projects,
			List<PowerToolsDTO> powertools) {
		super();
		this.id = id;
		this.workshopName = workshopName;
		this.workshopLocation = workshopLocation;
		this.projects = projects;
		this.powertools = powertools;
	}

	public WorkshopDTO() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWSlocation() {
		return workshopLocation;
	}

	public void setWSLocation(String location) {
		this.workshopLocation = location;
	}

	public String getWorkshopName() {
		return workshopName;
	}

	public void setWorkshopName(String workshopName) {
		this.workshopName = workshopName;
	}

	public List<ProjectsDTO> getProjects() {
		return projects;
	}

	public void setProjects(List<ProjectsDTO> projects) {
		this.projects = projects;
	}

	public void setPowerTools(List<PowerToolsDTO> ptDTOs) {
		// TODO Auto-generated method stub
		
	}

	public String getWorkshopLocation() {
		return workshopLocation;
	}

	public void setWorkshopLocation(String workshopLocation) {
		this.workshopLocation = workshopLocation;
	}

	public List<PowerToolsDTO> getPowertools() {
		return powertools;
	}

	public void setPowertools(List<PowerToolsDTO> powertools) {
		this.powertools = powertools;
	}

}