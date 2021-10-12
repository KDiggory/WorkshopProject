package com.qa.service;

import java.lang.System.Logger;
import java.lang.annotation.Annotation;


import java.util.List;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.qa.data.Projects;
//import com.qa.dto.ProjectWithWorkshopDTO;
import com.qa.exceptions.ProjectNotFoundException;
import com.qa.repo.ProjectsRepo;





@Primary
@Service
public class ProjectsService {
	
	
	
	
	public ProjectsRepo repo;
	
	public ProjectsService(ProjectsRepo repo) {
		super();
		this.repo = repo;
	}

	public Projects getProjectById(Integer id) {
		Projects saved = this.repo.findById(id).orElseThrow(() -> {
		      
		       return new ProjectNotFoundException("No project found with that id");
		});
		return saved;
		
	}
		//new ProjectNotFoundException("No project found with that id")));  
		// why is this not working??
		// return saved;
		//return this.mapToDTO(foundProject); 
	 

	public List<Projects> getAllProjects() {
		return this.repo.findAll();
	}

	public Projects createProject(com.qa.data.Projects project) {
		return this.repo.save(project);
	}

	public Projects updateProject(Projects project, Integer id) {
		Projects toUpdate = this.repo.findById(id).get();
		toUpdate.setProjectName(project.getProjectName());
		toUpdate.setEasy(project.getEasy());
		toUpdate.setProjectMaterials(project.getProjectMaterials());
		toUpdate.setWorkshop(project.getWorkshop());
		toUpdate.setDays(project.getDays());
		return this.repo.save(toUpdate);
	}
	
	public boolean deleteProject(Integer id, Object object) {
		this.repo.deleteById(id);
		boolean exists = this.repo.existsById(id);
		return !exists;
	}
	
	public ProjectsRepo getRepo() {
		return repo;
	}

	public void setRepo(ProjectsRepo repo) {
		this.repo = repo;
	}

	public Class<? extends Annotation> annotationType() {
		return null;
	}

	public String value() {
		return null;
	}

	
} 


