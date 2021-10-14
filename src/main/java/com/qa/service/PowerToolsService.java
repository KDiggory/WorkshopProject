package com.qa.service;



import java.util.ArrayList;
import java.util.List;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.qa.data.PowerTools;
import com.qa.data.Projects;
import com.qa.data.Workshop;
import com.qa.dto.PowerToolsDTO;
import com.qa.dto.ProjectsDTO;
import com.qa.dto.WorkshopDTO;
import com.qa.exceptions.PowerToolNotFoundException;

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
		      
		       return new PowerToolNotFoundException("No powertool found with that id");
		});
		return saved;
	}
	


	PowerToolsDTO mapToDTO(PowerTools powertool) {
		PowerToolsDTO dto = new PowerToolsDTO();
		dto.setId(powertool.getId());
		dto.setCost(powertool.getCost());
		dto.setDangerous(powertool.getDangerous());
		dto.setEasy(powertool.getEasy());
		dto.setName(powertool.getName()); 
		dto.setUsedFor(powertool.getUsedFor());
		
	
		List<ProjectsDTO> pDTOs = new ArrayList<>();
		List<WorkshopDTO> wDTOs = new ArrayList<>();
		
		
		for(Projects p : powertool.getProject()) {
			ProjectsDTO pDTO = new ProjectsDTO();
			pDTO.setId(p.getId());
			pDTO.setDays(p.getDays());
			pDTO.setEasy(p.getEasy());
			pDTO.setProjectMaterials(p.getMaterials());
			pDTO.setProjectName(p.getName());
			pDTOs.add(pDTO);
		}
			
		for (Workshop ws : powertool.getWorkshop()) {
			WorkshopDTO wsDTO = new WorkshopDTO();
			wsDTO.setAddress(ws.getAddress());
			wsDTO.setName(ws.getName());
			wsDTO.setId(ws.getId());
			wDTOs.add(wsDTO);
		
		
		}
		dto.setProjects(pDTOs);
		dto.setWorkshops(wDTOs);
		return dto;
		
		
	}
	
	
	
	
}
