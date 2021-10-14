package com.qa;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.data.PowerTools;
import com.qa.data.Projects;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Sql(scripts = { "classpath:testschema.sql",
"classpath:testdata.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)

public class PowerToolsIntegration {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired 
	ObjectMapper mapper;
	
	@Test
	void testCreate() throws Exception {
		final PowerTools powertools = new PowerTools(1, "Drill", "Drilling","very", 115, "No",null);
		String testPowerToolsAsJson = this.mapper.writeValueAsString(powertools);
		
		final PowerTools savedPowerTools = new PowerTools(1, "Drill", "Drilling","very", 115, "No",null);
		String savedPowerToolsAsJson = this.mapper.writeValueAsString(savedPowerTools); 
		
		RequestBuilder request = post("/createPowerTool").contentType(MediaType.APPLICATION_JSON).content(testPowerToolsAsJson);
		
		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkContent = content().json(savedPowerToolsAsJson);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkContent); 
	
	} 
	
//	@Test
//	void testUpdate() throws Exception {
//		
//		final PowerTools updatedPowerTools = new PowerTools(1, "Drill", "Drilling","very", 115, "No",null);
//		String updatedPowerToolsAsJson = this.mapper.writeValueAsString(updatedPowerTools);
//		
//		RequestBuilder requestput = put("/updatePowerTool/1").contentType(MediaType.APPLICATION_JSON).content(updatedPowerToolAsJson);
//		
//		ResultMatcher checkStatusPut = status().isAccepted();
//		ResultMatcher checkContentPut = content().json(updatedPowerToolsAsJson);
//		
//		this.mvc.perform(requestput).andExpect(checkStatusPut).andExpect(checkContentPut); 
//}
	
	@Test
	void testGetAll() throws Exception {
		final PowerTools powertools = new PowerTools(1, "Drill", "Drilling","very", 115, "No",null);
		String testPowerToolsAsJson = this.mapper.writeValueAsString(List.of(powertools));
		
		RequestBuilder requestGet = get("/getAllPowerTools"); 
	
		ResultMatcher checkStatusGet = status().isOk();
		ResultMatcher checkContentGet = content().json(testPowerToolsAsJson);
		this.mvc.perform(requestGet).andExpect(checkStatusGet).andExpect(checkContentGet); 
		
	}

	@Test
	void testGetById() throws Exception {
			final PowerTools powertools = new PowerTools(1, "Drill", "Drilling","very", 115, "No",null);
			String testPowerToolsAsJson = this.mapper.writeValueAsString(powertools);
			
			RequestBuilder requestGet = get("/getPowerToolById/1"); 
		
			ResultMatcher checkStatusGet = status().isOk();
			ResultMatcher checkContentGet = content().json(testPowerToolsAsJson);
			this.mvc.perform(requestGet).andExpect(checkStatusGet).andExpect(checkContentGet); 
	}
	
	@Test
	void testDeletePowerTool() throws Exception {
		
		RequestBuilder requestDel = delete("/deletePowerTool/1").contentType(MediaType.APPLICATION_JSON);
		
		ResultMatcher checkStatusGet = status().isNoContent();
		
		this.mvc.perform(requestDel).andExpect(checkStatusGet);
	}

}
