package com.qa.repo;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.qa.data.Projects;


@Repository
public interface ProjectsRepo extends JpaRepository<Projects, Integer> {

	@Query("SELECT p FROM Projects p WHERE p.name = ?1") // this has to be a capital P because thats the name of the class
	public List<Projects> findByName(String name);
	
	@Query("SELECT p FROM Projects p WHERE p.days = ?1")
	public List<Projects> findByDays(Integer days); 
	
	@Query("SELECT p FROM Projects p WHERE p.id = ?1")
	public List<Projects> findByWorkshop(Integer id); 
	
	
}
