package com.qa.dto;

import java.util.Objects;

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
 
	@Override
	public int hashCode() {
		return Objects.hash(days, easy, id, projectMaterials, projectName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProjectsDTO other = (ProjectsDTO) obj;
		return Objects.equals(days, other.days) && Objects.equals(easy, other.easy) && Objects.equals(id, other.id)
				&& Objects.equals(projectMaterials, other.projectMaterials)
				&& Objects.equals(projectName, other.projectName);
	}

	@Override
	public String toString() {
		return "ProjectsDTO [id=" + id + ", projectName=" + projectName + ", projectMaterials=" + projectMaterials
				+ ", easy=" + easy + ", days=" + days + "]";
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