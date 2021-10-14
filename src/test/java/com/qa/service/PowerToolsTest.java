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
//	void testGetById() {
//		final Integer id = 1;
//		final List<Workshop> workshop = new ArrayList();
//		
//		final List<PowerTools> powertools = List.of(new PowerTools(1, "Drill", "Drilling","very", 115, "No",workshop),
//				new PowerTools(2, "Drill", "Drilling","very", 115, "No",workshop));
//		List<PowerToolsDTO> toCheck = new ArrayList<>();
//		
//		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(powertools));
//
//		assertThat(this.service.getPowerToolById(id).equals(toCheck));
//		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
//	}
	
	
	@Test
	void testGetAllPowertools() {
		final List<PowerTools> powertools = List.of(new PowerTools(1, "Drill", "Drilling","very", 115, "No",null),
				new PowerTools(2, "Drill", "Drilling","very", 115, "No",null));

		Mockito.when(this.repo.findAll()).thenReturn(powertools);

		assertThat(this.service.getAllPowerTools()).isEqualTo(powertools);

		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	
	
	
	
		@Test
		void testUpdatePowertool() { 
			final Integer id = 1;
			PowerTools powertool = new PowerTools(1, "Drill", "Drilling","very", 115, "No",null);
			Optional<PowerTools> optionalpowertool = Optional.of(powertool);

			PowerTools newpowertool = new PowerTools(1, "Drill", "Drilling","very", 115, "No",null);

			Mockito.when(this.repo.findById(id)).thenReturn(optionalpowertool);
			Mockito.when(this.repo.save(newpowertool)).thenReturn(newpowertool);

			assertThat(this.service.updatePowerTool(newpowertool, powertool.getId()).equals(newpowertool));

			Mockito.verify(this.repo, Mockito.times(1)).findById(id);
			Mockito.verify(this.repo, Mockito.times(1)).save(newpowertool);
	}
		
		@Test
		void testCreatePowerTool() {
			final Integer id = 1;
			PowerTools powertool = new PowerTools(1, "Drill", "Drilling","very", 115, "No",null);
			PowerTools savedpowertool = new PowerTools(1, "Drill", "Drilling","very", 115, "No",null);

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
			PowerTools powertool = new PowerTools(1, "Drill", "Drilling","very", 115, "No",null);
			powertool.setId(2);
			assertEquals(2, powertool.getId());
		}
		
		@Test
		void testGetId() {
			PowerTools powertool = new PowerTools(1, "Drill", "Drilling","very", 115, "No",null);
			Integer expected = powertool.getId();
			assertEquals(expected, 1);
		}
		
		@Test
		void testSetName()  {
			PowerTools powertool = new PowerTools(1, "Drill", "Drilling","very", 115, "No",null);
			powertool.setName("Big drill");
			assertEquals("Big drill", powertool.getName());
		}
		
		@Test
		void testGetName() {
			PowerTools powertool = new PowerTools(1, "Drill", "Drilling","very", 115, "No",null);
			String expected = powertool.getName();
			assertEquals(expected, "Drill");
		}
		
		@Test
		void testSetUsedFor()  {
			PowerTools powertool = new PowerTools(1, "Drill", "Drilling","very", 115, "No",null);
			powertool.setUsedFor("Hard drilling");
			assertEquals("Hard drilling", powertool.getUsedFor());
		}
		
		@Test
		void testGetUsedFor() {
			PowerTools powertool = new PowerTools(1, "Drill", "Drilling","very", 115, "No",null);
			String expected = powertool.getUsedFor();
			assertEquals(expected, "Drilling");
		}
		
		@Test
		void testSetEasy()  {
			PowerTools powertool = new PowerTools(1, "Drill", "Drilling","very", 115, "No",null);
			powertool.setEasy("quite");
			assertEquals("quite", powertool.getEasy());
		}
		
		@Test
		void testGetEasy() {
			PowerTools powertool = new PowerTools(1, "Drill", "Drilling","very", 115, "No",null);
			String expected = powertool.getEasy();
			assertEquals(expected, "very");
		}
		
		@Test
		void testSetCost()  {
			PowerTools powertool = new PowerTools(1, "Drill", "Drilling","very", 115, "No",null);
			powertool.setCost(120);
			assertEquals(120, powertool.getCost());
		}
		
		@Test
		void testGetCost() {
			PowerTools powertool = new PowerTools(1, "Drill", "Drilling","very", 115, "No",null);
			Integer expected = powertool.getCost();
			assertEquals(expected, 115);
		}
		
		@Test
		void testSetDangerous()  {
			PowerTools powertool = new PowerTools(1, "Drill", "Drilling","very", 115, "No",null);
			powertool.setDangerous("Negligible");
			assertEquals("Negligible", powertool.getDangerous());
		}
		
		@Test
		void testGetDangerous() {
			PowerTools powertool = new PowerTools(1, "Drill", "Drilling","very", 115, "No",null);
			String expected = powertool.getDangerous();
			assertEquals(expected, "No");
		}
		
		@Test
		void testSetWorkshop()  {
			PowerTools powertool = new PowerTools(1, "Drill", "Drilling","very", 115, "No",null);
			powertool.setWorkshop(null);
			assertEquals(null, powertool.getWorkshop());
		}
		
		@Test
		void testGetWorkshop() {
			PowerTools powertool = new PowerTools(1, "Drill", "Drilling","very", 115, "No",null);
			List<Workshop> expected = powertool.getWorkshop();
			assertEquals(expected, null);
		}
	
	
	
	
	
	
	
	}	

