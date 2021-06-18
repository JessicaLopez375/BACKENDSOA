package com.edu.iua;


import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication(scanBasePackages={
		"com.edu.iua", "com.edu.iua.rest"})
public class BackendApplication{

	
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}


	

}
