package com.qa.service;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.qa.data.Projects;
import com.qa.repo.ProjectsRepo;


@Primary
@Service
public class ProjectsService {
	
	public ProjectsRepo repo;
	
	public ProjectsService(ProjectsRepo repo) {
		super();
		this.repo = repo;
	}

	public Optional<Projects> getProjectById(Integer id) {
		return this.repo.findById(id);
	}

	public List<Projects> getAllProjects() {
		return this.repo.findAll();
	}

	public Projects createProject(com.qa.data.Projects project) {
		return this.repo.save(project);
	}

	public com.qa.data.Projects updateProject(Projects project, Integer id) {
		Projects toUpdate = this.repo.findById(id).get();
		toUpdate.setProjectName(project.getProjectName());
		toUpdate.setEasy(project.getEasy());
		toUpdate.setProjectMaterials(project.getProjectMaterials());
		toUpdate.setWorkshop(project.getWorkshop());
		toUpdate.setDays(project.getDays());
		return this.repo.save(toUpdate);
	}
	
	public void deleteProject(Integer id, Object object) {
		this.repo.deleteById(id);
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


