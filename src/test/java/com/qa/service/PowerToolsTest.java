package com.qa.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.data.PowerTools;
import com.qa.data.Projects;
import com.qa.data.Workshop;
import com.qa.dto.PowerToolsDTO;
import com.qa.dto.ProjectsDTO;
import com.qa.dto.WorkshopDTO;
import com.qa.repo.PowerToolsRepo;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PowerToolsTest {
	
	@MockBean
	private PowerToolsRepo repo;
	
	@Autowired
	private PowerToolsService service;
	
	
//	@Test
//	void testMapToDTO() {
//	final List<ProjectsDTO> projectDTO = List.of(new ProjectsDTO(1, "Desk", "Walnut", "yes", 3));
//	final List<Projects> project = List.of(new Projects(1, "Desk", "Walnut", "yes", 3, null));
//	
//	final List<PowerToolsDTO> powertoolsDTO = List.of(new PowerToolsDTO(1, "Drill", "Drilling","very", 115, "No"));
//	final List<PowerTools> powertools = List.of(new PowerTools(1, "Drill", "Drilling","very", 115, "No",null, null));
//	
//	final WorkshopDTO workshopDTO = new WorkshopDTO(1, "Katies Workshop", "The Garage" , projectDTO, powertoolsDTO);
//	final Workshop workshop = new Workshop(1, "Katies Workshop", "The Garage" , project, powertools);
//
//	assertThat(this.service.mapToDTO(powertools)).isEqualTo(powertoolsDTO);
//
//}

//	@Test
//	void testGetById() {
//		final Integer id = 1;
//		//final List<Projects> project = List.of(new Projects(1, "Desk", "Walnut", "yes", 3, null));
//		//final List<PowerTools> powertools = List.of(new PowerTools(1, "Drill", "Drilling","very", 115, "No",null, null));
//		
//		final PowerTools powertools = new PowerTools(1, "Drill", "Drilling","very", 115, "No",null, null);
//		PowerToolsDTO toCheck = this.service. .mapToDTO(powertools);
//		
//		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(powertools));
//
//		assertThat(this.service.getPowerToolById(id).isEqualTo(toCheck));
//
//		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
//	}
//	
//	@Test
//	void testGetAllPowertools() {
//		final List<Projects> project = List.of(new Projects(1, "Desk", "Walnut", "yes", 3, null));
//		//final List<PowerTools> powertool = List.of(new PowerTools(1, "Drill", "Drilling","very", 115, "No",null, null));
//		final List<PowerTools> powertools = List.of(new PowerTools(1, "Drill", "Drilling","very", 115, "No",null, null),
//				new PowerTools(1, "Drill", "Drilling","very", 115, "No",null, null));
//		List<PowerToolsDTO> toCheck = new ArrayList<>();
//		for(PowerTools powertool :powertools) {
//			toCheck.add(this.service.mapToDTO(powertool));
//		}
//	}
		
		@Test
		void testUpdatePowertool() { 
			final Integer id = 1;
			PowerTools powertool = new PowerTools(1, "Drill", "Drilling","very", 115, "No",null, null);
			Optional<PowerTools> optionalpowertool = Optional.of(powertool);

			PowerTools newpowertool = new PowerTools(1, "Drill", "Drilling","very", 115, "No",null, null);

			Mockito.when(this.repo.findById(id)).thenReturn(optionalpowertool);
			Mockito.when(this.repo.save(newpowertool)).thenReturn(newpowertool);

			assertThat(this.service.updatePowerTool(newpowertool, powertool.getId()).equals(newpowertool));

			Mockito.verify(this.repo, Mockito.times(1)).findById(id);
			Mockito.verify(this.repo, Mockito.times(1)).save(newpowertool);
	}
		
		@Test
		void testCreatePowerTool() {
			final Integer id = 1;
			PowerTools powertool = new PowerTools(1, "Drill", "Drilling","very", 115, "No",null, null);
			PowerTools savedpowertool = new PowerTools(1, "Drill", "Drilling","very", 115, "No",null, null);

			Mockito.when(this.repo.save(powertool)).thenReturn(savedpowertool);

			assertThat(this.service.createPowerTool(powertool)).isEqualTo(savedpowertool);

			Mockito.verify(this.repo, Mockito.times(1)).save(powertool);
	}
	
		@Test
		void testDeletePowerTool() {
			final Integer id = 1;

			Mockito.when(this.repo.existsById(id)).thenReturn(false);
			
			assertThat(this.service.deletePowerTool(id, null)).isEqualTo(true); // why is this not working??

			Mockito.verify(this.repo, Mockito.times(1)).existsById(id);
		}
		
		@Test
		void testSetId()  {
			PowerTools powertool = new PowerTools(1, "Drill", "Drilling","very", 115, "No",null, null);
			powertool.setId(2);
			assertEquals(2, powertool.getId());
		}
		
		@Test
		void testGetId() {
			PowerTools powertool = new PowerTools(1, "Drill", "Drilling","very", 115, "No",null, null);
			Integer expected = powertool.getId();
			assertEquals(expected, 1);
		}
		
		@Test
		void testSetName()  {
			PowerTools powertool = new PowerTools(1, "Drill", "Drilling","very", 115, "No",null, null);
			powertool.setName("Big drill");
			assertEquals("Big drill", powertool.getName());
		}
		
		@Test
		void testGetName() {
			PowerTools powertool = new PowerTools(1, "Drill", "Drilling","very", 115, "No",null, null);
			String expected = powertool.getName();
			assertEquals(expected, "Drill");
		}
		
		@Test
		void testSetUsedFor()  {
			PowerTools powertool = new PowerTools(1, "Drill", "Drilling","very", 115, "No",null, null);
			powertool.setUsedFor("Hard drilling");
			assertEquals("Hard drilling", powertool.getUsedFor());
		}
		
		@Test
		void testGetUsedFor() {
			PowerTools powertool = new PowerTools(1, "Drill", "Drilling","very", 115, "No",null, null);
			String expected = powertool.getUsedFor();
			assertEquals(expected, "Drilling");
		}
		
		@Test
		void testSetEasy()  {
			PowerTools powertool = new PowerTools(1, "Drill", "Drilling","very", 115, "No",null, null);
			powertool.setEasy("quite");
			assertEquals("quite", powertool.getEasy());
		}
		
		@Test
		void testGetEasy() {
			PowerTools powertool = new PowerTools(1, "Drill", "Drilling","very", 115, "No",null, null);
			String expected = powertool.getEasy();
			assertEquals(expected, "very");
		}
		
		@Test
		void testSetCost()  {
			PowerTools powertool = new PowerTools(1, "Drill", "Drilling","very", 115, "No",null, null);
			powertool.setCost(120);
			assertEquals(120, powertool.getCost());
		}
		
		@Test
		void testGetCost() {
			PowerTools powertool = new PowerTools(1, "Drill", "Drilling","very", 115, "No",null, null);
			Integer expected = powertool.getCost();
			assertEquals(expected, 115);
		}
		
		@Test
		void testSetDangerous()  {
			PowerTools powertool = new PowerTools(1, "Drill", "Drilling","very", 115, "No",null, null);
			powertool.setDangerous("Negligible");
			assertEquals("Negligible", powertool.getDangerous());
		}
		
		@Test
		void testGetDangerous() {
			PowerTools powertool = new PowerTools(1, "Drill", "Drilling","very", 115, "No",null, null);
			String expected = powertool.getDangerous();
			assertEquals(expected, "No");
		}
		
		@Test
		void testSetWorkshop()  {
			PowerTools powertool = new PowerTools(1, "Drill", "Drilling","very", 115, "No",null, null);
			powertool.setWorkshop(null);
			assertEquals(null, powertool.getWorkshop());
		}
		
		@Test
		void testGetWorkshop() {
			PowerTools powertool = new PowerTools(1, "Drill", "Drilling","very", 115, "No",null, null);
			Workshop expected = powertool.getWorkshop();
			assertEquals(expected, null);
		}
		
		@Test
		void testSetProjects()  {
			PowerTools powertool = new PowerTools(1, "Drill", "Drilling","very", 115, "No",null, null);
			powertool.setProject(null);
			assertEquals(null, powertool.getProject());
		}
		
		@Test
		void testGetProjects() {
			PowerTools powertool = new PowerTools(1, "Drill", "Drilling","very", 115, "No",null, null);
			Projects expected = powertool.getProject();
			assertEquals(expected, null);
		}
	
	
	
	
	
	
	
	}	

