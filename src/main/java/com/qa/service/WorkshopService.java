package com.qa.service;

import java.util.ArrayList;
import java.util.List;


import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.qa.data.PowerTools;
import com.qa.data.Projects;
import com.qa.data.Workshop;
import com.qa.dto.PowerToolsDTO;
import com.qa.dto.ProjectsDTO;
import com.qa.dto.WorkshopDTO;
import com.qa.exceptions.ProjectNotFoundException;
import com.qa.exceptions.WorkshopNotFoundException;
import com.qa.repo.WorkshopRepo;

@Service
public class WorkshopService {
	
	public WorkshopRepo repo;
	private Workshop workshop;
	private ModelMapper mapper;
	
	public WorkshopService(WorkshopRepo repo, ModelMapper mapper) {
		super(); 
		this.repo = repo;
		this.mapper = mapper; 
	}
	
	WorkshopDTO mapToDTO(Workshop workshop) {
		WorkshopDTO dto = new WorkshopDTO();
		dto.setId(workshop.getId());
		dto.setAddress(workshop.getAddress());
		dto.setName(workshop.getName());
		List<ProjectsDTO> pDTOs = new ArrayList<>();
		List<PowerToolsDTO> ptDTOs = new ArrayList<>();
		
		for(Projects p : workshop.getProject()) {
			ProjectsDTO pDTO = new ProjectsDTO(); 
			pDTO.setId(p.getId());
			pDTO.setDays(p.getDays());
			pDTO.setEasy(p.getEasy());
			pDTO.setProjectMaterials(p.getMaterials());
			pDTO.setProjectName(p.getName());
			pDTOs.add(pDTO);
			
		for (PowerTools pt : workshop.getPowertools()) {
			PowerToolsDTO ptDTO = new PowerToolsDTO();
			ptDTO.setCost(pt.getCost());
			ptDTO.setDangerous(pt.getDangerous());
			ptDTO.setEasy(pt.getEasy());
			ptDTO.setName(pt.getName());
			ptDTO.setUsedFor(pt.getUsedFor());
			ptDTOs.add(ptDTO);
			
		}
		}
		
		
		dto.setProjects(pDTOs);
		dto.setPowertools(ptDTOs);
		return dto;
		
	}
	
	public WorkshopDTO getByIndex(Integer id) {
		Workshop saved = this.repo.findById(id).orElseThrow(() -> {
		      
		       return new WorkshopNotFoundException("No workshop found with that id");
		});
		return this.mapToDTO(saved);
	}
	
  

	public List<WorkshopDTO> getAllWorkshops() { 
		List<Workshop> saved = repo.findAll();
		List<WorkshopDTO> send = new ArrayList<>();
		for (Workshop workshop: saved) {
			send.add(mapToDTO(workshop));
		}
		return send; 
	}

	public Workshop createWorkshop(Workshop workshop) {
		return repo.save(workshop);
	}

	public boolean deleteWorkshop(Integer id) {
		this.repo.deleteById(id);
		boolean exists = this.repo.existsById(id);
		return !exists;
		
	}

	public Workshop updateWorkshop(Workshop workshop, Integer id) {
		Workshop toUpdate = this.repo.findById(id).get();
		toUpdate.setName(workshop.getName());
		toUpdate.setAddress(workshop.getAddress());
		
		return repo.save(toUpdate);
		
	}
	public Object getWorkshop() {
		return workshop;
	}

	public void setWorkshop(Workshop workshop) {
		this.workshop = workshop;
	}

	
}
