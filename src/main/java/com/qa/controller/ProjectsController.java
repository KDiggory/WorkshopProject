package com.qa.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.data.Projects;
import com.qa.dto.ProjectWithWorkshopDTO;
import com.qa.service.ProjectsService;

@RestController
public class ProjectsController {
	
	private ProjectsService service;
	
	
	public ProjectsController(ProjectsService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/getProjectById/{id}")
	public Projects getProjectByIndex(@PathVariable Integer id) {
		return this.service.getProjectById(id);
		
	}
	
	
	
	@GetMapping("/getProjectByName/{name}")
	//@RequestMapping(value = "/name/{name}", method = RequestMethod.GET) 
	public List<Projects> findByName(@PathVariable String name) { 
		//service.findByName(name).forEach(n -> System.out.println(n)); 
		return this.service.findByName(name);
		
	}
	
	@GetMapping("/getProjectByWorkshop/{id}")
	public List<Projects> findByWorkshop(@PathVariable Integer id) { 
		//service.findByWorkshop(id).forEach(n -> System.out.println(n)); 
		return this.service.findByWorkshop(id);
		
	}
	
	@GetMapping("/getProjectByDays/{days}")
	public List<Projects> findByDays(@PathVariable Integer days) { 
		//service.findByDays(days).forEach(n -> System.out.println(n)); 
		return this.service.findByDays(days);
		
	}
	
	
	@GetMapping("/getAllProjects")
	public List<Projects> getAllProjects() {
		service.getAllProjects().forEach(n -> System.out.println(n)); 
		return this.service.getAllProjects();
		
	}
	
	@PostMapping("/createProject") 
	public ResponseEntity<Projects> createProject(@RequestBody Projects project) {
		Projects responseBody = this.service.createProject(project);
		ResponseEntity<Projects> response = new ResponseEntity<Projects>(responseBody, HttpStatus.CREATED);
		return response;
	}
	
	@PutMapping("/updateProject/{id}")
	public ResponseEntity<Projects> updateProject(@RequestBody Projects project, @PathVariable Integer id) {
	Projects responseBody = this.service.updateProject(project, id);
	ResponseEntity<Projects> response = new ResponseEntity<Projects>(responseBody, HttpStatus.ACCEPTED);
	return response;
	}
	
	@DeleteMapping("/removeProject/{id}")
	public ResponseEntity<Projects> deleteProject(@PathVariable Integer id) {
	boolean deleted = this.service.deleteProject(id, null);
	if(deleted) {
		return new ResponseEntity<>( HttpStatus.NO_CONTENT);
	} else {
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); 
	}

		
} 

}
