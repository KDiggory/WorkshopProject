package com.qa.dto;

import java.util.List;

public class WorkshopDTO {

	private Integer id;
	
	private String name;

	private String address;

	private List<ProjectsDTO> projects;
	
	private List<PowerToolsDTO> powertools;


	

	

	public WorkshopDTO(Integer id, String name, String address, List<ProjectsDTO> projects,
			List<PowerToolsDTO> powertools) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
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

	public List<ProjectsDTO> getProjects() {
		return projects;
	}

	public void setProjects(List<ProjectsDTO> projects) {
		this.projects = projects;
	}

	public List<PowerToolsDTO> getPowertools() {
		return powertools;
	}

	public void setPowertools(List<PowerToolsDTO> powertools) {
		this.powertools = powertools;
	}

	

}