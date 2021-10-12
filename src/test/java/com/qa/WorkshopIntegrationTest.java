package com.qa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import javax.sql.DataSource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.data.Workshop;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Sql(scripts = { "classpath:testschema.sql",
"classpath:testdata.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class WorkshopIntegrationTest {
	
	
	 
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired 
	ObjectMapper mapper;
	
	@Test
	void testCreate() throws Exception {
		final Workshop workshop = new Workshop(null, "Katies Workshop", "The garage", null);
		String testWorkshoptAsJson = this.mapper.writeValueAsString(workshop);
		
		final Workshop savedWorkshop = new Workshop(1, "Katies Workshop", "The garage", null);
		String savedWorkshopAsJson = this.mapper.writeValueAsString(savedWorkshop);
		
		RequestBuilder request = post("/createWorkshop").contentType(MediaType.APPLICATION_JSON).content(testWorkshoptAsJson);
		
		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkContent = content().json(savedWorkshopAsJson);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkContent); 

}
	
	@Test
	void testUpdateWorkshop() throws Exception {
		final Workshop workshop = new Workshop(1, "Katies other Workshop", "the kitchen table", null);
		final String testWorkshopAsJson = this.mapper.writeValueAsString(workshop);
		
		RequestBuilder requestput = put("/updateWorkshop/1").contentType(MediaType.APPLICATION_JSON).content(testWorkshopAsJson);
		
		ResultMatcher checkStatusPut = status().isAccepted();
		ResultMatcher checkContentPut = content().json(testWorkshopAsJson);
		
		this.mvc.perform(requestput).andExpect(checkStatusPut).andExpect(checkContentPut);
	}
	
	
	@Test
	void testGetAll() throws Exception {
		final Workshop workshop = new Workshop(null, "Katies Workshop", "The garage", null);
		String testWorkshoptAsJson = this.mapper.writeValueAsString(workshop);
		
		RequestBuilder requestGet = get("/getAllWorkshops").contentType(MediaType.APPLICATION_JSON).content(testWorkshoptAsJson);
		
		ResultMatcher checkStatusGet = status().isOk();
		ResultMatcher checkContentGet = content().json(testWorkshoptAsJson);
		this.mvc.perform(requestGet).andExpect(checkStatusGet).andExpect(checkContentGet); 
	}
	
	
	@Test
	void testGetById() throws Exception {
		final Workshop workshop = new Workshop(null, "Katies Workshop", "The garage", null);
		String testWorkshopAsJson = this.mapper.writeValueAsString(workshop);
		
		RequestBuilder requestGet = get("/getProjectById/{id}", 1).contentType(MediaType.APPLICATION_JSON).content(testWorkshopAsJson);
	
		ResultMatcher checkStatusGet = status().isOk();
		ResultMatcher checkContentGet = content().json(testWorkshopAsJson);
		this.mvc.perform(requestGet).andExpect(checkStatusGet).andExpect(checkContentGet); 
	}
	
	
	@Test
	void testRemoveWorkshop() throws Exception {
		RequestBuilder requestDel = delete("/removeWorkshop/1");
		
		ResultMatcher checkStatusGet = status().isNoContent();
		
		this.mvc.perform(requestDel).andExpect(checkStatusGet);
	}
}
