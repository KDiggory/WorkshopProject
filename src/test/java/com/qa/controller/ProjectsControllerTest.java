package com.qa.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.data.Projects;
import com.qa.repo.ProjectsRepo;
import com.qa.service.ProjectsService;



@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProjectsControllerTest {
	
	@Autowired
	private ProjectsService service;
	
	@MockBean
	private ProjectsRepo repo;
	
	
	@Test
	void testGetById() {
		final Integer id = 1;

		final Projects project = new Projects(id, "Desk", "Walnut", true, 3, null);
		Optional<Projects> optionalProject = Optional.of(project);
		
		Mockito.when(this.repo.findById(id)).thenReturn(optionalProject);

		assertThat(this.service.getProjectById(id)).isEqualTo(optionalProject);

		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
	}
	
	@Test
	void testGetAllProjects() {
		final List<Projects> projects = List.of(new Projects(1, "Desk", "Walnut", true, 3, null),
				new Projects(2, "Door", "Pine", true, 2, null));

		Mockito.when(this.repo.findAll()).thenReturn(projects);

		assertThat(this.service.getAllProjects()).isEqualTo(projects);

		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	
	@Test
	void testUpdateProject() { 
		final Integer id = 1;
		Projects project = new Projects(id, "Desk", "Walnut", true, 3, null);
		Optional<Projects> optionalProject = Optional.of(project);

		Projects newProject = new Projects(id, "Desk", "Walnut", true, 3, null);

		Mockito.when(this.repo.findById(id)).thenReturn(optionalProject);
		Mockito.when(this.repo.save(newProject)).thenReturn(newProject);

		assertThat(this.service.updateProject(newProject, project.getProjectId()).equals(newProject));

		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
		Mockito.verify(this.repo, Mockito.times(1)).save(newProject);
}
	@Test
	void testCreateProject() {
		final Integer id = 1;
		Projects project = new Projects(id, "Desk", "Walnut", true, 3, null);
		Projects savedProject = new Projects(1, "Door", "Pine", true, 2, null);

		Mockito.when(this.repo.save(project)).thenReturn(savedProject);

		assertThat(this.service.createProject(project)).isEqualTo(savedProject);

		Mockito.verify(this.repo, Mockito.times(1)).save(project);
}
	
	@Test
	void testDeleteProject() {
		final Integer id = 1;

		Mockito.when(this.repo.existsById(id)).thenReturn(false);
		
		assertThat(this.service.deleteProject(id, null)).isEqualTo(true); // why is this not working??

		Mockito.verify(this.repo, Mockito.times(1)).existsById(id);
	}
}
