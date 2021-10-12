package com.qa;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WorkshopProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkshopProjectApplication.class, args);
		
		System.out.println("I Live!!");
	}
	
	

}
    