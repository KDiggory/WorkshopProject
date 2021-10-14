package com.qa.dto;

import java.util.List;
import java.util.Objects;

public class WorkshopDTO {

	private Integer id;
	
	private String name;

	private String address;

	private List<ProjectsDTO> projects;
	
	private List<PowerToolsDTO> powertools;


	

	

	@Override
	public String toString() {
		return "WorkshopDTO [id=" + id + ", name=" + name + ", address=" + address + ", projects=" + projects
				+ ", powertools=" + powertools + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, id, name, powertools, projects);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WorkshopDTO other = (WorkshopDTO) obj;
		return Objects.equals(address, other.address) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(powertools, other.powertools)
				&& Objects.equals(projects, other.projects);
	}

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