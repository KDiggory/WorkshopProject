package com.qa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.data.Workshop;
import com.qa.service.WorkshopService;

@RestController
public class WorkshopController {
	
	private WorkshopService service;
	
	public WorkshopController(WorkshopService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/getWoprkshopById/{id}") 
	public Optional<Workshop> getByIndex(@PathVariable Integer id) {
		return this.service.getByIndex(id);	
	}
	
	@GetMapping("/getAllWoprkshops") 
	public List<Workshop> getAll() {
		return this.service.getAll();	
	}
	
	@PostMapping("/createWorkshop") 
	public ResponseEntity<Workshop> createWorkShop(@RequestBody Workshop workshop) {
	Workshop responseBody = this.service.createWorkshop(workshop);
	ResponseEntity<Workshop> response = new ResponseEntity<Workshop>(responseBody, HttpStatus.CREATED);
	return response;
	}
	@PutMapping("/updateWorkshop/{id}")
	public ResponseEntity<Workshop> updateWorkshop(@RequestBody Workshop workshop, @PathVariable Integer id) {
	Workshop responseBody = this.service.updateWorkshop(workshop, id);
	ResponseEntity<Workshop> response = new ResponseEntity<Workshop>(responseBody, HttpStatus.ACCEPTED);
	return response;	
	}
	
	@DeleteMapping("/removeWorkshop/{id}")
	public ResponseEntity<Workshop> deleteWorkshop(@PathVariable Integer id) {
	this.service.deleteWorkshop(id);
	ResponseEntity<Workshop> response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
	return response;
		}
	
	

}
