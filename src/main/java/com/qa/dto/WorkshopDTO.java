package com.qa.dto;

import java.util.List;

public class WorkshopDTO {

	private Integer id;

	private String workshopLocation;

	private List<ProjectsDTO> projects;

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

	public List<ProjectsDTO> getProjects() {
		return projects;
	}

	public void setProjects(List<ProjectsDTO> projects) {
		this.projects = projects;
	}

}