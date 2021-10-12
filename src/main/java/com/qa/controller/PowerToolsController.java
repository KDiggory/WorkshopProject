package com.qa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.data.PowerTools;
import com.qa.service.PowerToolsService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


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

}
