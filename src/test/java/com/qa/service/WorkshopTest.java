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
import com.qa.repo.WorkshopRepo;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class WorkshopTest {
	
	@Autowired
	private WorkshopService service;
	
	@MockBean
	private WorkshopRepo repo; 
	
	
	
	@Test
	void testGetById() {
		final Integer id = 1;

		final Workshop workshop = new Workshop(id, "Katies Workshop", "The Garage" , null);
		
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(workshop));

		assertThat(this.service.getByIndex(id)).isEqualTo(workshop);

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

		Workshop newWorkshop = new Workshop(id, "Katies Workshop", "The Garage" , null);

		Mockito.when(this.repo.findById(id)).thenReturn(optionalWorkshop);
		Mockito.when(this.repo.save(newWorkshop)).thenReturn(newWorkshop);

		assertThat(this.service.updateWorkshop(newWorkshop, workshop.getId()).equals(newWorkshop));

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
	
	@Test
	void testSetId()  {
		final Workshop initialWorkshop = new Workshop(1, "Katies Workshop", "The Garage" , null);
		initialWorkshop.setId(2);
		assertEquals(2, initialWorkshop.getId());
	}
	@Test
	void testGetId() {
		final Workshop initialWorkshop = new Workshop(1, "Katies Workshop", "The Garage" , null);
		Integer expected = initialWorkshop.getId();
		assertEquals(expected, 1);
	}
	
	@Test
	void testSetName() {
		final Workshop initialWorkshop = new Workshop(1, "Katies Workshop", "The Garage" , null);
		initialWorkshop.setName("Katies Extra Workshop");
		assertEquals("Katies Extra Workshop", initialWorkshop.getName());
	}
	
	@Test
	void testGetName() {
		final Workshop initialWorkshop = new Workshop(1, "Katies Workshop", "The Garage" , null);
		String expected = initialWorkshop.getName();
		assertEquals(expected, "Katies Workshop");
	}
	
	@Test
	void testSetAddress() {
		final Workshop initialWorkshop = new Workshop(1, "Katies Workshop", "The Garage" , null);
		initialWorkshop.setAddress("The kitchen table");
		assertEquals("The kitchen table", initialWorkshop.getAddress());
	}
	
	@Test
	void testGetAddress() {
		final Workshop initialWorkshop = new Workshop(1, "Katies Workshop", "The Garage" , null);
		String expected = initialWorkshop.getAddress();
		assertEquals(expected, "The Garage");
	}
	
	@Test
	public void testEquals_Symmetric() {
		Workshop workshop1 = new Workshop(1, "Katies Workshop", "The Garage" , null);  // equals and hashCode check name field value
		Workshop workshop2 = new Workshop(1, "Katies Workshop", "The Garage" , null);
	    assertThat(workshop1.equals(workshop2) && workshop2.equals(workshop1));
	    assertThat(workshop1.hashCode() == workshop2.hashCode());
	}
	
//	@Test
//	void testSetWorkshop() {
//		final Workshop initialWorkshop = new Workshop(1, "Katies Workshop", "The Garage" , null);
//		initialWorkshop.setWorkshop(null); 
//		assertEquals(null, initialWorkshop.getWorkshop());
//	}
//	
//	@Test
//	void testGetWorkshop() {
//		final Workshop initialWorkshop = new Workshop(1, "Katies Workshop", "The Garage" , null);
//		List<Workshop> expected = initialWorkshop.getWorkshop();
//		assertEquals(expected, null);
//	}
}



















