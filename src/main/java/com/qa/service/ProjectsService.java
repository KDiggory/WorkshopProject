package com.qa.service;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.qa.data.Projects;
import com.qa.dto.ProjectWithWorkshopDTO;
import com.qa.dto.ProjectsDTO;
//import com.qa.dto.ProjectWithWorkshopDTO;
import com.qa.exceptions.ProjectNotFoundException;
import com.qa.repo.ProjectsRepo;

@Primary
@Service
public class ProjectsService {
	 	
	public ProjectsRepo repo;
	
	private ModelMapper mapper;
	
	public ProjectsService(ProjectsRepo repo,  ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}
	
	private ProjectWithWorkshopDTO mapToDTO(Projects project) {
		ProjectWithWorkshopDTO dto = new ProjectWithWorkshopDTO();

		dto.setProjectMaterials(project.getMaterials());
		dto.setProjectName(project.getName()); 
		dto.setDays(project.getDays());
		dto.setEasy(project.getEasy());
		dto.setId(project.getId());
		dto.setWorkshop(project.getWorkshop());
		return dto;
	}

	public ProjectWithWorkshopDTO getProjectById(Integer id) {
		Projects saved = this.repo.findById(id).orElseThrow(() -> {
		      
		       return new ProjectNotFoundException("No project found with that id");
		});
		return this.mapToDTO(saved);
		}	
	
	public List<Projects> findByName(String name) {
		var projects = (List<Projects>) repo.findByName(name); 
		return projects;
	}
	
	public List<Projects> findByDays(Integer days) {
		var projects = (List<Projects>) repo.findByDays(days);
		return projects;
	}
	public List<Projects> findByWorkshop(Integer id) {
		var projects = (List<Projects>) repo.findByWorkshop(id);
		return projects;
	}

	

	public List<Projects> getAllProjects() {
		return this.repo.findAll();
	}

	public Projects createProject(Projects project) {
		return this.repo.save(project);
	}

	public Projects updateProject(Projects project, Integer id) {
		Projects toUpdate = this.repo.findById(id).get();
		toUpdate.setName(project.getName());
		toUpdate.setEasy(project.getEasy());
		toUpdate.setMaterials(project.getMaterials());
		toUpdate.setWorkshop(project.getWorkshop());
		toUpdate.setDays(project.getDays());
		return this.repo.save(toUpdate);
	}
	
	public boolean deleteProject(Integer id, Object object) {
		this.repo.deleteById(id);
		boolean exists = this.repo.existsById(id);
		return !exists;
	}
	
	}

	
	

	



