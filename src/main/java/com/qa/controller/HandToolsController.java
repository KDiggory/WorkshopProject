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

import com.qa.data.HandTools;
import com.qa.data.PowerTools;
import com.qa.service.HandToolsService;





	@CrossOrigin
	@RestController
	public class HandToolsController {
		
	private HandToolsService service;
		
		
		public HandToolsController(HandToolsService service) {
			super();
			this.service = service;
		}
		
		@PostMapping("/createHandTool") 
		public ResponseEntity<HandTools> createHandTool(@RequestBody HandTools handtool) {
			HandTools responseBody = this.service.createHandTool(handtool);
			ResponseEntity<HandTools> response = new ResponseEntity<HandTools>(responseBody, HttpStatus.CREATED);
			return response;
		}
		
		@GetMapping("/getHandToolById/{id}")
		public HandTools getByIndex(@PathVariable Integer id) {
			return this.service.getHandToolById(id);
		}
		
		@GetMapping("/getAllHandTools")
		public List<HandTools> getAllHandTools() {
			return this.service.getAllHandTools();
		}
		
		@PutMapping("/updateHandTool/{id}")
		public ResponseEntity<HandTools> updatePowerTool(@RequestBody HandTools handtool, @PathVariable Integer id) {
			HandTools responseBody = this.service.updateHandTool(handtool, id);
		ResponseEntity<HandTools> response = new ResponseEntity<HandTools>(responseBody,HttpStatus.ACCEPTED);
		return response;
		}

		@DeleteMapping("/deletePHandTool/{id}")
		public ResponseEntity<PowerTools> deletePowerTool(@PathVariable Integer id) {
			boolean deleted = this.service.deleteHandTool(id, null);
			if(deleted) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
			} else {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		 
	}
	}