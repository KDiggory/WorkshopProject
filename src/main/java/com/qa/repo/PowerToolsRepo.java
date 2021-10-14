package com.qa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.data.PowerTools;

@Repository
public interface PowerToolsRepo extends JpaRepository<PowerTools, Integer> {

}
