package com.qa.service;

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
import com.qa.data.Workshop;
import com.qa.repo.WorkshopRepo;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class WorkshopServiceTest {
	
	@Autowired
	private WorkshopService service;
	
	@MockBean
	private WorkshopRepo repo; 
	
	@Test
	void testGetById() {
		final Integer id = 1;

		final Workshop workshop = new Workshop(id, "Katies Workshop", "The Garage" , null);
		Optional<Workshop> optionalWorkshop = Optional.of(workshop);
		
		Mockito.when(this.repo.findById(id)).thenReturn(optionalWorkshop);

		assertThat(this.service.getByIndex(id)).isEqualTo(optionalWorkshop);

		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
	}
	
	@Test
	void testGetAllWorkshops() {
		final List<Workshop> workshops = List.of(new Workshop(1, "Katies Workshop", "The Garage" , null),
				new Workshop(2, "Katies other Workshop", "The kitchen table" , null));

		Mockito.when(this.repo.findAll()).thenReturn(workshops);

		assertThat(this.service.getAllWorkshops()).isEqualTo(workshops);

		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	
	@Test
	void testUpdateWorkshop() { 
		final Integer id = 1;
		Workshop workshop = new Workshop(id, "Katies Workshop", "The Garage" , null);
		Optional<Workshop> optionalWorkshop = Optional.of(workshop);

		Workshop newWorkshop = new Workshop(id, "Katies other Workshop", "The kitchen table" , null);

		Mockito.when(this.repo.findById(id)).thenReturn(optionalWorkshop);
		Mockito.when(this.repo.save(newWorkshop)).thenReturn(newWorkshop);

		assertThat(this.service.updateWorkshop(newWorkshop, workshop.getWorkshopId()).equals(newWorkshop));

		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
		Mockito.verify(this.repo, Mockito.times(1)).save(newWorkshop);
}
	@Test
	void testCreateWorkshop() {
		final Integer id = 1;
		Workshop workshop = new Workshop(id, "Katies Workshop", "The Garage" , null);
		Workshop savedWorkshop = new Workshop(2, "Katies other Workshop", "The kitchen table" , null);

		Mockito.when(this.repo.save(workshop)).thenReturn(savedWorkshop);

		assertThat(this.service.createWorkshop(workshop)).isEqualTo(savedWorkshop);

		Mockito.verify(this.repo, Mockito.times(1)).save(workshop);
}

	@Test
	void testDeleteWorkshop() {
		final Integer id = 1;

		Mockito.when(this.repo.existsById(id)).thenReturn(false);
		
		assertThat(this.service.deleteWorkshop(id)).isEqualTo(true); // why is this not working??

		Mockito.verify(this.repo, Mockito.times(1)).existsById(id);
	}
}
