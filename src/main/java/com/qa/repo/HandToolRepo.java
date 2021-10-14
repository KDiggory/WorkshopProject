package com.qa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.data.HandTools;


@Repository
public interface HandToolRepo extends JpaRepository<HandTools, Integer>{

}
