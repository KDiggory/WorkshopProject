package com.qa;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.data.Projects;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ProjectsIntegrationTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired 
	ObjectMapper mapper;
	
	@Test
	void testCreate() throws Exception {
		final Projects project = new Projects(null, "Desk", "Walnut", true, 3, null);
		String testProjectAsJson = this.mapper.writeValueAsString(project);
		
		final Projects savedProject = new Projects(1, "Desk", "Walnut", true, 3, null);
		String savedProjectAsJson = this.mapper.writeValueAsString(savedProject);
		
		RequestBuilder request = post("/createProject").contentType(MediaType.APPLICATION_JSON).content(testProjectAsJson);
		
		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkContent = content().json(savedProjectAsJson);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkContent); 
	
	}
	
	@Test
	void testUpdate() throws Exception {
		
		final Projects updatedProject = new Projects(1, "Desk", "Oak", true, 2, null);
		String updatedProjectAsJson = this.mapper.writeValueAsString(updatedProject);
		
		
		RequestBuilder requestput = put("/updateProject/{id}", 1).contentType(MediaType.APPLICATION_JSON).content(updatedProjectAsJson);
		
		ResultMatcher checkStatusPut = status().isAccepted();
		ResultMatcher checkContentPut = content().json(updatedProjectAsJson);
		
		this.mvc.perform(requestput).andExpect(checkStatusPut).andExpect(checkContentPut); 
}
	@Test
	void testGetAll() throws Exception {
		final Projects project = new Projects(1, "Desk", "Oak", true, 2, null);
		String testProjectAsJson = this.mapper.writeValueAsString(project);
		
		RequestBuilder requestGet = get("/getAllProjects").contentType(MediaType.APPLICATION_JSON).content(testProjectAsJson);
	
		ResultMatcher checkStatusGet = status().isOk();
		ResultMatcher checkContentGet = content().json(testProjectAsJson);
		this.mvc.perform(requestGet).andExpect(checkStatusGet).andExpect(checkContentGet); 
		
	}
	
	@Test
	void testGetById() throws Exception {
		final Projects project = new Projects(1, "Desk", "Oak", true, 2, null);
		String testProjectAsJson = this.mapper.writeValueAsString(project);
		
		RequestBuilder requestGet = get("/getProjectById/{id}", 1).contentType(MediaType.APPLICATION_JSON).content(testProjectAsJson);
	
		ResultMatcher checkStatusGet = status().isOk();
		ResultMatcher checkContentGet = content().json(testProjectAsJson);
		this.mvc.perform(requestGet).andExpect(checkStatusGet).andExpect(checkContentGet); 
	}
	
}
