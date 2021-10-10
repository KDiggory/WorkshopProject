package com.qa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.data.Workshop;

@Repository
public interface WorkshopRepo extends JpaRepository<Workshop, Integer> {

	List<Workshop> findByName(String name);
	
}
