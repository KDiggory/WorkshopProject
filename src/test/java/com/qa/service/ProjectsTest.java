package com.qa.service;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.data.Projects;
import com.qa.data.Workshop;
import com.qa.repo.ProjectsRepo;
import com.qa.service.ProjectsService;


@ActiveProfiles("test")

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProjectsTest {
	
	@Autowired
	private ProjectsService service; 
	
	@MockBean 
	private ProjectsRepo repo;
	
	
	@Test
	void testGetById() {
		final Integer id = 1;

		final Projects project = new Projects(id, "Desk", "Walnut", "yes", 3, null);
		
		
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(project));

		assertThat(this.service.getProjectById(id)).isEqualTo(project);

		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
	}
	
	@Test
	void testGetAllProjects() {
		final List<Projects> projects = List.of(new Projects(1, "Desk", "Walnut", "yes", 3, null),
				new Projects(2, "Door", "Pine", "yes", 2, null));

		Mockito.when(this.repo.findAll()).thenReturn(projects);

		assertThat(this.service.getAllProjects()).isEqualTo(projects);

		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	
	@Test
	void testUpdateProject() { 
		final Integer id = 1;
		Projects project = new Projects(id, "Desk", "Walnut", "yes", 3, null);
		Optional<Projects> optionalProject = Optional.of(project);

		Projects newProject = new Projects(id, "Desk", "Walnut", "yes", 3, null);

		Mockito.when(this.repo.findById(id)).thenReturn(optionalProject);
		Mockito.when(this.repo.save(newProject)).thenReturn(newProject);

		assertThat(this.service.updateProject(newProject, project.getId()).equals(newProject));

		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
		Mockito.verify(this.repo, Mockito.times(1)).save(newProject);
}
	@Test
	void testCreateProject() {
		final Integer id = 1;
		Projects project = new Projects(id, "Desk", "Walnut", "yes", 3, null);
		Projects savedProject = new Projects(1, "Door", "Pine", "yes", 2, null);

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
	
	@Test
	void testSetId() {
		final Projects initialProject = new Projects(1, "Desk", "Walnut", "yes", 3, null);
		initialProject.setId(2);
		assertEquals(2, initialProject.getId());
	}
	
	@Test
	void testGetId() {
		final Projects initialProject = new Projects(1, "Desk", "Walnut", "yes", 3, null);
		Integer expected = initialProject.getId();
		assertEquals(expected, 1);
	}
	
	@Test
	void testSetName() {
		final Projects initialProject = new Projects(1, "Desk", "Walnut", "yes", 3, null);
		initialProject.setName("Bookcase");
		assertEquals("Bookcase", initialProject.getName());
	}
	
	@Test
	void testGetName() {
		final Projects initialProject = new Projects(1, "Desk", "Walnut", "yes", 3, null);
		String expected = initialProject.getName();
		assertEquals(expected, "Desk");
	}
	
	@Test
	void testSetMaterials() {
		final Projects initialProject = new Projects(1, "Desk", "Walnut", "yes", 3, null);
		initialProject.setMaterials("Oak");
		assertEquals("Oak", initialProject.getMaterials());
	}
	
	@Test
	void testGetMaterialse() {
		final Projects initialProject = new Projects(1, "Desk", "Walnut", "yes", 3, null);
		String expected = initialProject.getMaterials();
		assertEquals(expected, "Walnut");
	}
	
	@Test
	void testSetEasy() {
		final Projects initialProject = new Projects(1, "Desk", "Walnut", "yes", 3, null);
		initialProject.setEasy("No");
		assertEquals("No", initialProject.getEasy());
	}
	
	@Test
	void testGetEasy() {
		final Projects initialProject = new Projects(1, "Desk", "Walnut", "yes", 3, null);
		String expected = initialProject.getEasy();
		assertEquals(expected, "yes");
	}
	
	@Test
	void testSetDays() {
		final Projects initialProject = new Projects(1, "Desk", "Walnut", "yes", 3, null);
		initialProject.setDays(4);
		assertEquals(4, initialProject.getDays());
	}
	
	@Test
	void testGetDays() {
		final Projects initialProject = new Projects(1, "Desk", "Walnut", "yes", 3, null);
		Integer expected = initialProject.getDays();
		assertEquals(expected, 3);
	}
	
	@Test
	public void testEquals_Symmetric() {
		Projects project1 = new Projects(1, "Desk", "Walnut", "yes", 3, null);  // equals and hashCode check name field value
		Projects project2 = new Projects(1, "Desk", "Walnut", "yes", 3, null);
	    assertThat(project1.equals(project2) && project2.equals(project1));
	    assertThat(project1.hashCode() == project2.hashCode());
	}
	
	
	
	
	
	
	
	
	
}
