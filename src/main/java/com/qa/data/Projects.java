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
	@Column(name="project_id")
	private Integer projectId;
	@Column(name="project_name")
	private String projectName;
	@Column(name="project_materials")
	private String projectMaterials;
	
	private String easy;
	
	private Integer days;
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Projects other = (Projects) obj;
		return Objects.equals(days, other.days) && easy == other.easy && Objects.equals(projectId, other.projectId)
				&& Objects.equals(projectMaterials, other.projectMaterials)
				&& Objects.equals(projectName, other.projectName) && Objects.equals(workshop, other.workshop);
	} 

	
	
	
	@ManyToOne
	private Workshop workshop;


	public Projects(Integer projectId, String projectName, String projectMaterials, String easy, Integer days,
			Workshop workshop) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectMaterials = projectMaterials;
		this.easy = easy;
		this.days = days;
		this.workshop = workshop;
	}
	
	public Projects() { // REQUIRED default constructor
		super();
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
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

	@Override
	public int hashCode() {
		return Objects.hash(days, easy, projectId, projectMaterials, projectName, workshop);
	}

	
}
