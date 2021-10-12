package com.qa.repo;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.qa.data.Projects;


@Repository
public interface ProjectsRepo extends JpaRepository<Projects, Integer> {


}
