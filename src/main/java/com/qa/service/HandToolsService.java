package com.qa.service;


import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.qa.data.HandTools;
import com.qa.exceptions.HandToolNotFoundException;
import com.qa.repo.HandToolRepo;


@Service
public class HandToolsService {
	
public HandToolRepo repo; 
	
	private ModelMapper mapper;
	
	

	public HandToolsService() {
		super();
		
	}

	public HandToolsService(HandToolRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	public HandTools createHandTool(HandTools handtool) {
		return this.repo.save(handtool);
		
	}

	public HandTools getHandToolById(Integer id) {
		HandTools saved =  this.repo.findById(id).orElseThrow(() -> {
		      
		       return new HandToolNotFoundException("No handtool found with that id");
		});
		return saved;
	} 

	public List<HandTools> getAllHandTools() {
		return this.repo.findAll();
	}

	public HandTools updateHandTool(HandTools handtool, Integer id) {
		HandTools toUpdate = this.repo.findById(id).get();
		toUpdate.setId(handtool.getId());
		toUpdate.setEasy(handtool.getEasy());
		toUpdate.setName(handtool.getName());
		toUpdate.setSize(handtool.getSize());
		toUpdate.setUsedFor(handtool.getUsedFor());
		toUpdate.setWorkshop(handtool.getWorkshop());
		toUpdate.setProject(handtool.getProject());
		return this.repo.save(toUpdate);
	}

	public boolean deleteHandTool(Integer id, Object object) {
		this.repo.deleteById(id);
		boolean exists = this.repo.existsById(id);
		return !exists;
	}

}
