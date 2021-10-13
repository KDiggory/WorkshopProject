package com.qa.controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.qa.data.PowerTools;
import com.qa.data.Workshop;
import com.qa.service.PowerToolsService;




@CrossOrigin
@RestController
public class PowerToolsController {
	
private PowerToolsService service;
	
	
	public PowerToolsController(PowerToolsService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/createPowerTool") 
	public ResponseEntity<PowerTools> createPowerTool(@RequestBody PowerTools powertool) {
		PowerTools responseBody = this.service.createPowerTool(powertool);
		ResponseEntity<PowerTools> response = new ResponseEntity<PowerTools>(responseBody, HttpStatus.CREATED);
		return response;
	}
	
	@GetMapping("/getPowerToolById/{id}")
	public PowerTools getByIndex(@PathVariable Integer id) {
		return this.service.getPowerToolById(id);
	}
	
	@GetMapping("/getAllPowerTools")
	public List<PowerTools> getAllPowerTools() {
		return this.service.getAllPowerTools();
	}
	
	@PutMapping("/updatePowerTool/{id}")
	public ResponseEntity<PowerTools> updatePowerTool(@RequestBody PowerTools powertool, @PathVariable Integer id) {
	PowerTools responseBody = this.service.updatePowerTool(powertool, id);
	ResponseEntity<PowerTools> response = new ResponseEntity<PowerTools>(responseBody,HttpStatus.ACCEPTED);
	return response;
	}

	@DeleteMapping("/deletePowerTool/{id}")
	public ResponseEntity<PowerTools> deletePowerTool(@PathVariable Integer id) {
		boolean deleted = this.service.deletePowerTool(id, null);
		if(deleted) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	 
}
}
