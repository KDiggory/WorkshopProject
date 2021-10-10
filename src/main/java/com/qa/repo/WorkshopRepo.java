package com.qa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.qa.data.Workshop;

public interface WorkshopRepo extends JpaRepository<Workshop, Integer> {

}
