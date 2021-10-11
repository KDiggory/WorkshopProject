package com.qa.service;

import java.util.List;

import java.util.Optional;

import org.springframework.stereotype.Service;
import com.qa.data.Workshop;
import com.qa.repo.WorkshopRepo;

@Service
public class WorkshopService {
	
	public WorkshopRepo repo;
	private Workshop workshop;
	
	public WorkshopService(WorkshopRepo repo) {
		super();
		this.repo = repo;
	}

	public Optional<Workshop> getByIndex(Integer id) {
		return this.repo.findById(id); //orElseThrow in here
	}

	public List<Workshop> getAllWorkshops() {
		return this.repo.findAll();
	}

	public Workshop createWorkshop(Workshop workshop) {
		return this.repo.save(workshop);  
	}

	public boolean deleteWorkshop(Integer id) {
		this.repo.deleteById(id);
		boolean exists = this.repo.existsById(id);
		return !exists;
		
	}

	public Workshop updateWorkshop(Workshop workshop, Integer id) {
		Workshop toUpdate = this.repo.findById(id).get();
		toUpdate.setWorkshopName(workshop.getWorkshopName());
		toUpdate.setWorkshopAddress(workshop.getWorkshopAddress());
		return this.repo.save(toUpdate);
	}
	public Object getWorkshop() {
		return workshop;
	}

	public void setWorkshop(Workshop workshop) {
		this.workshop = workshop;
	}

	
}
