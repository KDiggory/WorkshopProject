package com.qa.dto;

import com.qa.data.Workshop;

public class ProjectWithWorkshopDTO {

	private Integer id;

	private String projectName;

	private String projectMaterials;

	private String easy;
	
	private Integer days;

	private Workshop workshop;

	public ProjectWithWorkshopDTO(Integer id, String projectName, String projectMaterials, String easy, Integer days, Workshop workshop) {
		super();
		this.id = id;
		this.projectName = projectName;
		this.projectMaterials = projectMaterials;
		this.easy = easy;
		this.days = days; 
		this.workshop = workshop;
	}

	public ProjectWithWorkshopDTO() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectMaterials() {
		return projectMaterials;
	}

	public void setProjectMaterials(String projectMaterials) {
		this.projectMaterials = projectMaterials;
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
	}