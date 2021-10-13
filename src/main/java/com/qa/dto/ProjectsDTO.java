package com.qa.dto;

public class ProjectsDTO {

	private Integer id;

	private String projectName;

	private String projectMaterials;

	private String easy;
	
	private Integer days;

	public ProjectsDTO(Integer id, String projectName, String projectMaterials, String easy, Integer days) {
		super();
		this.id = id;
		this.projectName = projectName;
		this.projectMaterials = projectMaterials;
		this.easy = easy;
		this.days = days;
	}
 
	public ProjectsDTO() {  
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



	

}