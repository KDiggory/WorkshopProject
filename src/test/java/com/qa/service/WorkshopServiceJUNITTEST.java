package com.qa.service;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.qa.data.Workshop;
import com.qa.repo.WorkshopRepo;

public class WorkshopServiceJUNITTEST {
	
	@Autowired	
	WorkshopRepo repo;
	WorkshopService service;
	
	@BeforeEach
	public void setup() {
		//WorkshopRepo repo = new WorkshopRepo();
		WorkshopService service = new WorkshopService(repo);
		System.out.println("Before test");
		
	}
		

	@Test
	public void testConstructor() {
		//WorkshopService service = new WorkshopService(repo);
		assertTrue(service instanceof WorkshopService);
	}
	
	@Test
	public void testConstructor2() {
		WorkshopRepo repo = new WorkshopRepo();
		assertTrue(repo instanceof WorkshopRepo);
	}
	
	
	
	@Test
	public void testGetByIndex() {
		Workshop input1 = new Workshop(1, "Katies Workshop", "The garage", null);
		Workshop input2 = new Workshop(1, "Katies Workshop", "The garage", null);
		Workshop expected = new Workshop(1, "Katies Workshop", "The garage", null);
		
		assertEquals(expected, service.getByIndex(1));
		
	}
	
	@Test
	public void testGetAll() {
		List<Workshop> list = new ArrayList<Workshop>;
		
		Workshop workshop = new Workshop(1, "Katies Workshop", "The garage", null);
		Workshop expected = new Workshop(1, "Katies  Workshop", "The garage", null);
		
		list.add(workshop);
		
		assertEquals(list, service.getAllWorkshops());
	}
	
	
	@Test
	public void testCreate(){
		Workshop input1 = new Workshop(1, "Katies Workshop", "The garage", null);
		Workshop input2 = new Workshop(1, "Katies Workshop", "The garage", null);
		this.repo.save(input1);
		Workshop expected = repo.findById(service.getByIndex(null).get());
	     assertEquals(1, expected.getWorkshopId(null));
	}
	
	
	
	
	@Test
	public void testDelete() {
		Workshop product = new Workshop(1, "Katies Workshop", "The garage", null);
	     this.repo.save(product);
	    
		repo.deleteById(product.getWorkshopId(null));
	      Optional<Workshop> optional = repo.findById(product.getWorkshopId(null));
	      assertEquals(Optional.empty(), optional);
	}
	@Test 
	public void testUpdate() {
		Workshop input1 = new Workshop(1, "Katies Workshop", "The garage", null);
		Workshop expected = new Workshop(1, "Katies Workshop", "The kitchen table", null);
		
		assertEquals(expected, service.updateWorkshop(input1, 1));
		
	}
	@Test
	public void testGet() {
		Workshop input1 = new Workshop(1, "Katies Workshop", "The garage", null);
		Workshop input2 = new Workshop(1, "Katies Workshop", "The garage", null);
		Workshop expected = new Workshop(1, "Katies Workshop", "The garage", null);
		
		assertEquals(expected, service.getWorkshop());
		
	}
	@Test
	public void testSet() {
		Workshop expected = new Workshop(1, "Katies Workshop", "The garage", null);
		assertEquals(expected, service.setWorkshop());
		
	}
}
