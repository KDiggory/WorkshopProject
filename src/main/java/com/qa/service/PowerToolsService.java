package com.qa.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.qa.data.PowerTools;
import com.qa.data.Projects;
import com.qa.exceptions.ProjectNotFoundException;
import com.qa.repo.PowerToolsRepo;
@Service
public class PowerToolsService {
	
	public PowerToolsRepo repo;
	
	private ModelMapper mapper;
	
	public PowerToolsService(PowerToolsRepo repo, ModelMapper mapper ) {
		super();
		this.repo = repo;
		this.mapper = mapper; 
	}

	public PowerTools createPowerTool(PowerTools powertool) {
		return this.repo.save(powertool);
	}
	
	public PowerTools updatePowerTool(PowerTools powertool, Integer id) {
		PowerTools toUpdate = this.repo.findById(id).get();
		toUpdate.setName(powertool.getName());
		toUpdate.setEasy(powertool.getEasy());
		toUpdate.setUsedFor(powertool.getUsedFor());
		toUpdate.setCost(powertool.getCost());
		toUpdate.setDangerous(powertool.getDangerous());
		toUpdate.setId(powertool.getId());
		//toUpdate.setProject(powertool.getProject());
		toUpdate.setWorkshop(powertool.getWorkshop());
		return this.repo.save(toUpdate);
	}
	
	public boolean deletePowerTool(Integer id, Object object) {
		this.repo.deleteById(id);
		boolean exists = this.repo.existsById(id);
		return !exists;
	}
	
	public List<PowerTools> getAllPowerTools() {
		return this.repo.findAll();
	}

	public PowerTools getPowerToolById(Integer id) {
		PowerTools saved = this.repo.findById(id).orElseThrow(() -> {
		      
		       return new ProjectNotFoundException("No powertool found with that id");
		});
		return saved;
	}
}
