package com.qa.dto;

public class ProjectWithWorkshopDTO {

	private Integer id;

	private String projectName;

	private String projectMaterials;

	private Boolean easy;
	
	private Integer days;

	private String workshop;

	public ProjectWithWorkshopDTO(Integer id, String projectName, String projectMaterials, Boolean easy, Integer days, String workshop) {
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

	public Boolean getEasy() {
		return easy;
	}

	public void setEasy(Boolean easy) {
		this.easy = easy;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	public String getWorkshop() {
		return workshop;
	}

	public void setWorkshop(String workshop) {
		this.workshop = workshop;
	}
	}